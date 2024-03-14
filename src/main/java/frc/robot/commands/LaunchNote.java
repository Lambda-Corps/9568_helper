// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.PWMLauncher;

// import frc.robot.subsystems.CANLauncher;

/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class LaunchNote extends Command {
  PWMLauncher m_launcher;
  Timer m_timer; // Timer to manage prepare spin up time, and launch


  // CANLauncher m_launcher;

  /** Creates a new LaunchNote. */
  public LaunchNote(PWMLauncher launcher) {
    // save the launcher system internally
    m_launcher = launcher;

    // Create the timer object and start it
    m_timer = new Timer();
    m_timer.start();

    // indicate that this command requires the launcher system
    addRequirements(m_launcher);
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Reset the timer to 0
    m_timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Run the Launcher wheels for 3 seconds to allow them to spin up.
    // after 3 seconds, turn on the feed wheel. 
    m_launcher.setLaunchWheel(kLauncherSpeed); // This turns them on all the loops
    if(m_timer.hasElapsed(3)){
      m_launcher.setFeedWheel(kLaunchFeederSpeed);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Run the launcher wheels for a total of 5 seconds
    // Run the feed wheels for a total of 2 seconds.  
    // Command should end after 5 seconds, or if it gets interrupted
    return m_timer.hasElapsed(5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends or is interrupted.
    m_launcher.stop();
  }
}
