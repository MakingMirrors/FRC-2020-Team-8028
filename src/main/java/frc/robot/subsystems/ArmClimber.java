/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmClimber extends SubsystemBase {
  Compressor Arm = new Compressor();
  DoubleSolenoid DSOL = new DoubleSolenoid(0, 1);


  public void StartCompressor(){
    Arm.start();
    Arm.setClosedLoopControl(true);
    DSOL.set(Value.kOff);
  }

  public boolean GetCompressorState(){
    boolean state = Arm.enabled();
    return state;
  } 

  public double GetCompressorCurrent(){
    double current = Arm.getCompressorCurrent();
    return current;
  }

  public boolean PressureSwitchValue(){
    boolean state = Arm.getPressureSwitchValue();
    return state;
  } 

  public void ActivateSoleniod(){
    DSOL.set(Value.kForward);
  }

  public void ReverseSolenoid(){
    DSOL.set(Value.kReverse);
  }
  
  public void CloseSolenoid(){
    DSOL.set(Value.kOff);
  }
  
  public void StopCompressor(){
    Arm.stop();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
