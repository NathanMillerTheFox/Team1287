// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.Console;

import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.GenericSubscriber;
import edu.wpi.first.networktables.LogMessage;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing how to use Mecanum control with the
 * MecanumDrive class.
 */
public class Robot extends TimedRobot {
  private PIDController PID = new PIDController(0, 0, 0);
  private ShuffleboardTab pidDashboard = Shuffleboard
  .getTab("visionTrackingDashboard");

  
  GenericEntry PIDEntry = pidDashboard
  .addPersistent("PIDController", 0)
  .getEntry();
  private GenericSubscriber I = pidDashboard
  .addPersistent("I",0)
  .withWidget(BuiltInWidgets.kNumberSlider)
  .withPosition(0, 1)
  .getEntry();

  private GenericSubscriber D = pidDashboard
  .addPersistent("D",0)
  .withWidget(BuiltInWidgets.kNumberSlider)
  .withPosition(0, 2)
  .getEntry();
  
  private static final int kFrontLeftChannel = 1;
  private static final int kRearLeftChannel = 4;
  private static final int kFrontRightChannel = 6;
  private static final int kRearRightChannel = 5;


  private static final int kjs_rearleft = 1;
  private static final int kjs_rearright = 2;
  private static final int kjs_frontleft = 3;
  private static final int kjs_frontright = 4;
  private static final int kJoystickChannel = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;
  PWMSparkMax frontLeft = new PWMSparkMax(kFrontLeftChannel);
  PWMSparkMax rearLeft = new PWMSparkMax(kRearLeftChannel);
  PWMSparkMax frontRight = new PWMSparkMax(kFrontRightChannel);
  PWMSparkMax rearRight = new PWMSparkMax(kRearRightChannel);

  @Override
  public void robotInit() {

    SendableRegistry.addChild(m_robotDrive, frontLeft);
    SendableRegistry.addChild(m_robotDrive, rearLeft);
    SendableRegistry.addChild(m_robotDrive, frontRight);
    SendableRegistry.addChild(m_robotDrive, rearRight);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft::set, rearLeft::set, frontRight::set, rearRight::set);

    m_stick = new Joystick(kJoystickChannel);

  }

  @Override
  public void teleopPeriodic() {
    //P.getDouble(0);
    //PID.setPID(P.getDouble(0),I.getDouble(0),D.getDouble(0));
    //System.out.println(P.getDouble(0));
    
    System.out.println(PIDEntry.getDouble(0));

// open git bash in parent folder then:
// git config --globals user.name "Team1287"
// git config --globals user.email "team1287aluminumassault@gmail.com"
// git clone gitrepohyperlink
//Use info:81









    // Use the joystick Y axis for forward movement, X axis for lateral
    // movement, and Z axis for rotation.
    /*
    if (m_stick.getRawButton(kjs_frontleft)) {
      frontLeft.set(.25);
    } else if (m_stick.getRawButton(kjs_frontright)) {
      frontRight.set(.25);
    } else if (m_stick.getRawButton(kjs_rearleft)) {
      rearLeft.set(.25);
    } else if (m_stick.getRawButton(kjs_rearright)) {
      rearRight.set(.25);
    } else {
      m_robotDrive.driveCartesian(-m_stick.getY(), -m_stick.getX(), -m_stick.getZ());
    }
    */
  }
}
