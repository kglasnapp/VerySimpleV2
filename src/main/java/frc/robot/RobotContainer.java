package frc.robot;

import static frc.robot.Util.logf;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.StartCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.TestMotorsSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * be declared. Since Command-based is a
 * "declarative" paradigm, very little robot
 * logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).
 * Instead, the structure ofthe robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    final DigitalInput robotIDCheck = new DigitalInput(0);

    public final static CommandXboxController driveController = new CommandXboxController(2);
    public final static CommandXboxController operatorController = new CommandXboxController(3);
    public final static XboxController operatorHID = operatorController.getHID();
    public final static XboxController driveHID = driveController.getHID();
    private static SlewRateLimiter sLX = new SlewRateLimiter(DriveTrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND);
    private static SlewRateLimiter sLY = new SlewRateLimiter(DriveTrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND);
    public final static DriveTrainSubsystem driveTrain = new DriveTrainSubsystem(driveHID, sLX, sLY);
    public final static TestMotorsSubsystem motorTest = new TestMotorsSubsystem(driveHID);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Set the default Robot Mode to Cube
        logf("Creating RobotContainer\n");
        configureButtonBindings();
    }

    public double squareWithSign(double v) {
        return (v < 0) ? -(v * v) : (v * v);
    }

    private void configureButtonBindings() {
        driveController.start().onTrue(new StartCommand());
    }
}
