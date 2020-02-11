/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
  private final Timer m_timer1 = new Timer();
  private RobotContainer m_robotContainer;

  private Command m_autoTankDrive;
  private Command m_TeloTankDrive;
  //private Command m_AutoColorSpin;
  //private Command m_StartComp;
  //private Command m_ActivateArm;
  //private Command m_ReverseArm;
  private Command m_AutoTurn;
  //private Command m_GetNavXData;
  //private Command m_RunConveyor;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
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
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_timer1.reset();
    m_timer1.start();

    m_autoTankDrive = m_robotContainer.getAutoTankDrive();
    //m_AutoColorSpin = m_robotContainer.getAutoSpin();
    //m_StartComp = m_robotContainer.getCompStart();
    //m_ActivateArm = m_robotContainer.ActivateArm();
    //m_ReverseArm = m_robotContainer.ReverseArm();
    m_AutoTurn = m_robotContainer.AutoTurn();
    //m_RunConveyor = m_robotContainer.RunConveyor();
    //m_GetNavXData = m_robotContainer.GetNavXData();

    //m_RunConveyor.schedule();
    //m_StartComp.schedule();
    //m_AutoColorSpin.schedule();
    //m_GetNavXData.schedule();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
   if (m_timer1.get() < 0.65){
    m_AutoTurn.schedule();
   }
   if (m_timer1.get() > 0.65){
    m_AutoTurn.cancel();
   }

   if((m_timer1.get() > 3.6) && (m_timer1.get() < 3.8)){
     m_AutoTurn.cancel();
     m_autoTankDrive.schedule();
   }
   
   if (m_timer1.get() > 3.8){
     m_autoTankDrive.cancel();
   }
  }

  @Override
  public void teleopInit() {
    m_TeloTankDrive = m_robotContainer.getTeloCommand();
    m_TeloTankDrive.schedule();
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
