package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class ExampleRandomCommand extends Command {
    private ExampleSubsystem e_ExampleSubsystem;
    private boolean useIntegerRandomizer;
    
    /* REFER TO THE COMMENTS WITHIN ExampleDoubleCommand IF CONFUSED!!! */
    public ExampleRandomCommand(ExampleSubsystem e_ExampleSubsystem, boolean useIntegerRandomizer) {
        this.e_ExampleSubsystem = e_ExampleSubsystem;
        addRequirements(e_ExampleSubsystem);
        this.useIntegerRandomizer = useIntegerRandomizer;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (useIntegerRandomizer) {
            e_ExampleSubsystem.getRandomInteger(Constants.numberConstants.lowerRandomIntegerBounds, Constants.numberConstants.upperRandomIntegerBounds);
        } else {
            e_ExampleSubsystem.getRandomDouble(Constants.numberConstants.lowerRandomDoubleBounds, Constants.numberConstants.upperRandomDoubleBounds);
        }
        /* This if-else statement set determines if the getRandomInteger() or getRandomDouble() method is used
         * lowerRandomIntegerBounds, upperRandomIntegerBounds, lowerRandomDoubleBounds, and upperRandomDoubleBounds are found in Constants.numberConstants
         */
    }

    @Override
    public boolean isFinished() { 
        return false;
    } 

    @Override
    public void end(boolean interrupted) { 
        
    }
}
