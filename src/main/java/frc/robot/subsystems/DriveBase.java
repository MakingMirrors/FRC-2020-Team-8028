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
    private PWMVictorSPX leftSide = new PWMVictorSPX(Constants.LEFTMOTORCONTROLLER);
    private PWMVictorSPX rightSide = new PWMVictorSPX(Constants.RIGHTMOTORCONTROLLER);
  

  public void setLeftSide(double speed){
    leftSide.set(speed);
  }

  public void setRightSide(double speed){
    rightSide.set(-speed);
  }

  @Override
  public void periodic() {
  }
}
