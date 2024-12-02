// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  private final Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  /** Creates a new ClawSubsystem. */
  public ClawSubsystem() {
    // Start compressor
    this.compressor.enableDigital();
  }

  public void toggleClaw() {
    this.solenoid.toggle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
