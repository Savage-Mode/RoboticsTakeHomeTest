// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDriveSubsystem extends SubsystemBase {
  
  private final CANSparkMax leftFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax leftBackMotor = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax rightFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax rightBackMotor = new CANSparkMax(0, MotorType.kBrushless);
  
  private RelativeEncoder leftFrontEncoder = leftFrontMotor.getEncoder();
  private RelativeEncoder rightFrontEncoder = rightFrontMotor.getEncoder();

  DifferentialDrive differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

  /** Creates a new ArcadeDriveSubsystem. */
  public ArcadeDriveSubsystem() {
    leftFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();

    rightFrontMotor.setInverted(true);
    leftFrontMotor.setInverted(false);

    // Make back motors follow front motors
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    leftFrontEncoder.setPosition(0);
    rightFrontEncoder.setPosition(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive (double driveSpeed, double turnSpeed) {
    differentialDrive.arcadeDrive(driveSpeed, turnSpeed);
  }

  public void stopAllMotors() {
    differentialDrive.stopMotor();
  }
}
