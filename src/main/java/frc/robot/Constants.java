// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
    // swapped ports for testing axis 4 13FEB24 changed Driver to 0 and Controller to 1 
  }

  public static class DrivetrainConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kLeftRearID = 2;
    public static final int kLeftFrontID = 3;
    public static final int kRightRearID = 0;
    public static final int kRightFrontID = 1;
    //i Robot Team 9568 Motor Controllers 0:1 1:5 2:18 3:14 for Kettering

    // Current limit for drivetrain motors
    public static final int kCurrentLimit = 40;
    // Team 9568 set to match motor controllers - default 60
  }

  public static class LauncherConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kFeederID = 4;
    public static final int kLauncherID = 8;
    //Use CANID 8 rather than PWM ID 8 for this motor. PDH is slot 10
    // troubleshooting to ID9 for 11MAR24 with neo brushless to power 10 nope
    //iRobot Team 9568 Launch Motor Controllers 4:9 5:10 for Lake City where 4 is the PWM and 9 is the Power Distribution Hub

    // Current limit for launcher and feed wheels
    public static final int kLauncherCurrentLimit = 80;
    public static final int kFeedCurrentLimit = 80;
    //Team 9568 Changed CurrentLimits from 80 to 40; shoots too low, returned to 80 as per p51 
    // of KitBot Instructions for Troubleshooting

    // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kLauncherSpeed = -1; 
    public static final double kLaunchFeederSpeed = -1;
    public static final double kIntakeLauncherSpeed = 1; 
    public static final double kIntakeFeederSpeed = 0.2;
    // 112132MR24 set all four speeds to zero to see if both motors actually don't move
    // iRobot Team 9568 Launcher appears to be reversed, Change Speed Values from 1 to -1 and vice versa
    
    //public static final double kTestLauncherSpeed = 0;
    // begin test phase 11MAR24

    public static final double kLauncherDelay = 3;

  }
  //new code for Lake City
    public static class RollerClawConstants  {
      //Start here for troubleshooting our new iRobot's RollerClaw

      // PWM Ports/ CAN IDs for motor controller
      public static final int kRollerClawID = 6;
      //the 775Red RollerClaw Motor is in PWM 6 and PowerBus 3 with 30AMP fuse as we had no more 40 amp fuses

      //current limit for RollerClaw motor
      public static final int kRollerClawCurrentLimit = 80;
      // Team 9568 best guess for 775Red motor from EveryBot Kit

      //Speeds for green wheel intake pair for roller claw
      public static final double kRollerClawOutputPower = .5;
      //this is for intake and output as per EveryBot-2024-Code Line 134 and Lines 404-419
      public static final double kRollerClawStallPower = 0.1;
      //this is for hold to return notes in the claw as per EveryBot-20204-Code Line 138
    }
  }
