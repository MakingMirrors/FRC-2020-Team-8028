/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class TeloTankDrive extends CommandBase {
  private final DriveBase m_TeloDriveBase;
  private final Joystick m_controller;
  
  public TeloTankDrive(DriveBase subsystem, Joystick controller){
    m_TeloDriveBase = subsystem;
    m_controller = controller;
    addRequirements(m_TeloDriveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turn;
    double l_stick = m_controller.getRawAxis(1);
    double r_stick = m_controller.getRawAxis(4);
    if (java.lang.Math.abs(l_stick) < 0.1){
      l_stick = 0;
      //turn = r_stick / 2.5;
      turn = r_stick;
    }
    else{
      //turn = r_stick/ 3;
      turn = r_stick;
    }

    double speed = -l_stick * java.lang.Math.abs(l_stick) * java.lang.Math.abs(l_stick) * java.lang.Math.abs(l_stick);
    SmartDashboard.putNumber("Raw Left Y Stick Value", m_controller.getRawAxis(1));
    SmartDashboard.putNumber("Raw Right X Stick Value", m_controller.getRawAxis(4));

    if (l_stick == 0){
      m_TeloDriveBase.setLeftSide(turn);
      m_TeloDriveBase.setRightSide(-turn);
    }
    else if(speed > 0 && turn < 0){
      m_TeloDriveBase.setLeftSide(speed + turn);
      m_TeloDriveBase.setRightSide(speed);
    }
    else if(speed > 0 && turn > 0){
      m_TeloDriveBase.setLeftSide(speed);
      m_TeloDriveBase.setRightSide(speed - turn);
    }
    else if(speed < 0 && turn < 0){
      m_TeloDriveBase.setLeftSide(speed);
      m_TeloDriveBase.setRightSide(speed - turn);
    }
    else if(speed < 0 && turn > 0){
      m_TeloDriveBase.setLeftSide(speed + turn);
      m_TeloDriveBase.setRightSide(speed);
    }
    else{
      m_TeloDriveBase.setLeftSide(speed);
      m_TeloDriveBase.setRightSide(speed);
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TeloDriveBase.setLeftSide(0);
    m_TeloDriveBase.setRightSide(0);
  }

  // Returns true when the command should end.
   public boolean isFinished() {
    return false;
  }
}
