/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NavX;

public class GetNavXData extends CommandBase {
  private final NavX m_NavX;

  public GetNavXData(NavX subsystem) {
    m_NavX = subsystem;
    addRequirements(m_NavX);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_NavX.recalibrate();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_NavX.displayinfo();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_NavX.recalibrate();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
