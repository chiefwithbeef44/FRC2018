package src.main.java.frc.team3120.FRCRobot.autonomous;

import src.main.java.frc.team3120.FRCRobot.test.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveForTime(0.6, 0.6, 500);
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
