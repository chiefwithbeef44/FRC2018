package src.main.java.frc.team3120.FRCRobot.test.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import src.main.java.frc.team3120.FRCRobot.test.RobotMap;
import src.main.java.frc.team3120.FRCRobot.test.commands.PneumaticsCommand;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Compressor compressor;
	public DoubleSolenoid solenoid1;
	
	public Pneumatics()
	{
		compressor = new Compressor(RobotMap.PCMPort);
		solenoid1 = new DoubleSolenoid(RobotMap.hSolenoid1_0, RobotMap.hSolenoid1_1);
	}
	
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new PneumaticsCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

