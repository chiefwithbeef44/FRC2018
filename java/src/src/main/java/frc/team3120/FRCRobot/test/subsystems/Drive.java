package src.main.java.frc.team3120.FRCRobot.test.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem
{
    public Spark lMotor;
    public Spark rMotor;
    public Spark blMotor;
    public Spark brMotor;

    public Drive(boolean fourMotors)
    {
        if(fourMotors){
            SubDrive.Enabled();
        }else{
            SubDrive.Disabled();
        }
    }

    Drive() {}

    public void setPower(double lpower, double rpower, boolean fourEnabled)
    {
        if(!fourEnabled)
        {
            lMotor.set(lpower);
            rMotor.set(rpower);
        }else{
            lMotor.set(lpower);
            rMotor.set(rpower);
            blMotor.set(lpower);
            brMotor.set(rpower);
        }
    }

    @Override
    protected void initDefaultCommand(){}
}