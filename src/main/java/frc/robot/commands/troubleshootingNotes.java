package frc.robot.commands;

public class troubleshootingNotes {
// 121830MAR24 Team 9568 Lead Mentor 1 troubleshooting log

//Observation:
//Our Launch Feed Wheel (NEO REV 1.1 Brushless Motor, SParkMax Controller, PWM)
// runs counter-clockwise during drivetrain operation (when we drive)
// whether we drive forward or backwards and turn left or right
// does not happen consistently but does happen everytime with changes to 
// when it starts and stops just a bit
//
//This happens in both Auto and TeleOp, so we've ruled out the driver controller
//
//This happens when we direct connect the laptop/ driver control station to the
// RoboRio 2.0, so we've ruled out communication errors from wifi  
//
//When we control the launch wheel motor directly through USB to the SparkMax
// using the laptop and the REV hardware app, works like it should
//
//All indicators point to multiple conflicting inputs (code or voltage or both)
//that are keeping the motor from running at and maintaining full speed
// This affects both overall power management but also our note shoots too low
//
//Voltage checks showed no problems with or PWM wiring and control wire
//
// Today's trouble-shooting will focus on identifying all speed set to the launch motor

// Here goes...
// Perhaps some cutting and pasting in order to apply our RollerClaw from the Launcher
//code could be to blame- heh.
//PWMRollerClaw line 55 commented out, stray Feeder public void
//
//Next test: void out all 
    //commands:
            //LaunchNote
            //PrepareLaunch
    //subsystems:
            //PWMLauncher
            //
//Results - drivetrain does not move launch motor
//----> Note: RobotContainer Lines 123-133 shared by PWMLauncher and PWMDrivetrain
//Next test: return all voided LaunchNote, PrepareLaunch, and PWMLauncher
//      Void out:
        //commands:
                //Autos
        //subsystems
                //PWMDrivetrain
        //unable to void out this group without messing with Auto and Robot
        //therefore returned all and commented out RobotContainer Lines 73-79
        //      isolates bindings for drivetrain
        //results in DifferentialDrive  output error
        //so moving on to switching driverController to operator Controller
        // results in counterclockwise when
                        //getIntake
                        //drivetrain
                //but not LaunchNote and not PrepareLaunch
                //all motor speeds include a counterclockwise
//all print logs indicate correct speed settings, does not change when motor 
//runs differently 

// 122215MAR24 Isolating the PrepareLaunch, LaunchNote, and PWM Launcher
//      First commenting out PrepareLaunch and Intake from PWM Launcher
        //Leaving PrepareLaunch and Launchnote isolated to see 
        //if drivetrain activates -1 speed from Intake in PWM Launcher
// 122245MAr24 Confirmed when all three components of Launch are commented out
// drivetrain sends nothing to launch motor
//      Re-enabling PWM Launcher with Get Intake but not
                        //launchnote
                //commented out GetIntake lines 32-47
                        //PWMLauncher lines 49-54 and 56-59 commented out
        //still runs motor when drivetrain enabled
                        //PWMLauncher commented out 
                        //commented out lines 63-68 public void stop
        //narrowing it down to PWMLauncher lines 17-22 commented out
                //narrowed down to PWMLauncher lines 19-22 
        //changed PWM port to 9, CAN ID on SparkMax to 9, 
                                //still engages in drivetrain
}
