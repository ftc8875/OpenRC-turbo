package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Drive Train OpMode")
public class DriveTrainOpMode extends OpMode {

    private DriveTrainHardware robot;

    private double leftPower;
    private double rightPower;

    private double servoPos;

    public void init() {
        robot = new DriveTrainHardware(hardwareMap);
        telemetry.addLine("Initialized!");
    }

    public void loop() {
        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;
        servoPos = gamepad1.right_trigger;
        robot.drive(leftPower, rightPower);
        robot.setServoPosition(servoPos);
        telemetry.addData("L", leftPower);
        telemetry.addData("R", rightPower);
        telemetry.addData("S", Range.scale(servoPos, 0, 1, 0, 180));
    }

    public void stop() {
        robot.stop();
        telemetry.addLine("Stopped!");
    }
}
