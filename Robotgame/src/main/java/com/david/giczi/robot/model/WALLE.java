package com.david.giczi.robot.model;

public class WALLE extends AbstractRobot implements Robot {

	

	public WALLE(Cell starterPosition, int armor) {
		super(starterPosition, armor);
		
	}
	
	public WALLE() {
		super();
	}

	public Name getName() {
		
		return Name.WALLE;
	}

	
	@Override
	public String toString() {
		return this.getName()+"[position="+getOwnPosition()+", armor="+getOwnArmor()+"]";
	}
	
}
