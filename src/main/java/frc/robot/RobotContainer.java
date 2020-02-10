/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoColorSpin;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.GetNavXData;
import frc.robot.commands.RunConveyor;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TeloTankDrive;
import frc.robot.subsystems.ColorSpinner;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.NavX;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Controllers
  Joystick controller1 = new Joystick(Constants.CONTROLPORT1);
  Joystick controller2 = new Joystick(Constants.CONTROLPORT2);
  //Subsystems
  private final DriveBase m_DriveBase = new DriveBase();
  private final ColorSpinner m_ColorSpinner = new ColorSpinner();
  //private final ArmClimber m_ArmClimber = new ArmClimber();
  private final NavX m_NavX = new NavX();
  private final ConveyorBelt m_ConveyorBelt = new ConveyorBelt();

  //Commands
  private final AutoColorSpin m_AutoColorSpin = new AutoColorSpin(m_ColorSpinner);
  private final TankDrive m_TankDrive = new TankDrive(m_DriveBase);
  private final TeloTankDrive m_TeloTankDrive = new TeloTankDrive(m_DriveBase, controller1);
  //private final StartComp m_StartComp = new StartComp(m_ArmClimber);
  //private final ActivateArm m_ActivateArm = new ActivateArm(m_ArmClimber);
  //private final ReverseArm m_ReverseArm = new ReverseArm(m_ArmClimber);
  private final AutoTurn m_AutoTurn = new AutoTurn(m_DriveBase);
  private final GetNavXData m_GetNavXData = new GetNavXData(m_NavX);
  private final RunConveyor m_RunConveyor = new RunConveyor(m_ConveyorBelt);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(controller2, 1).whenActive(m_ActivateArm);
    //new JoystickButton(controller2, 2).whenActive(m_ReverseArm);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutoTankDrive() {
    // An ExampleCommand will run in autonomous
    return m_TankDrive;
  }
  public Command getTeloCommand(){
    return m_TeloTankDrive;
  }
  public Command getAutoSpin(){
    return m_AutoColorSpin;
  }
  //public Command getCompStart(){
    //return m_StartComp;
  //}
  //public Command ActivateArm(){
    //return m_ActivateArm;
  //}
  //public Command ReverseArm(){
    //return m_ReverseArm;
  //}
  public Command AutoTurn(){
    return m_AutoTurn;
  }
  public Command GetNavXData(){
    return m_GetNavXData;
  }
  public Command RunConveyor(){
    return m_RunConveyor;
  }
}
