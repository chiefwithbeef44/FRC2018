package src.main.java.frc.team3120.FRCRobot.partstest;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import src.main.java.frc.team3120.FRCRobot.test.Robot;

/**
 *
 */
public class ColorTest extends Command 
{

    public ColorTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	synchronized(Robot.camera.pBlue) {
    		SmartDashboard.putString("Percent Blue: ", Double.toString(Robot.camera.pBlue));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
