package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.android.AndroidSoundPool;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

import java.util.List;

//TODO: Uhm, I just thought... we are kinda screwed if we dont see a duck.

@Autonomous (name = "TEST!!!")//STARTUP TIME, AFTER WE DROP THE BLOCK TIME, AND SPINNER POINT DELAY
public class test extends LinearOpMode //spaghetti code incoming sry
{
    /*private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
    private static final String[] LABELS = {
            "Ball",
            "Cube",
            "Duck",
            "Marker"
    };

    private static final String VUFORIA_KEY =
            "AQ6C1J//////AAABmbFbgnFY8EZ5qg3cWA0ah41DbnifisxJLGcs/rleVs6vR426D48HVqkbcQcAoS2psojauMyRXL6EokX3ArzBtz0MZhNocumRhg5E0AUc8uZL8NAmpq/DwfWrK0tbffRw9VxAcOUVErt01llobKRzcR0vWAfurZ82ZH7a1MVM+ZApi3lxOoJYOEFzbt0JQufS6dYQm31m6/BVfQ63wL+aU3El7rURTxW/2qvSZt6kROmCnaZmNPSdfXGPy8j2xcyKL0vb0pjr8P9FgpktgXYmU5lpGX/lcD40JiLXQGNLD5k2inZtjVYzyvBtPXZ3Z1fqnh5Mp3jcydAa8DofLGHZs2UuC7fkAAAco11XG+w3v9K5";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;*/



    @Override
    public void runOpMode() throws InterruptedException
    {
        /////////////////////////// INITIALISATION ////////////////////////////
        /*initVuforia();
        initTfod();*/

        int duckPose = 0;
        //duckPose = Webcam.getElementPosition(tfod, vuforia); // TODO check with the positions

        //telemetry.addData("!!! Duc pose = ", duckPose);
        //telemetry.update();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        DcMotor lift = hardwareMap.get(DcMotorEx.class, "Lift");
        DcMotor Spinner = hardwareMap.get(DcMotor.class, "Spinner");
        Servo Claw = hardwareMap.get(Servo.class, "Claw");
        AndroidSoundPool androidSoundPool = new AndroidSoundPool();
        Claw.setPosition(1);
        Servo Dump = hardwareMap.get(Servo.class, "Dump");
        //lift.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Lift.runToPosition(Constants.liftLow, lift);

        /*while(opModeIsActive())
        {
            telemetry.addData("encoder", lift.getCurrentPosition());
            telemetry.update();
        }*/




        /*Pose2d startPose = new Pose2d(Constants.offset, 60, Math.toRadians(-90));
        Vector2d shippingHub = new Vector2d(-12, 42);
        //Vector2d midpoint = new Vector2d(-30, -42);
        Pose2d spinner = new Pose2d(-60, 45, Math.toRadians (0));
        Pose2d spinner_shift = new Pose2d(-60, 50, Math.toRadians (0));
        //Pose2d spinner_shift = new Pose2d(-55, 55, Math.toRadians (0));
        Vector2d warehouse_midpoint = new Vector2d(-25, 65);
        Pose2d warehouse = new Pose2d(40, 65, Math.toRadians (0));

        drive.setPoseEstimate(startPose);*/

        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        waitForStart();

        /////////////////////////// AUTO ////////////////////////////

        //set lift according to the duck location
        /*if(duckPose==0) Lift.runToPosition(Constants.liftLow, lift);
        if(duckPose==1) Lift.runToPosition(Constants.liftMid, lift);
        if(duckPose==2) Lift.runToPosition(Constants.liftHigh, lift);*/

        Dump.setPosition(-1.0);
        Spinner.setPower(-0.8);

        /*TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .waitSeconds(Constants.startDelay)
                .lineTo(shippingHub)//location of the red shipping hub
                .addTemporalMarker(Constants.startDelay, () -> {Claw.setPosition(0.5);}) //servo dump
                .waitSeconds(Constants.blue_basic_shipHubDelay+Constants.shipHubDelay)
                // shipping hub dump delay + additional delay if we wish
                .lineToLinearHeading(spinner)
                .lineToLinearHeading(spinner_shift)
                .waitSeconds(Constants.blue_basic_spinDelay+Constants.spinDelay)
                // carousel spinning delay + additional delay if we wish
                .splineToConstantHeading(warehouse_midpoint, 0)
                .lineToLinearHeading(warehouse)
                .build();*/

        if(isStopRequested()) return;

        //drive.followTrajectorySequence(trajSeq);
    }

    /* private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    private void initTfod()
    {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.2f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }*/

}






//////////////////////////////////////////////////////////////////








//TODO: add the abbility to run auto during teleop (break out of auto)
//TODO: !!! add the abbillity to change the settings in telemetry

//TODO: add gracious
// professionalism with png class and add a reset to go back to the position once you're done.
// An auto that goes to block, then proceeds with its usual schedule !!!


//add a marker and delay to put the arm up? TODO: not sure if we need to lift the arm up at all actually



//////////////////////////////////////////////////////////////////////
