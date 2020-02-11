/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CompressorStates;

public class StartComp extends CommandBase {
  private final CompressorStates m_CompressorStates;

  public StartComp(CompressorStates subsystem){
    m_CompressorStates = subsystem;
    addRequirements(m_CompressorStates);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_CompressorStates.StartCompressor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Compressor Working", m_CompressorStates.GetCompressorState());
    SmartDashboard.putBoolean("Pressure Switch Value", m_CompressorStates.PressureSwitchValue());
    SmartDashboard.putNumber("Compressor Current", m_CompressorStates.GetCompressorCurrent());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
