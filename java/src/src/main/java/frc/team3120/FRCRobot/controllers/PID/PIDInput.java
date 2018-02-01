package src.main.java.frc.team3120.FRCRobot.controllers.PID;


public abstract class PIDInput
{
    public abstract double getValue();
    public abstract double normalizeValue(double value);
    public abstract double normalizeError(double error);
}
