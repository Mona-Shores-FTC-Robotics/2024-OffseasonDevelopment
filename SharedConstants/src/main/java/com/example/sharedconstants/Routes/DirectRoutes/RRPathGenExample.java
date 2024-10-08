package com.example.sharedconstants.Routes.DirectRoutes;

import static com.example.sharedconstants.FieldConstants.RED_AUDIENCE_START_POSE;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Vector2d;
import com.example.sharedconstants.RobotDriveAdapter;
import com.example.sharedconstants.Routes.Routes;

public class RRPathGenExample extends Routes {

    public RRPathGenExample(RobotDriveAdapter roadRunnerDrive) {
        super(roadRunnerDrive);
    }

    //Variables to store routes for team prop center for all four start locations
    public Action redAudienceBotRoute;

    public void BuildRoutes() {

        redAudienceBotRoute = roadRunnerDrive.actionBuilder(RED_AUDIENCE_START_POSE)
                .splineToConstantHeading(new Vector2d(-36.03, -35.28), Math.toRadians(90.00))
                .setReversed(true)
                .splineToConstantHeading(new Vector2d(-36.00, -58.00), Math.toRadians(-90.00))
//                .waitSeconds(.01)
                .splineToConstantHeading(new Vector2d(-11.20, -60.33), Math.toRadians(0.00))
                .build();

    }

    @Override
    public Action getRedAudienceBotRoute() {
        return redAudienceBotRoute;
    }
}
