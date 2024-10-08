package org.firstinspires.ftc.teamcode.ObjectClasses.RobotSubsystems.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.ObjectClasses.Robot;
import org.firstinspires.ftc.teamcode.ObjectClasses.RobotSubsystems.Drive.DriveClasses.MecanumDriveMona;
import org.firstinspires.ftc.teamcode.ObjectClasses.RobotSubsystems.Vision.VisionSubsystem;

public class DriveSubsystem extends SubsystemBase {

    @Config
    public static class DriveParameters {
        /** Set these drive parameters for faster TeleOp driving**/
        public static double DRIVE_SPEED_FACTOR=.7;
        public static double STRAFE_SPEED_FACTOR=.7;
        public static double TURN_SPEED_FACTOR=.8;
        public static double DEAD_ZONE = .2;
    }

    public MecanumDriveMona mecanumDrive;
    public VisionSubsystem visionSubsystem;
    public boolean aprilTagAutoDriving;
    public boolean fieldOrientedControl;

    public double drive;
    public double strafe;
    public double turn;

    public double leftYAdjusted;
    public double leftXAdjusted;
    public double rightXAdjusted;

    public DriveSubsystem(HardwareMap hardwareMap) {
        //Make the mecanumDrive at pose 0,0,0 because we don't know where we are yet
        mecanumDrive = new MecanumDriveMona(hardwareMap, new Pose2d(0, 0, 0));
    }

    public void init()
    {
        visionSubsystem = Robot.getInstance().getVisionSubsystem();
        aprilTagAutoDriving =false;
        fieldOrientedControl=false;
        mecanumDrive.init();
    }

    public void periodic(){
        DashboardTelemetryDriveTrain();
    }

    private void DashboardTelemetryDriveTrain() {
        //Add code to help with telemetry
    }


    public MecanumDriveMona getMecanumDrive()
    {
       return mecanumDrive;
    }

    public void setDriveStrafeTurnValues(double leftY, double leftX, double rightX ){
        boolean gamepadActive = driverGamepadIsActive(leftY, leftX, rightX);
        if (gamepadActive) {
            //apply speed factors
            leftYAdjusted = leftY * DriveParameters.DRIVE_SPEED_FACTOR;
            leftXAdjusted = leftX * DriveParameters.STRAFE_SPEED_FACTOR;
            rightXAdjusted = rightX * DriveParameters.TURN_SPEED_FACTOR;
        } else {
            leftYAdjusted = 0;
            leftXAdjusted = 0;
            rightXAdjusted = 0;
        }
        drive = leftYAdjusted;
        strafe = leftXAdjusted;
        turn = rightXAdjusted;
    }


    public Boolean driverGamepadIsActive(double leftY, double leftX, double rightX) {
        if     (Math.abs(leftY) > DriveParameters.DEAD_ZONE ||
                Math.abs(leftX) > DriveParameters.DEAD_ZONE ||
                Math.abs(rightX) > DriveParameters.DEAD_ZONE ){
            return true;
        } else return false;
    }
}


