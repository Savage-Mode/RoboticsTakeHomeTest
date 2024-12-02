// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDriveSubsystem;

public class AutonomousCommand extends Command {
  private ArcadeDriveSubsystem arcadeDriveSubsystem;
  private long startTime;
  private ADIS16448_IMU gyro = new ADIS16448_IMU();
  private boolean finished = false;

  /** Creates a new AutonomousCommand. */
  public AutonomousCommand(ArcadeDriveSubsystem arcadeDriveSubsystem) {
    this.arcadeDriveSubsystem = arcadeDriveSubsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.arcadeDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyro.reset();
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    long currTime = System.currentTimeMillis();

    if (currTime - startTime < 15000) {
      arcadeDriveSubsystem.arcadeDrive(0.7, 0);
    } else if (gyro.getAngle() < 180.0) {
      arcadeDriveSubsystem.arcadeDrive(0, 0.5);
    } else {
      this.finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.finished;
  }
}
