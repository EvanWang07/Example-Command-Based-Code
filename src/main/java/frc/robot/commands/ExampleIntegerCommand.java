package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class ExampleIntegerCommand extends Command {
    private ExampleSubsystem e_ExampleSubsystem;
    private int incrementValue;

    /* REFER TO THE COMMENTS WITHIN ExampleDoubleCommand IF CONFUSED!!! */
    public ExampleIntegerCommand(ExampleSubsystem e_ExampleSubsystem, int incrementValue) {
        this.e_ExampleSubsystem = e_ExampleSubsystem;
        addRequirements(e_ExampleSubsystem);
        this.incrementValue = incrementValue;
    }

    @Override
    public void initialize() { 

    }

    @Override
    public void execute() { 
        e_ExampleSubsystem.incrementExampleInteger(incrementValue);
    }

    @Override
    public boolean isFinished() { 
        if (e_ExampleSubsystem.returnExampleInteger() > Constants.numberConstants.maximumIntegerValue) {
            return true;
        } else {
            return false;
        }
        /* This if-else statement set finishes the command if ExampleInteger within e_ExampleSubsystem exceeds maximumIntegerCommandValue
         * maximumIntegerCommandValue is found within Constants.numberConstants
         */
    }

    @Override
    public void end(boolean interrupted) { 
        e_ExampleSubsystem.changeExampleInteger(0); // Changes ExampleInteger to 0 when the command finishes or is interrupted
    }
}
