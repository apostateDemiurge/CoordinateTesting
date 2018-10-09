/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CoordinateCommand extends Command {
 
public static final double DISTANCE = 1;

private int SR, SL, VL, VR;
private double cosine, sine;
private double theta, x, y;

  public CoordinateCommand() {
  

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SR = 0;
    SL = 0;
    theta = 0;
    x = 0;
    y = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override

  protected void execute() {
    int SL_new = Robot.encLeft.get();
    int SR_new = Robot.encRight.get();
// first, the encoders get the most recent value for each wheel

    VL = SL_new - SL;
    VR = SR_new - SR;
// then the velocity of each wheel is calculated with the new and old values
    
    theta += ((VL - VR)/DISTANCE);
    cosine = Math.cos(theta);
    sine = Math.sin(theta);
// these three are used in finding x and y and ensuring directional change is accounted for

    x += ((VL + VR)/2.0)*(cosine);
    y += ((VL + VR)/2.0)*(sine);
// these equations use sine and cosine as well as each wheel's velocity to update x and y

    System.out.println(x);
    System.out.println(y);
// then the variables are printed out to the driver

    SL = SL_new;
    SR = SR_new;
// the new value becomes the old value for when the whole thing is called again
  }




  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
