// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ExampleDoubleCommand;
import frc.robot.commands.ExampleIntegerCommand;
import frc.robot.commands.ExampleRandomCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final Joystick variableChanger = new Joystick(Constants.operatorConstants.numberChangerPort);
  /* Declares a joystick (in this case, we use an XBox Controller) named variableChanger
   * The parameter is the joystick's port, which was pulled from Constants.operatorConstants.java
   */

  /* Joystick Bindings */
  private final int n_joystickDouble = XboxController.Axis.kLeftY.value; // Sets the n_joystickDouble value equal to the Y value of the left joystick

  /* Button Bindings */
  private final JoystickButton n_incrementInteger = new JoystickButton(variableChanger, XboxController.Button.kY.value);
  private final JoystickButton n_incrementIntegerFaster = new JoystickButton(variableChanger, XboxController.Button.kX.value);
  private final JoystickButton n_resetVariables = new JoystickButton(variableChanger, XboxController.Button.kA.value);
  private final JoystickButton n_restoreOldVariables = new JoystickButton(variableChanger, XboxController.Button.kB.value);
  private final JoystickButton n_getRandomInteger = new JoystickButton(variableChanger, XboxController.Button.kLeftBumper.value);
  private final JoystickButton n_getRandomDouble = new JoystickButton(variableChanger, XboxController.Button.kRightBumper.value);

  /* Subsystem Declaration; ALL subsystems NEED to be declared ONCE in the robot container */
  private final ExampleSubsystem e_ExampleSubsystem = new ExampleSubsystem();

  public RobotContainer() { // The "container" for the robot, containing the subsystems, commands, and input devices
  
    e_ExampleSubsystem.setDefaultCommand(
      new ExampleDoubleCommand(
        e_ExampleSubsystem, 
        () -> variableChanger.getRawAxis(n_joystickDouble)
      )
    );
    /* This sets the default command of e_ExampleSubsystem to ExampleDoubleCommand
     * ExampleDoubleCommand is operated using a joystick and has the parameters shown above
     * 
     * Notice the usage of "() ->"
     * This is a shortened way to call a function
     * Functions are needed whenever a supplier function is a parameter within the command's constructor
     * In this example, the ExampleDoubleCommand needs to use a function because of its DoubleSupplier
     */

    configureBindings(); // Configures the button bindings
  }

  private void configureBindings() { // Configures the button bindings
    n_incrementInteger.whileTrue(new ExampleIntegerCommand(e_ExampleSubsystem, 1));
    n_incrementIntegerFaster.whileTrue(new ExampleIntegerCommand(e_ExampleSubsystem, 2));
    n_getRandomInteger.onTrue(new ExampleRandomCommand(e_ExampleSubsystem, true));
    n_getRandomDouble.onTrue(new ExampleRandomCommand(e_ExampleSubsystem, false));
    n_resetVariables.onTrue(new InstantCommand(() -> e_ExampleSubsystem.clearExampleVariables()));
    n_restoreOldVariables.onTrue(new InstantCommand(() -> e_ExampleSubsystem.restoreOldVariables()));
    /* Sets the button bindings to activate a given command with the given parameters
     * Notice that there are multiple ways to configure the button bindings
     * The button configuration examples shown include using normal commands and instant commands
     * Normal commands run the selected COMMAND with the given parameters
     * Instant commands run a given method within the given SUBSYSTEM
     * It is often better practice to use NORMAL COMMANDS for button bindings, but it depends
     * Also notice that the whileTrue and onTrue methods were used
     * whileTrue means the command runs WHILE satisfied (for example, WHILE n_incrementInteger is TRUE)
     * onTrue means the command runs WHEN satisfied (for example, WHEN n_resetVariables is TRUE)
     */
  }

  public Command getAutonomousCommand() {
    // ExampleIntegerCommand runs when autonomous mode is enabled
    return new ExampleIntegerCommand(e_ExampleSubsystem, 1).withTimeout(15);
    /* Notice .withTimeout(15)
     * This stops the ExampleIntegerCommand if the time it takes to finish EXCEEDS 15 seconds
     * This is a good safe-guard against infinite loops/commands
     */
  }
}
