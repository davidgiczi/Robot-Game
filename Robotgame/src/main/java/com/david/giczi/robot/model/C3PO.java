package com.david.giczi.robot.model;

public class C3PO extends AbstractRobot implements Robot {

	

	public C3PO(Cell starterPosition, int armor) {
		super(starterPosition, armor);
		
	}
	
	public C3PO() {
		super();
	}

	public Name getName() {
		
		return Name.C3PO;
	}

	
	@Override
	public String toString() {
		return this.getName()+"[position="+getOwnPosition()+", armor="+getOwnArmor()+"]";
	}
	
}
