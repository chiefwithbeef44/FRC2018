package src.main.java.frc.team3120.FRCRobot.test.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import src.main.java.frc.team3120.FRCRobot.test.RobotMap;

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

    public static class SubDrive
    {
        public static boolean enable;

        private static Drive master = new Drive();

        public static void Disabled(){
            master.lMotor = new Spark(RobotMap.LMotor);
            master.rMotor = new Spark(RobotMap.RMotor);
            master.lMotor.setInverted(true);
            enable = false;
        }

        public static void Enabled(){
            Drive.SubDrive.Disabled();
            master.brMotor = new Spark(RobotMap.BRMotor);
            master.blMotor = new Spark(RobotMap.BLMotor);
            master.brMotor.setInverted(true);
            enable = true;
        }
    }
}