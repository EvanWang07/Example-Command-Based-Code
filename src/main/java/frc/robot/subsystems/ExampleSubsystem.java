package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; // For displaying selected variable values
import edu.wpi.first.wpilibj2.command.SubsystemBase; // Allows for "extends SubsystemBase"

public class ExampleSubsystem extends SubsystemBase { // This is a subsystem as it "extends SubsystemBase"
    private int ExampleInteger;
    private double ExampleDouble;
    private String ExampleString;

    public ExampleSubsystem() { // Constructor that sets the INITIAL values for the variables/objects
        ExampleInteger = 1;
        ExampleDouble = 0;
        ExampleString = "7van";
    }

    /* Methods relating to ExampleInteger */
    public void changeExampleInteger(int newInteger) {
        ExampleInteger = newInteger; // Sets ExampleInteger to the inputted parameter value
    }

    public void incrementExampleInteger(int incrementValue) {
        ExampleInteger += incrementValue; // Adds incrementValue to ExampleInteger
    }

    public int returnExampleInteger() {
        return ExampleInteger; // Returns the CURRENT value of ExampleInteger
    }

    public int getRandomInteger(int minimumInteger, int maximumInteger) {
        int returnedInteger = minimumInteger + (int) (Math.random() * (maximumInteger - minimumInteger + 1));
        return returnedInteger; // Returns a random integer from the values of minimumInteger to maximumInteger
    }

    /* Methods relating to ExampleDouble */
    public void changeExampleDouble(double newDouble) {
        ExampleDouble = newDouble; // Sets ExampleDouble to the inputted parameter value
    }

    public double returnExampleDouble() {
        return ExampleDouble; // Returns the CURRENT value of ExampleDouble
    }

    public double getRandomDouble(double minimumDouble, double maximumDouble) {
        double returnedDouble = minimumDouble + (Math.random() * (maximumDouble - minimumDouble));
        return returnedDouble; // Returns a random double from the values of minimumDouble to just below maximumDouble
    }

    /* Methods relating to ExampleString */
    public void changeExampleString(String newString) {
        ExampleString = newString; // Returns the CURRENT value of ExampleString
    }

    public String returnExampleString() {
        return ExampleString; // Returns the CURRENT value of ExampleString
    }

    public boolean compareStrings(String stringToCompare) {
        return ExampleString.equals(stringToCompare); // Returns true if stringToCompare has the same characters as ExampleString and false otherwise
    }

    /* General Methods for ExampleSubsystem */
    public void clearExampleVariables() {
        /* Sets all values of the variables within ExampleSubsystem */
        ExampleDouble = 0;
        ExampleInteger = 0;
        ExampleString = "";
    }

    public void restoreOldVariables() {
        /* Sets all values of the variables within ExampleSubsystem to the constructor's values */
        ExampleInteger = 1;
        ExampleDouble = 0;
        ExampleString = "7van";
    }

    @Override
    public void periodic() { // This runs 50 times a second. This is a good place to use methods that don't impact the robot or display debugging information
        /* Displays the given values for the chosen variables */
        SmartDashboard.putNumber("ExampleInteger Value: ", returnExampleInteger());
        SmartDashboard.putNumber("ExampleDouble Value: ", returnExampleDouble());
        SmartDashboard.putString("ExampleInteger Value: ", returnExampleString());
    }
    
}
