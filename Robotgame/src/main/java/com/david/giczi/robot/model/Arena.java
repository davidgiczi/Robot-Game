package com.david.giczi.robot.model;

import java.util.ArrayList;
import java.util.List;

public class Arena {

	private int width;
	private int length;
	private List<AbstractRobot> arena;
	private int numberOfMatches;
	
	
	public Arena(int width, int length, AbstractRobot A, AbstractRobot B, int numberOfMatches) {
		
		
		arena=new ArrayList<>();
		
		if(width<2) {
			
			this.width=2;
			
		}
		else {
			
			this.width=width;
		}
			
		
		if(length<2) {
			
			this.length=2;
		}
		
		
		else {
			
		this.length = length;
			
		}
		
		for (int i = 0; i < this.width*this.length; i++) {
			arena.add(null);
		}
		
	
		arena.set(A.getOwnPosition().getX()*this.width+A.getOwnPosition().getY(), A);
		arena.set(B.getOwnPosition().getX()*this.width+B.getOwnPosition().getY(), B);
			
		
		this.numberOfMatches=numberOfMatches;
	}
	
	
	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	
	
	public int getNumberOfMatches() {
		return numberOfMatches;
	}


	public List<AbstractRobot> getArena() {
		return arena;
	}

	
	@Override
	public String toString() {
		return "Arena [width=" + width + ", length=" + length + ", arena=" + arena + ", numberOfMatches="
				+ numberOfMatches + "]";
	}



	
}
