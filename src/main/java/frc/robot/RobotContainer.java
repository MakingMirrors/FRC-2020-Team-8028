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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmForward;
import frc.robot.commands.ArmReverse;
import frc.robot.commands.AutoReverseTurn;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.BallPickerUpper;
import frc.robot.commands.BallPickerUpperReverse;
import frc.robot.commands.IndexOff;
import frc.robot.commands.IndexOn;
import frc.robot.commands.IntakeDeploy;
import frc.robot.commands.IntakeRetract;
import frc.robot.commands.ReverseConveyor;
import frc.robot.commands.RunConveyor;
import frc.robot.commands.StartComp;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TeloTankDrive;
import frc.robot.commands.TeloTankDriveReverse;
import frc.robot.subsystems.ArmClimber;
import frc.robot.subsystems.BallPickUp;
import frc.robot.subsystems.CompressorStates;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Index;
import frc.robot.subsystems.IntakePne;

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
  private final CompressorStates m_CompressorStates = new CompressorStates();
  private final ConveyorBelt m_ConveyorBelt = new ConveyorBelt();
  private final ArmClimber m_ArmClimber = new ArmClimber();
  private final BallPickUp m_BallPickUp = new BallPickUp();
  private final Index m_Index = new Index();
  private final IntakePne m_IntakePne = new IntakePne();

  //Commands
  private final TankDrive m_TankDrive = new TankDrive(m_DriveBase);
  private final TeloTankDrive m_TeloTankDrive = new TeloTankDrive(m_DriveBase, controller1);
  private final TeloTankDriveReverse m_TeloTankDriveReverse = new TeloTankDriveReverse(m_DriveBase, controller1);
  private final StartComp m_StartComp = new StartComp(m_CompressorStates);
  private final AutoTurn m_AutoTurn = new AutoTurn(m_DriveBase);
  private final RunConveyor m_RunConveyor = new RunConveyor(m_ConveyorBelt);
  private final ReverseConveyor m_ReverseConveyor = new ReverseConveyor(m_ConveyorBelt);
  private final IndexOn m_IndexOn = new IndexOn(m_Index);
  private final IndexOff m_IndexOff = new IndexOff(m_Index);
  private final IntakeDeploy m_IntakeDeploy = new IntakeDeploy(m_IntakePne);
  private final IntakeRetract m_IntakeRetract = new IntakeRetract(m_IntakePne);
  private final ArmForward m_ArmForward = new ArmForward(m_ArmClimber);
  private final ArmReverse m_ArmReverse = new ArmReverse(m_ArmClimber);
  private final BallPickerUpper m_BallPickerUpper = new BallPickerUpper(m_BallPickUp);
  private final BallPickerUpperReverse m_BallPickerUpperReverse = new BallPickerUpperReverse(m_BallPickUp);
  private final AutoReverseTurn m_AutoReverseTurn = new AutoReverseTurn(m_DriveBase);

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
    new JoystickButton(controller2, 1).whenActive(m_IntakeDeploy);
    new JoystickButton(controller2, 2).whenActive(m_IntakeRetract);
    new JoystickButton(controller2, 5).whileHeld(m_BallPickerUpperReverse);
    new JoystickButton(controller2, 6).whileHeld(m_BallPickerUpper);
    new JoystickButton(controller1, 6).whenActive(m_TeloTankDrive);
    new JoystickButton(controller1, 6).cancelWhenActive(m_TeloTankDriveReverse);
    new JoystickButton(controller1, 5).whenActive(m_TeloTankDriveReverse);
    new JoystickButton(controller1, 5).cancelWhenActive(m_TeloTankDrive);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command AutoTankDrive() {
    return m_TankDrive;
  }
  public Command TeloTankDrive(){
    return m_TeloTankDrive;
  }
  public Command AutoTurn(){
    return m_AutoTurn;
  }
  public Command AutoReverseTurn(){
    return m_AutoReverseTurn;
  }
  public Command RunConveyor(){
    return m_RunConveyor;
  }
  public Command ReverseConveyor(){
    return m_ReverseConveyor;
  }
  public Command StartComp(){
    return m_StartComp;
  }
  public Command IndexOn(){
    return m_IndexOn;
  }
  public Command IndexOff(){
    return m_IndexOff;
  }
  public Command IntakeDeploy(){
    return m_IntakeDeploy;
  }
  public Command IntakeRetract(){
    return m_IntakeRetract;
  }
  public Command ArmForward(){
    return m_ArmForward;
  }
  public Command ArmReverse(){
    return m_ArmReverse;
  }
  // public Command BallPickerUpper(){
  //   return m_BallPickerUpper;
  // }
}
