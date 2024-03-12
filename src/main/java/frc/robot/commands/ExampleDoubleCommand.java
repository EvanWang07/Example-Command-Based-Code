package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

public class ExampleDoubleCommand extends Command { // Commands use subsystems to accomplish set tasks depending on the code within the command
    private ExampleSubsystem e_ExampleSubsystem;
    private DoubleSupplier newDoubleValue;
    /* NOTICE the use of a DoubleSupplier; DoubleSuppliers are a type of supplier function
     * Supplier functions ensure that the value UPDATES CONSTANTLY!!!
     * Using normal variables (EX: double) results in the value becoming STATIC upon passing through the constructor
     */

    /* Constructor that creates a new command; commands run on METHODS within the used subsystem(s) */
    public ExampleDoubleCommand(ExampleSubsystem e_ExampleSubsystem, DoubleSupplier newDoubleValue) {
        this.e_ExampleSubsystem = e_ExampleSubsystem;
        addRequirements(e_ExampleSubsystem); // Makes it so e_ExampleSubsystem must NOT be in use by other commands
        this.newDoubleValue = newDoubleValue;
        /* NOTICE that this.[VARIABLE_NAME] was used
         * Also, NOTICE that the parameters within the ExampleDoubleCommand constructor have the same name as ExampleDoubleCommand's attributes
         * this.[VARIABLE_NAME] is used whenever variable names in the constructor AND class attribute names are the same
         * This ensures Java knows what variable is being used! 
         * Reference: https://www.w3schools.com/java/ref_keyword_this.asp
         */
    }

    @Override
    public void initialize() { // Code that runs immediately before the bulk of a command takes place
        /* While the constructor and the intialize() method may look the same, they are NOT!
         * Constructors are only called when the robot's code is deployed!
         * initialize() methods are called once every time the given command is used!
         * This means it is best to use initialize() to reset a given command function
         * AND to declare subsystems in the constructor only ONE copy of each subsystem should exist!
         */
    }

    @Override
    public void execute() { // This runs 50 times a second. This is where joystick inputs should be considered!
        double e_newDoubleValue = newDoubleValue.getAsDouble(); // Converts a DoubleSupplier to a normal double
        e_ExampleSubsystem.changeExampleDouble(e_newDoubleValue);
    }

    @Override
    public boolean isFinished() { // Runs while execute() runs. This checks whether the command has finished; true = finished, false = not finished
        return false; // Notice that this means the command NEVER finishes
    } 

    @Override
    public void end(boolean interrupted) { // This gets called when (either) another command using a common subsystem is used or when the command finishes
        
    }
}
