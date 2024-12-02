// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDriveSubsystem;

public class DriveCommand extends Command {
  private ArcadeDriveSubsystem arcadeDriveSubsystem;
  private Joystick joystick;

  private double driveSpeed;
  private double turnSpeed;

  public DriveCommand(ArcadeDriveSubsystem arcadeDriveSubsystem, Joystick joystick) {
    this.arcadeDriveSubsystem = arcadeDriveSubsystem;
    this.joystick = joystick;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.arcadeDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.driveSpeed = 0;
    this.turnSpeed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSpeed = -joystick.getRawAxis(1);
    turnSpeed = -joystick.getRawAxis(4);

    arcadeDriveSubsystem.arcadeDrive(driveSpeed, turnSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
