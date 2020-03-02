/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;
  private final Timer m_timer1 = new Timer();

  private Command m_autoTankDrive;
  private Command m_TeloTankDrive;
  private Command m_StartComp;
  private Command m_AutoTurn;
  private Command m_AutoReverseTurn;
  private Command m_RunConveyor;
  //private Command m_IndexOn;
  //private Command m_IndexOff;
  private Command m_IntakeDeploy;
  //private Command m_BallPickerUpper;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer
    m_robotContainer = new RobotContainer();
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class. a child has fell into a river in lego city
   */
  @Override
  public void autonomousInit() {
    m_timer1.reset();
    m_timer1.start();

    m_AutoTurn = m_robotContainer.AutoTurn();
    m_autoTankDrive = m_robotContainer.AutoTankDrive();
    m_AutoReverseTurn = m_robotContainer.AutoReverseTurn();
    m_StartComp = m_robotContainer.StartComp();
    m_RunConveyor = m_robotContainer.RunConveyor();
    //m_IndexOn = m_robotContainer.IndexOn();
    //m_IndexOff = m_robotContainer.IndexOff();
    m_IntakeDeploy = m_robotContainer.IntakeDeploy();

    m_StartComp.schedule();
    m_IntakeDeploy.schedule();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    if (m_timer1.get() < Constants.TURNTIME){
     m_AutoTurn.schedule();
    }
    if ((m_timer1.get() > Constants.TURNTIME) && (m_timer1.get() < Constants.FORWARDTIME)){
     m_AutoTurn.cancel();
     m_autoTankDrive.schedule();
    }
 
    if(m_timer1.get() > Constants.FORWARDTIME && m_timer1.get() < Constants.PAUSETIME){
      m_autoTankDrive.cancel();
    }
    
    if(m_timer1.get() > Constants.PAUSETIME && m_timer1.get() < Constants.REVERSEAUTOTURN){
     m_AutoReverseTurn.schedule();
    }
 
    if(m_timer1.get() > Constants.REVERSEAUTOTURN && m_timer1.get() < Constants.FINALFORWARD){
      m_AutoReverseTurn.cancel();
      m_autoTankDrive.schedule();
    }
 
    if(m_timer1.get() > Constants.FINALFORWARD){
     m_autoTankDrive.cancel();
    }
   }
 
 


  @Override
  public void teleopInit() {
    m_TeloTankDrive = m_robotContainer.TeloTankDrive();
    m_TeloTankDrive.schedule();
    m_RunConveyor = m_robotContainer.RunConveyor();
    m_RunConveyor.schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
