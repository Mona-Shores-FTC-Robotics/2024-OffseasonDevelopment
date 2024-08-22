package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "SimpleAuto", group = "Autonomous")
public class SimpleAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(0, 0, 0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        waitForStart();

        Actions.runBlocking(drive.actionBuilder(beginPose)
          //      .splineTo(new Vector2d(30, 30), Math.PI / 2)
          //      .splineTo(new Vector2d(-30, -30), Math.PI / 2)
                        .lineToX(30)
                        .turnTo(Math.toRadians(90))
                        .lineToY(30)
                        .turnTo(Math.toRadians(180))
                        .lineToX(0)
                        .lineToY(0)
                .build());

    }
}
