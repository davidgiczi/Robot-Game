package com.david.giczi.robot.app;

import com.david.giczi.robot.controller.RobotGameController;
import com.david.giczi.robot.model.C3PO;
import com.david.giczi.robot.model.R2D2;
import com.david.giczi.robot.model.RobotCreator;
import com.david.giczi.robot.model.WALLE;



public class RobotGame {
	
	
	public static void main(String[] args) {
		
		
		RobotCreator.addRobot(new R2D2(), 1);
		RobotCreator.addRobot(new C3PO(), 0);
		RobotCreator.addRobot(new WALLE(), 2);
		
		
		new RobotGameController().perssKeyFunctions();
		
			
	}

}
