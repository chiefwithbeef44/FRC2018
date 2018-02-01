package src.main.java.frc.team3120.FRCRobot.test.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import src.main.java.frc.team3120.FRCRobot.test.RobotMap;
import src.main.java.frc.team3120.FRCRobot.utils.Utilities;

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

    public Drive() {}

    public void setPower(double lpower, double rpower, boolean fourEnabled)
    {
        if(!fourEnabled){
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