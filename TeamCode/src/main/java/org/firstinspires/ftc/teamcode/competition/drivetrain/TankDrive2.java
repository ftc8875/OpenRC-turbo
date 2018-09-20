package org.firstinspires.ftc.teamcode.competition.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;

public class TankDrive2 extends AbstractTankDrive {

    private static final String LEFT_MOTOR_NAME = "leftMotor";
    private static final String RIGHT_MOTOR_NAME = "rightMotor";

    DcMotor leftMotor;
    DcMotor rightMotor;

    public TankDrive2(HardwareMap hwMap) {
        super(hwMap);
        leftMotor = this.hwMap.get(DcMotor.class, LEFT_MOTOR_NAME);
        setLeftMotors(leftMotor);
        rightMotor = this.hwMap.get(DcMotor.class, RIGHT_MOTOR_NAME);
        setRightMotors(rightMotor);
    }

    protected void setLeftPower(float power) {
        super.setLeftPower(power);
    }

    protected void setRightPower(float power) {
        super.setRightPower(power);
    }

}
