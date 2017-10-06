package org.usfirst.frc.team4711.robot.commands

import edu.wpi.first.wpilibj.command.Command
import org.usfirst.frc.team4711.robot.OI
import org.usfirst.frc.team4711.robot.lib.CheesyDrive
import org.usfirst.frc.team4711.robot.lib.FunkyDrive
import org.usfirst.frc.team4711.robot.subsystems.Drivetrain
import org.usfirst.frc.team4711.robot.subsystems.Misc

object Teleop: Command() {
    override fun initialize() {

    }

    override fun execute() {
        Drivetrain.drive(CheesyDrive.updateCheesy(OI.getThrottle(), OI.getRate(), OI.getQuickturn()))

        Misc.setShooter(if (OI.getShooter()) { 1.0 } else { 0.0 })
        Misc.setIntake(if (OI.getIntake()) { 1.0 } else { 0.0 })
    }

    override fun end() {

    }

    override fun interrupted() {

    }

    override fun isFinished(): Boolean {
        return false
    }
}