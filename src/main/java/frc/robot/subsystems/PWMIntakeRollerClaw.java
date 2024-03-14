// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Team 9568 modifications for RollerClaw 08MAR24 for Lake City

package frc.robot.subsystems;

import static frc.robot.Constants.RollerClawConstants.*;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PWMIntakeRollerClaw extends SubsystemBase {
  PWMSparkMax m_RollerClaw;
  //PWMSparkMax m_feedWheel;
// launchwheel changed throughout to RollerClaw and feedwheel left in comments for reference

  /** Creates a new RollerClaw. */
  public PWMIntakeRollerClaw() {
    m_RollerClaw = new PWMSparkMax(kRollerClawID);
   // m_feedWheel = new PWMSparkMax(kFeederID);
  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */

  public Command getRollerClawIntakeCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setRollerClaw(-kRollerClawOutputPower);
         // setLaunchWheel(kIntakeLauncherSpeed); 
         //This is NEGATIVE for Lake City
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

  // An accessor method to set the speed (technically the output percentage) of the RollerClaw
  public void setRollerClaw(double speed) {
    m_RollerClaw.set(speed);
  }

  // An accessor method to set the speed (technically the output percentage) of the feed wheel
 // public void setFeedWheel(double speed) {
 //   m_feedWheel.set(speed);
 // }

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_RollerClaw.set(0);
  //  m_feedWheel.set(0);
  }
}

