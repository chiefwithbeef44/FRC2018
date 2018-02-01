package src.main.java.frc.team3120.FRCRobot.test.subsystems;

import edu.wpi.first.wpilibj.Spark;
import src.main.java.frc.team3120.FRCRobot.test.RobotMap;

public class SubDrive extends Drive
{
    public static boolean enabled;

    private static Drive master = new Drive();

    public static void Disabled(){
        master.lMotor = new Spark(RobotMap.LMotor);
        master.rMotor = new Spark(RobotMap.RMotor);
        master.lMotor.setInverted(true);
        enabled = false;
    }

    public static void Enabled(){
        Disabled();
        master.brMotor = new Spark(RobotMap.BRMotor);
        master.blMotor = new Spark(RobotMap.BLMotor);
        master.brMotor.setInverted(true);
        enabled = true;
    }
}
