package org.firstinspires.ftc.teamcode.competition.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractTankDrive {

    protected HardwareMap hwMap;

    private ArrayList<DcMotor> leftMotors;
    private ArrayList<DcMotor> rightMotors;

    private float leftPower;
    private float rightPower;

    protected AbstractTankDrive(HardwareMap hwMap) {
        this.hwMap = hwMap;
    }

    public void setLeftMotors(Collection<DcMotor> motors) {
        leftMotors = new ArrayList<>(motors);
    }

    public void setLeftMotors(DcMotor[] motors) {
        leftMotors = new ArrayList<>(Arrays.asList(motors));
    }

    public void setLeftMotors(DcMotor motor) {
        leftMotors = new ArrayList<>(Arrays.asList(new DcMotor[]{motor}));
    }

    public void setRightMotors(Collection<DcMotor> motors) {
        rightMotors = new ArrayList<>(motors);
    }

    public void setRightMotors(DcMotor[] motors) {
        rightMotors = new ArrayList<>(Arrays.asList(motors));
    }

    public void setRightMotors(DcMotor motor) {
        rightMotors = new ArrayList<>(Arrays.asList(new DcMotor[]{motor}));
    }

    /**
     * Drive the robot, just as a tank, powering either side independently
     * @param left: the power to give the left-side motors
     * @param right: the power to give the right-side motors
     */
    public void drive(float left, float right) {
        setLeftPower(left);
        setRightPower(right);
    }

    /**
     * Drive the robot, supplying the overall power to the robot, and the rate at which the robot
     * should be turning.
     * @param power: the overall power, -1 to 1
     * @param turn: the rate at which to turn the robot, -1 to 1. -ve CW, +ve CCW.
     */
    public void driveTurn(float power, float turn) {
         setLeftPower(0.5f * (power - turn));
         setRightPower(0.5f * (power + turn));
    }

    protected void setLeftPower(float power) {
        leftPower = Range.clip(power, -1, 1);
        for (DcMotor motor : leftMotors) {
            motor.setPower(leftPower);
        }
    }
    protected void setRightPower(float power) {
        rightPower = Range.clip(power, -1, 1);
        for (DcMotor motor : rightMotors) {
            motor.setPower(rightPower);
        }
    }

    protected float getLeftPower() {
        return leftPower;
    }

    protected float getRightPower() {
        return rightPower;
    }
}
