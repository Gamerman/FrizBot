package edu.first.team2903.robot.commands;

import edu.first.team2903.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;

public class AutoMode1 extends CommandBase {

    
    boolean done = false;

    public AutoMode1() {
        requires(drivetrain);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.frisbeePusher.setAngle(5);
        shooter.diskDrop.setAngle(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //TODO Shoot three disks
        while (done == false) {
            shooter.setSpeed(-.75);
            try {
                Thread.sleep(3000);
                shooter.shoot();
                Thread.sleep(2000);
                shooter.shoot();
                Thread.sleep(2000);
                shooter.shoot();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            
            drivetrain.drive(-1, -1);
            //TODO Finish that code to back up 9 feet
            drivetrain.drive(1, -1);
            //Todo finish that code to turn 180   
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            done = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
//shoot 3 disks
//back up X feet
//spin 180 deg