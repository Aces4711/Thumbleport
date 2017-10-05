package org.usfirst.frc.team4711.robot.subsystems

import com.ctre.MotorControl.CANTalon
import edu.wpi.first.wpilibj.RobotDrive
import org.usfirst.frc.team4711.robot.Constants

object Drivetrain {
    val m_leftSRX = CANTalon(Constants.kL_MASTER_DRIVE)
    val m_rightSRX = CANTalon(Constants.kR_MASTER_DRIVE)

    val m_leftSlaveSRX = CANTalon(Constants.kL_SLAVE_DRIVE)
    val m_rightSlaveSRX = CANTalon(Constants.kR_SLAVE_DRIVE)

    val m_drive = RobotDrive(m_leftSRX, m_leftSlaveSRX, m_rightSRX, m_rightSlaveSRX)

    init {
        /**m_leftSlaveSRX.changeControlMode(SmartMotorController.TalonControlMode.Follower)
        m_rightSlaveSRX.changeControlMode(SmartMotorController.TalonControlMode.Follower)

        m_leftSlaveSRX.set(m_leftSRX.getDeviceID().toDouble())
        m_rightSlaveSRX.set(m_rightSRX.getDeviceID().toDouble())**/
    }

    fun drive(left: Double, right: Double) = m_drive.tankDrive(-left * 0.9, -right * 0.9)
    fun brake(trigger: Boolean) {
        m_leftSRX.enableBrakeMode(trigger)
        m_rightSRX.enableBrakeMode(trigger)
        m_leftSlaveSRX.enableBrakeMode(trigger)
        m_rightSlaveSRX.enableBrakeMode(trigger)
    }
}