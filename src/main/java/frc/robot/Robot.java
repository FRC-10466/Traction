// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Traction;


public class Robot extends TimedRobot {
  private final Traction tracao = new Traction();
  private final Timer timer = new Timer();

  private static final double TEMPO_AUTONOMO = 2.0; //segundos
  private static final double VELOCIDADE_AUTONOMO = 0.3;

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    timer.restart(); 
  }

  @Override
  public void autonomousPeriodic() {
    if (timer.get() < TEMPO_AUTONOMO) {
      tracao.andarDireto(VELOCIDADE_AUTONOMO);
    } else {
      tracao.StopTraction();
    }
  }

  @Override
  public void teleopPeriodic() {
    tracao.control();
  }
}
