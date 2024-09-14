// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Util.logf;

import java.util.Optional;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  public static int count = 0;
  public static RobotContainer robotContainer;
  public static Optional<Alliance> alliance;
  // Initializes an AnalogInput on port 0
  AnalogInput sensor = new AnalogInput(0);
  DigitalOutput led = new DigitalOutput(9);  // Added for testing led, remove when subsystem is created

  // Tasks
  // 0. Fix wheeks, add radio, get charger working
  // 1. Blink LED on DIO port 9
  //    - Create subsystem to control the led, add a blink method, a add a control method
  //    - Write a command to turn on led, turn off led, blink led
  // 2. See if encoder works on the right test motor
  // 3. Create a postion PID for the right test motor
  // 4. Get Slew rate working on the drive motors
  // 5. Get the NAVX to work and show gryo on the dash board
  // 6. Get odometry working
  // 7. Show robot positon on dash board
  // 8. Create a drive straight button to have the robot drive straight
  // 8. Write a drive straight command, move x feet at an angle of y
  // 9. Write a turn to command, rotate the robot in place by x degrees

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    alliance = DriverStation.getAlliance();
    logf("Start robot with alliance %s\n", alliance.toString());
  }

  @Override
  public void teleopInit() {
    logf("Start Teleop\n");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    count++;
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Sensor", sensor.getValue());
    SmartDashboard.putNumber("Average", sensor.getAverageVoltage());
    led.set(count % 100 > 50); // Added for testing led, remove when subsystem is created
  }
}