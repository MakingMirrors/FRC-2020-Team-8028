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

public class ConveyorBelt extends SubsystemBase {
  private PWMVictorSPX conveyor = new PWMVictorSPX(Constants.CONVEYORPORT);

  public void setConveyor(double speed){
    conveyor.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
