package src.main.java.frc.team3120.FRCRobot.controllers.PID;

import src.main.java.frc.team3120.FRCRobot.utils.StatusChecker;

public class CycleChecker extends StatusChecker
{
    int extraCycles;
    PIDFunctions func;

    /**
     * Used in PIDController to specify the amount of extra cycles within ACC_ERROR
     * to continue running.
     * @param func the PIDFunctions object to operate on
     * @param extraCycles how many extra cycles to continue
     */
    public CycleChecker(PIDFunctions func, int extraCycles)
    {
        this.func = func;
        this.extraCycles = extraCycles;
    }

    @Override
    public boolean checkStatus() {
        return func.pidController.cycles < extraCycles;
    }
}
