/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CompressorStates extends SubsystemBase {
  Compressor m_Compressor = new Compressor();

  public void StartCompressor(){
    m_Compressor.start();
    m_Compressor.setClosedLoopControl(true);
  }

  public boolean GetCompressorState(){
    boolean state = m_Compressor.enabled();
    return state;
  } 

  public double GetCompressorCurrent(){
    double current = m_Compressor.getCompressorCurrent();
    return current;
  }

  public boolean PressureSwitchValue(){
    boolean state = m_Compressor.getPressureSwitchValue();
    return state;
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
