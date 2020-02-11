/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Start States

    //CAN BUS Ports
    //PWM Ports
    public static final int LEFTMOTORCONTROLLER = 0;
    public static final int RIGHTMOTORCONTROLLER = 1;
    public static final int CONVEYORPORT = 2;
    public static final int SPINNER_PORT = 3;
    public static final int BALLPICKUP_PORT = 4;

    //Controller Ports
    public static final int CONTROLPORT1 = 0;
    public static final int CONTROLPORT2 = 1;

    //Speed Constants
    public static final double SPINNER_SPEED = 0.0;
    public static final double AUTOSPEED = 1.0;
    public static final double LOCATION_X = 0.0;
	public static final double TURNSPEED = 1.0;
	public static final Double BALLPICKUP_SPEED = 0.7;
}
