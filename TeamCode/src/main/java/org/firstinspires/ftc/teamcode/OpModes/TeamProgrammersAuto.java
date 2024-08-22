package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config

@Autonomous(name = "TeamProgrammersAuto", group = "Autonomous")
public class TeamProgrammersAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-34, -62, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        waitForStart();
        Actions.runBlocking(drive.actionBuilder(beginPose)
                .lineToY(-34)
                .waitSeconds(1)
                .lineToY(-60)
                .strafeTo(new Vector2d(-10, -60))
                .waitSeconds(0.1)
                .lineToY(-13)
                .turnTo(Math.toRadians(0))
                .waitSeconds(0.1)
                .lineToX(47)
                .strafeTo(new Vector2d(47, -34))
                .waitSeconds(1)
                .strafeTo(new Vector2d(47, -62 ))
                .waitSeconds(0.1)
                .lineToX(60)
                .build());

    }
}
