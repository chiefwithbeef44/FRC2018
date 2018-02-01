package src.main.java.frc.team3120.FRCRobot.utils;

/**
 * Arbitrarily chosen units for LEFT, RIGHT, FORWARD, and BACKWARD
 */
public enum Direction
{

    LEFT(-1), RIGHT(1),

    FORWARD(1), BACKWARD(-1);

    public int v;

    Direction(int v)
    {
        this.v = v;
    }
}
