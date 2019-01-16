package com.david.giczi.robot.model;

public abstract class AbstractRobot implements Robot {

	private Cell position;
	private int armor;

	
	public AbstractRobot(Cell starterPosition, int armor) {
		super();
		this.position=starterPosition;
		this.armor = armor;
	}

	public AbstractRobot() {
		
	position=new Cell(0, 0);
	armor=10;
	
	}
	
	
	public final Cell getOwnPosition(){
		
		return this.position;
	}
	
	
	public final Cell getOpponentPosition(AbstractRobot opponent) {
		
		return opponent.getOwnPosition();
	}
	
	
	public final int[] getSizeOfArena(Arena arena) {
		
		int[] sizeOfArena=new int[2];
		
		sizeOfArena[0]=arena.getWidth();
		sizeOfArena[1]=arena.getLength();
		
		return sizeOfArena;
	}
	
	public final int getOwnArmor() {
		
		return this.armor;
	}
	
	
	public final int getOpponentArmor(AbstractRobot opponent) {
		
		return opponent.getOwnArmor();
	}
	
	
	public void setPosition(Cell position) {
		this.position = position;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}


	public final void stepping(int direction, Arena arena) { 
		
		//direction: 1 North, 2 North-East, 3 East, 4 South-East, 5 South, 6 South-West, 7 West, 8 North-West
		
		int x=this.getOwnPosition().getX();
		int y=this.getOwnPosition().getY();
		

	
			if(canRobotStepThere(direction, arena)) {
			
			switch (direction) {
			case 1:
				
				this.setPosition(new Cell(x-1,y));
				arena.getArena().set((x-1)*arena.getWidth()+y, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
			case 2:
				
				this.setPosition(new Cell(x-1,y+1));
				arena.getArena().set((x-1)*arena.getWidth()+y+1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;

			case 3:
				
				this.setPosition(new Cell(x,y+1));
				arena.getArena().set(x*arena.getWidth()+y+1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
				
			case 4:
				
				this.setPosition(new Cell(x+1,y+1));
				arena.getArena().set((x+1)*arena.getWidth()+y+1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
			
			case 5:
				
				this.setPosition(new Cell(x+1,y));
				arena.getArena().set((x+1)*arena.getWidth()+y, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
				
			case 6:
				
				this.setPosition(new Cell(x+1,y-1));
				arena.getArena().set((x+1)*arena.getWidth()+y-1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
				
			case 7:
				
				this.setPosition(new Cell(x,y-1));
				arena.getArena().set(x*arena.getWidth()+y-1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
				
				
			case 8:
				
				this.setPosition(new Cell(x-1,y-1));
				arena.getArena().set((x-1)*arena.getWidth()+y-1, this);
				arena.getArena().set(x*arena.getWidth()+y, null);
				
				break;
				
			default:
				break;
			}	
				
			
			
			}
						
				
}
			
			
	public void attacking(AbstractRobot opponent) {
		
		opponent.setArmor(opponent.getOwnArmor()-1);
		
	}
	
	
	public void defensing() {
		
		
		this.setArmor(this.getOwnArmor()+1);
			
			
	}
	
	
	public void waiting(int sec) {
		
		if(sec>0) {
			
			try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public boolean areRobotsMet(Arena arena) {
		
		int x=this.getOwnPosition().getX();
		int y=this.getOwnPosition().getY();
		
			
		if(x-1>=0 && arena.getArena().get((x-1)*arena.getWidth()+y)!=null)
			return true;
		
		else if(x-1>=0 && y+1<arena.getWidth() && arena.getArena().get((x-1)*arena.getWidth()+y+1)!=null)
			return true;
		
		else if(y+1<arena.getWidth() && arena.getArena().get(x*arena.getWidth()+y+1)!=null)
			return true;
		
		else if(x+1<arena.getLength() && y+1<arena.getWidth() && arena.getArena().get((x+1)*arena.getWidth()+y+1)!=null)
			return true;
		
		else if(x+1<arena.getLength() && arena.getArena().get((x+1)*arena.getWidth()+y)!=null)
			return true;
		
		else if(x+1<arena.getLength() && y-1>=0 && arena.getArena().get((x+1)*arena.getWidth()+y-1)!=null)
			return true;
		
		else if(y-1>=0 && arena.getArena().get(x*arena.getWidth()+y-1)!=null)
			return true;
		
		else if(x-1>=0 && y-1>=0 && arena.getArena().get((x-1)*arena.getWidth()+y-1)!=null)
			return true;
		else
		
		return false;
	}
	
	private boolean canRobotStepThere(int direction, Arena arena) {
		
		int x=this.getOwnPosition().getX();
		int y=this.getOwnPosition().getY();
		
			
		if(direction==1 && x-1>=0 && arena.getArena().get((x-1)*arena.getWidth()+y)==null) //North
			return true;
		
		else if(direction==2 && x-1>=0 && y+1<arena.getWidth() && arena.getArena().get((x-1)*arena.getWidth()+y+1)==null)//North-East
			return true;
		
		else if(direction==3 && y+1<arena.getWidth() && arena.getArena().get(x*arena.getWidth()+y+1)==null)//East
			return true;
		
		else if(direction==4 && x+1<arena.getLength() && y+1<arena.getWidth() && arena.getArena().get((x+1)*arena.getWidth()+y+1)==null)//South-East
			return true;
		
		else if(direction==5 && x+1<arena.getLength() && arena.getArena().get((x+1)*arena.getWidth()+y)==null) //South
			return true;
		
		else if(direction==6 && x+1<arena.getLength() && y-1>=0 && arena.getArena().get((x+1)*arena.getWidth()+y-1)==null)//South-West
			return true;
		
		else if(direction==7 && y-1>=0 && arena.getArena().get(x*arena.getWidth()+y-1)==null)//West
			return true;
		
		else if(direction==8 && x-1>=0 && y-1>=0 && arena.getArena().get((x-1)*arena.getWidth()+y-1)==null)//North-West
			return true;
		else
		
		return false;
	}
	
	
}
