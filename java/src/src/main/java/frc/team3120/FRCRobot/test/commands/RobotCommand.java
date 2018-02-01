package src.main.java.frc.team3120.FRCRobot.test.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import src.main.java.frc.team3120.FRCRobot.test.Robot;
import src.main.java.frc.team3120.FRCRobot.utils.Utilities;

public class RobotCommand extends Command
{
    public RobotCommand()
    {
        requires(Robot.drive);
        requires(Robot.pneumatics);
    }
    protected void initialize()
    {
        Robot.pneumatics.compressor.start();
    }
    public boolean isFinished()
    {
        return false;
    }
    protected void execute()
    {
        double y = Robot.oi.joystick1.getY();
        double twist = Robot.oi.joystick1.getTwist();
        double throttle = Robot.oi.joystick1.getThrottle() *  + 0.5;
        double lPow = 0;
        double rPow = 0;

        if(twist>0)
        {
            lPow = twist;
            rPow = -twist;
        }else if(twist<0)
        {
            rPow = twist;
            lPow = -twist;
        }

        if(Math.abs(y)>Robot.oi.threshold)
        {
            lPow = y;
            rPow = y;
        }

        lPow *= throttle;
        rPow *= throttle;
        double[] powers = Utilities.scalePower(lPow,rPow);
        Robot.drive.setPower(powers[0], powers[1]);

        if(Robot.oi.buttons1[3].get())
        {
            Robot.pneumatics.solenoid1.set(DoubleSolenoid.Value.kForward);
        }else if(Robot.oi.buttons1[5].get())
        {
            Robot.pneumatics.solenoid1.set(DoubleSolenoid.Value.kReverse);
        }else
            {
            Robot.pneumatics.solenoid1.set(DoubleSolenoid.Value.kOff);
        }
        SmartDashboard.putString("R Speed: ", ""+Robot.drive.RMotor.getSpeed());
        SmartDashboard.putString("L Speed: ", ""+Robot.drive.LMotor.getSpeed());
        SmartDashboard.updateValues();
    }
    protected void end(){ Robot.pneumatics.compressor.stop(); }
    protected void interrupted(){}
}
