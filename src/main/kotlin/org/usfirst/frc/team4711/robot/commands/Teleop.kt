package org.usfirst.frc.team4711.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.usfirst.frc.team4711.robot.OI
import org.usfirst.frc.team4711.robot.subsystems.Drivetrain
import org.usfirst.frc.team4711.robot.subsystems.Misc

object Teleop: Command() {
    override fun initialize() {

    }

    override fun execute() {
        Drivetrain.brake(OI.getBrake())
        Drivetrain.drive(OI.getLeftThrottle(), OI.getRightThrottle())

        Misc.setShooter(OI.getShooter())
        Misc.setIntake(OI.getIntake())
    }

    override fun end() {

    }

    override fun interrupted() {

    }

    override fun isFinished(): Boolean {
        return false
    }
}