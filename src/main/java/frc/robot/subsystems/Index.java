/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Index extends SubsystemBase {
  DoubleSolenoid DSOL = new DoubleSolenoid(0, 1);


  public void ActivateSoleniod(){
    DSOL.set(Value.kForward);
  }

  public void ReverseSolenoid(){
    DSOL.set(Value.kReverse);
  }
  
  public void CloseSolenoid(){
    DSOL.set(Value.kOff);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
