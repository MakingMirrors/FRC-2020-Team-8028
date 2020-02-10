/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmClimber;

public class StartComp extends CommandBase {
  private final ArmClimber m_ArmClimber;

  public StartComp(ArmClimber subsystem){
    m_ArmClimber = subsystem;
    addRequirements(m_ArmClimber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ArmClimber.StartCompressor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Compressor Working", m_ArmClimber.GetCompressorState());
    SmartDashboard.putBoolean("Pressure Switch Value", m_ArmClimber.PressureSwitchValue());
    SmartDashboard.putNumber("Compressor Current", m_ArmClimber.GetCompressorCurrent());
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
