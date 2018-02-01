package src.main.java.frc.team3120.FRCRobot.test;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import src.main.java.frc.team3120.FRCRobot.controllers.Camera;
import src.main.java.frc.team3120.FRCRobot.partstest.ColorTest;
import src.main.java.frc.team3120.FRCRobot.partstest.MotorTest;
import src.main.java.frc.team3120.FRCRobot.partstest.NavXTest;
import src.main.java.frc.team3120.FRCRobot.test.commands.DriveCommand;
import src.main.java.frc.team3120.FRCRobot.test.commands.PneumaticsCommand;
import src.main.java.frc.team3120.FRCRobot.test.commands.TwoDriveCommand;
import src.main.java.frc.team3120.FRCRobot.test.subsystems.Drive;
import src.main.java.frc.team3120.FRCRobot.test.subsystems.Pneumatics;
import src.main.java.frc.team3120.FRCRobot.test.subsystems.TwoMotorDrive;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Pneumatics pneumatics; //= new Pneumatics();
	public static TwoMotorDrive drive; //= new TwoMotorDrive();
	public static Drive Drive = new Drive(false);
	public static OI oi;
	public static Camera camera;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();
	SendableChooser<Command> teleOpChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		oi = new OI();
		teleOpChooser.addDefault("CameraTest", new ColorTest());
		teleOpChooser.addObject("Pneumatics Test", new PneumaticsCommand());
//		teleOpChooser.addObject("Motor Test", new MotorTest());
//		teleOpChooser.addObject("NavX Test", new NavXTest());
//		teleOpChooser.addObject("DriveTest", new TwoDriveCommand());
		teleOpChooser.addObject("newDriveTest", new DriveCommand());
//		CommandGroup teleopCommand = new CommandGroup();//		teleopCommand.addParallel(new PneumaticsCommand());
//		teleopCommand.addParallel(new TwoDriveCommand());
//		teleOpChooser.addDefault("TeleOp Main", teleopCommand);
	
		SmartDashboard.putData("TeleOp Mode", teleOpChooser);
//		
//		autoChooser.addDefault("DriveForward", new DriveForward());
//		SmartDashboard.putData("Auto Mode", autoChooser);
		
		camera = new Camera();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = autoChooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		teleOpChooser.getSelected().start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
