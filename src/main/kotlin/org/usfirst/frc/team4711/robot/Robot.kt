package org.usfirst.frc.team4711.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import org.usfirst.frc.team4711.robot.commands.Teleop

class Robot: IterativeRobot() {
    override fun robotInit() {
    }

    override fun autonomousInit() {

    }

    override fun autonomousPeriodic() {

    }

    override fun teleopInit() {
        Teleop.start()
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }
}