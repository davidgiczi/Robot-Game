package com.david.giczi.robot.model;

public class GameRunning {

	
	private AbstractRobot a;
	private AbstractRobot b;
	private Arena arena;
	
	public GameRunning(int[] inputData) {
		
		
		 a=RobotCreator.getRobot(inputData[0]);
		 b=RobotCreator.getRobot(inputData[1]);
		
		 a.setPosition(new Cell(0,0));
		 a.setArmor(inputData[5]);
		 
		 b.setPosition(new Cell(inputData[3]-1, inputData[2]-1));
		 b.setArmor(inputData[6]);
	
		 arena=new Arena(inputData[2], inputData[3], a, b, inputData[4]);
		 
	}

	public AbstractRobot getA() {
		return a;
	}

	public AbstractRobot getB() {
		return b;
	}

	public Arena getArena() {
		return arena;
	}
	
	
	
	
	
	
}
