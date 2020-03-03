/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBase extends SubsystemBase {
    private PWMVictorSPX leftSide1 = new PWMVictorSPX(Constants.LEFTMOTORCONTROLLER0);
    private PWMVictorSPX leftSide2 = new PWMVictorSPX(Constants.LEFTMOTORCONTROLLER1);

    private PWMVictorSPX rightSide1 = new PWMVictorSPX(Constants.RIGHTMOTORCONTROLLER2);
    private PWMVictorSPX rightSide2 = new PWMVictorSPX(Constants.RIGHTMOTORCONTROLLER3);
  

  public void setLeftSide(double speed){
    leftSide1.set(speed);
    leftSide2.set(speed);
  }

  public void setRightSide(double speed){
    rightSide1.set(-speed);
    rightSide2.set(-speed);
  }

  @Override
  public void periodic() {
  }
}
