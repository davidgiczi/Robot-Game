package com.david.giczi.robot.model;

import java.util.HashMap;

public class RobotCreator {

	
	private static HashMap<Integer, AbstractRobot> robots=new HashMap<>();
	
	
	public static void addRobot(AbstractRobot robot, int number) {
		
		robots.put(number, robot);
		
	}
	
	public static void removeRobot(int number) {
		
		robots.remove(number);
		
	}
	
	
	public  static AbstractRobot getRobot(int number) {
		
		if(robots.isEmpty())
			new RobotNotFoundException("Robot with \'"+number+"\' number not found!");
	
		return robots.get(number);
	}


	
	
}
