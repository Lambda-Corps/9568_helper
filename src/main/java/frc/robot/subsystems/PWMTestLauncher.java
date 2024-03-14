// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import static frc.robot.Constants.LauncherConstants.*;

// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class PWMTestLauncher extends SubsystemBase {
//   PWMSparkMax m_launchWheel;


//   /** Creates a new TestLauncher. */
//   public PWMTestLauncher() {
//     m_launchWheel = new PWMSparkMax(kLauncherID);
//     m_launchWheel.setInverted(true);

//   }


//   public Command getTestLaunchCommand() {
//     // The startEnd helper method takes a method to call when the command is initialized and one to
//     // call when it ends
//     return this.startEnd(
//         // When the command is initialized, set the wheels to the intake speed values
//         () -> {
//           setLaunchWheel(kTestLauncherSpeed);
//         },
//         // When the command stops, stop the wheels
//         () -> {
//           stop();
//         });
//  }

//   // An accessor method to set the speed (technically the output percentage) of the launch wheel
//   public void setLaunchWheel(double speed) {
//     m_launchWheel.set(speed);
//   }

// //   // An accessor method to set the speed (technically the output percentage) of the feed wheel
// //   public void setFeedWheel(double speed) {
// //     m_feedWheel.set(speed);
// //   }

//   // A helper method to stop both wheels. You could skip having a method like this and call the
//   // individual accessors with speed = 0 instead
//   public void stop() {
//     m_launchWheel.set(0);

//   }
// }
