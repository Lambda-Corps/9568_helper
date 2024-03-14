// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Team 9568 new roller claw code 08MAR24 for Lake City
// zero errors

package frc.robot.commands;

import static frc.robot.Constants.RollerClawConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMRollerClaw;

// import frc.robot.subsystems.CANLauncher;

/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class LaunchRollerClaw extends Command {
  PWMRollerClaw m_rollerclaw;

  // CANLauncher m_launcher;

  /** Creates a new LaunchRollerClaw. */
  public LaunchRollerClaw (PWMRollerClaw rollerclaw) {
    // save the launcher system internally
    m_rollerclaw = rollerclaw;

    // indicate that this command requires the roller claw system
    addRequirements(m_rollerclaw);
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to intake speed
    m_rollerclaw.setRollerClaw(-kRollerClawOutputPower);
    //this is set to NEGATIVE for Lake City 
   // m_launcher.setFeedWheel(kLaunchFeederSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // There is nothing we need this command to do on each iteration. You could remove this method
    // and the default blank method
    // of the base class will run.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the rollerclaw when the command ends.
    m_rollerclaw.stop();
  }
}
