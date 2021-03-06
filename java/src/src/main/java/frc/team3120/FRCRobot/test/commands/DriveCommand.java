package src.main.java.frc.team3120.FRCRobot.test.commands;

import edu.wpi.first.wpilibj.command.Command;
import src.main.java.frc.team3120.FRCRobot.test.Robot;
import src.main.java.frc.team3120.FRCRobot.test.subsystems.Drive;
import src.main.java.frc.team3120.FRCRobot.utils.Utilities;


public class DriveCommand extends Command
{
    public DriveCommand(){
        requires(Robot.Drive);
    }

    public void execute()
    {
        double y = -Robot.oi.joystick1.getY();
        double twist = -Robot.oi.joystick1.getTwist();
        double throttle = -Robot.oi.joystick1.getThrottle() * 0.5 + 0.5;
        double lPower = 0;
        double rPower = 0;
        double sPower = 0;

        if(Math.abs(y) > Robot.oi.threshold)
        {
            lPower = y;
            rPower = y;
        }

        if(Math.abs(twist) > Robot.oi.threshold)
        {
            sPower = twist;
        }

        lPower *= throttle;
        rPower *= throttle;
        sPower *= throttle;

        double[] powers = Utilities.scalePower(lPower, rPower);
        Robot.Drive.setPower(powers[0], powers[1], Drive.SubDrive.enable);
        Robot.Drive.setSusanPower(sPower);
    }
    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
