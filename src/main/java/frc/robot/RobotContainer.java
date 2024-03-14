// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import static frc.robot.Constants.LauncherConstants.kIntakeLauncherSpeed;
//import static frc.robot.Constants.LauncherConstants.kLauncherSpeed;

//import static frc.robot.Constants.RollerClawConstants.kRollerClawOutputPower;
//  unused error Lake City 09MAR24
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.LauncherConstants;
import frc.robot.Constants.OperatorConstants;
//import frc.robot.Constants.RollerClawConstants; 
//  unused error Lake City 09MAR24
import frc.robot.commands.Autos;
import frc.robot.commands.IntakeRollerClaw;
import frc.robot.commands.LaunchNote;
import frc.robot.commands.LaunchRollerClaw;
import frc.robot.commands.PrepareLaunch;
//import frc.robot.commands.TestLaunch;
//  more glitchy code
import frc.robot.subsystems.PWMDrivetrain;
import frc.robot.subsystems.PWMLauncher;
import frc.robot.subsystems.PWMRollerClaw;
//import frc.robot.subsystems.PWMTestLauncher;
//added PWMTestLauncher to isolate motor fault removed to fix NO CODE error
//Team 9568 Added imports here for new LaunchRoller 08MAR24

// import frc.robot.subsystems.CANDrivetrain;
// import frc.robot.subsystems.CANLauncher;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems are defined here.
  private final PWMDrivetrain m_drivetrain = new PWMDrivetrain();
  // private final CANDrivetrain m_drivetrain = new CANDrivetrain();
  private final PWMLauncher m_launcher = new PWMLauncher();
  // private final CANLauncher m_launcher = new CANLauncher();
  
  
  //new code for RollerClaw
  private final PWMRollerClaw m_rollerclaw = new PWMRollerClaw();
  //results in two errors here in the RobotContainer - fixed

  //new glithy code for TestLaunch
  //private final PWMTestLauncher m_TestLauncher = new PWMTestLauncher();

  /*The gamepad provided in the KOP shows up like an XBox controller if the mode switch is set to X mode using the
   * switch on the top.*/
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    SmartDashboard.putData("Launcher", m_launcher);
    SmartDashboard.putData("Drivetrain", m_drivetrain);
    SmartDashboard.putData("Scheduler", CommandScheduler.getInstance());
    DriverStation.silenceJoystickConnectionWarning(true);
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be accessed via the
   * named factory methods in the Command* classes in edu.wpi.first.wpilibj2.command.button (shown
   * below) or via the Trigger constructor for arbitary conditions
   */
  private void configureBindings() {
    //Set the default command for the drivetrain to drive using the joysticks
    m_drivetrain.setDefaultCommand(
        new RunCommand(
            () ->
                m_drivetrain.arcadeDrive(
                    -m_driverController.getLeftY(), -m_driverController.getRightX()),   

                m_drivetrain).withName("DefaultDriveCmd"));

  
    /*Create an inline sequence to run when the operator presses and holds the A (green) button. Run the PrepareLaunch
     * command for 1 seconds and then run the LaunchNote command */

    // m_operatorController
    //     .a()
    //     .whileTrue(
    //       new RunCommand(
    //         () ->
    //         {
    //         m_launcher.setLaunchWheel(1);
    //         System.out.println("launch true");

    //       })
    //     )
    //     .onFalse(
    //       new RunCommand(
    //         () ->
    //         {
    //         m_launcher.setLaunchWheel(0);
    //         System.out.println("launch false");

    //       }));

    // m_operatorController
    //     .povLeft()
    //     .whileTrue(
    //       new RunCommand(
    //         () ->
    //         {
    //         m_launcher.setFeedWheel(-1);
    //         System.out.println("feed true");

    //       })
    //     )
    //     .onFalse(
    //       new RunCommand(
    //         () ->
    //         {
    //         m_launcher.setFeedWheel(0);
    //         System.out.println("feed false");

    //       }));
    m_operatorController.a().onTrue(new LaunchNote(m_launcher));
    // // Set up a binding to run the intake command while the operator is pressing and holding the
    // // left Bumper
    m_operatorController.leftBumper().whileTrue(m_launcher.getIntakeCommand());


  m_operatorController.rightBumper().whileTrue(new IntakeRollerClaw(m_rollerclaw));
    // Added Separate Commands and Separate Subsysystems
    // This should set up a binding to run the RollerClaw intake while operator is pressing and holding
    // right bumper 
    
   m_operatorController.b().whileTrue(new LaunchRollerClaw(m_rollerclaw));
   //method error 
   // This should set up a binding to run the RollerClaw exjest while operator is pressing and holding
    // the B Button
  

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
public Command getAutonomousCommand() {
   //An example command will be run in autonomous
   return Autos.exampleAuto(m_drivetrain);
  }
}
