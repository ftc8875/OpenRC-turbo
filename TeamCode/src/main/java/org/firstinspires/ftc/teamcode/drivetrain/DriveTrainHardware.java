package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class DriveTrainHardware {

    private HardwareMap hardwareMap;

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private Servo servo;

    public DriveTrainHardware(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        servo = hardwareMap.get(Servo.class, "servo");
        servo.scaleRange(0, 1);

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double leftPower, double rightPower) {
        leftPower = Range.clip(leftPower, -1, 1);
        rightPower = Range.clip(rightPower, -1, 1);
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

    public void setServoPosition(double pos) {
        pos = Range.clip(pos, 0, 1);
        servo.setPosition(pos);
    }

    public void stop() {
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        drive(0.0, 0.0);
    }
}
