package com.david.giczi.robot.model;

public class R2D2 extends AbstractRobot implements Robot {

		

	public R2D2(Cell starterPosition, int armor) {
		super(starterPosition, armor);
		
	}
	
	public R2D2() {
		super();
	}

	public Name getName() {
		
		return Name.R2D2;
	}

	
	@Override
	public String toString() {
		return this.getName()+"[position="+getOwnPosition()+", armor="+getOwnArmor()+"]";
	}

	
	
	
	
}
