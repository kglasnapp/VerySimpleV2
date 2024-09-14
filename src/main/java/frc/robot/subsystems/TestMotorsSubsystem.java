package frc.robot.subsystems;

import static frc.robot.Util.logf;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestMotorsSubsystem extends SubsystemBase {

    public final static double MAX_VELOCITY_METERS_PER_SECOND = .1;
    TalonSRX talonTestRight = new TalonSRX(9);
    TalonSRX talonTestLeft = new TalonSRX(10);

    XboxController driveController;

    public TestMotorsSubsystem(XboxController driveController) {
        logf("Start of Test Motors Subsystem\n");
        this.driveController = driveController;
        talonTestRight.configFactoryDefault();
        talonTestLeft.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Make sure that you declare this subsystem in RobotContainer.java
        double rightTest = driveController.getRawAxis(4); // make forward stick positive
        talonTestRight.set(ControlMode.PercentOutput, rightTest);
        double leftTest = driveController.getRawAxis(0); // make forward stick positive
        talonTestLeft.set(ControlMode.PercentOutput, leftTest);
    }
}
