// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants { // Serves as an easy way to change variables on the fly; use "import frc.robot.Constants"

  /* Constants related to the controller and "driving" */
  public static class operatorConstants {
    /* Constants within RobotContainer.java */
    public static final int numberChangerPort = 0; // Notice that ALL variables here are public static final!!!
  }

  public static class numberConstants {
    /* Constants within ExampleIntegerCommand */
    public static final int maximumIntegerValue = 1000;

    /* Constants within ExampleRandomCommand */
    public static final int lowerRandomIntegerBounds = -100;
    public static final int upperRandomIntegerBounds = 100;
    public static final double lowerRandomDoubleBounds = -100;
    public static final double upperRandomDoubleBounds = 100;
  }
}
