// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ToggleClawCommand;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ArcadeDriveSubsystem arcadeDriveSubsystem = new ArcadeDriveSubsystem();
  private final ClawSubsystem clawSubsystem = new ClawSubsystem();
  private final Joystick joystick = new Joystick(0);
  private final XboxController xboxController = new XboxController(1);
  private final DriveCommand driveCommand = new DriveCommand(arcadeDriveSubsystem, joystick);
  private final AutonomousCommand autonomousCommand = new AutonomousCommand(arcadeDriveSubsystem);
  private final ToggleClawCommand toggleClawCommand = new ToggleClawCommand(clawSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    arcadeDriveSubsystem.setDefaultCommand(driveCommand);
    
    new JoystickButton(xboxController, XboxController.Button.kA.value).onTrue(toggleClawCommand);
  }

  public Command getAutonomousCommand() {
    return autonomousCommand;
  }
}
