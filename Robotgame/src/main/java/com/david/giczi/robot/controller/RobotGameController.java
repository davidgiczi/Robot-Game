package com.david.giczi.robot.controller;




import java.io.IOException;
import java.util.Random;

import com.david.giczi.robot.model.GameRunning;
import com.david.giczi.robot.model.Name;
import com.david.giczi.robot.view.RobotGameDisplayer;

public class RobotGameController {

	
	private RobotGameDisplayer displayer;
	private boolean keepRunning=true;
	private int[] chosenRobots=new int[2];
	private int[] widthOfArena=new int[2];
	private int[] lengthOfArena=new int[2];
	private int[] numberOfMatches=new int[2];
	private int[] armorsOfA=new int[2];
	private int[] armorsOfB=new int[2];
	private int[] inputData=new int[7];
	private int counter=0;
	
	public RobotGameController() {
		
		displayer=new RobotGameDisplayer();
		
		for (int i = 0; i < widthOfArena.length; i++) {
			chosenRobots[i]=-1;
			widthOfArena[i]=-1;
			lengthOfArena[i]=-1;
			numberOfMatches[i]=-1;
			armorsOfA[i]=-1;
			armorsOfB[i]=-1;
		}
		
	}
	
	
	public int[] getInputData() {
		return inputData;
	}



	public void perssKeyFunctions() {
		
		
			
	while(keepRunning) {	
		
		try {
			displayer.setKeyPressed(displayer.getTerminal().pollInput());
			
	
			if(displayer.getKeyPressed()!=null) {
				
				switch (displayer.getKeyPressed().getKeyType()) {
				
				case Escape:
					
					displayer.escapePressed();
					keepRunning=false;
					
					break;
					
				case Enter:
					
					displayer.enterPressed();
					if(counter==0)
					displayer.robotsDisplayer();
					
					if(counter>0){
					inputData=inputDataCorrection(chosenRobots, widthOfArena, lengthOfArena, numberOfMatches, armorsOfA, armorsOfB);
					playGame();
					}
						
					break;
					
				case Character:
							
					
					if(counter<2) {
						
					int chosenRobot=displayer.chosenRobotDisplayer(displayer.getKeyPressed().getCharacter());
					
					if(chosenRobot!=-1)
					chosenRobots[counter]=chosenRobot;

					}
					
					if(counter==1)
						displayer.addText("Add the width of the arena then press ARROW RIGHT button:");
					

					if(counter==3)
						displayer.addText("Add the length of the arena then press ARROW RIGHT button:");
					
					if(counter==5)
						displayer.addText("Add the number of the matches then press ARROW RIGHT button:");
					
					if(counter==7)
						displayer.addText("Add the number of armors of A robot then press ARROW RIGHT button:");
					
					if(counter==9)
						displayer.addText("1Add the number of armors of B robot then press");
					
					
					if(counter>=2 && counter<4) {
						widthOfArena[counter-2]=displayer.getInputNumber(displayer.getKeyPressed().getCharacter());
					}
					
					if(counter>=4 && counter<6) {
						lengthOfArena[counter-4]=displayer.getInputNumber(displayer.getKeyPressed().getCharacter());
					}
					
					if(counter>=6 && counter<8) {
						numberOfMatches[counter-6]=displayer.getInputNumber(displayer.getKeyPressed().getCharacter());
					}
					
					if(counter>=8 && counter<10) {
						armorsOfA[counter-8]=displayer.getInputNumber(displayer.getKeyPressed().getCharacter());
					}
					
					if(counter>=10 && counter<12) {
						armorsOfB[counter-10]=displayer.getInputNumber(displayer.getKeyPressed().getCharacter());
					}
					
					counter++;
					
					break;
					
				case ArrowDown:
					
					inputData=inputDataCorrection(chosenRobots, widthOfArena, lengthOfArena, numberOfMatches, armorsOfA, armorsOfB);
					inputDataDisplay(inputData);
					
					counter++;
					
					break;
						
				case ArrowRight:
					
					
					if(counter==3)
						displayer.addText("Add the length of the arena then press ARROW RIGHT button:");
					
					if(counter==5)
						displayer.addText("Add the number of the matches then press ARROW RIGHT button:");
					
					if(counter==7)
						displayer.addText("Add the number of armors of A robot then press ARROW RIGHT button:");
					
					if(counter==9) 
						displayer.addText("1Add the number of armors of B robot then press");
			
					
					counter++;
					
					break;
				default:
					break;
				}
			
				
			
		} 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
			
			
				
			}	
	

	
		}
	
	
	
	private int[] inputDataCorrection(int[] chosenRobots, int[] widthOfArena, int[] lengthOfArena , int[] numberOfMatches, int[] armorsOfA, int[] armorsrOfB) {

		int[] data=new int[7];
		
			
		if(chosenRobots[0]==-1)
		data[0]=0;
		else
		data[0]=chosenRobots[0];
		
		if(chosenRobots[1]==-1)
		data[1]=1;
		else
		data[1]=chosenRobots[1];
		
		
		if(chosenRobots[0]==chosenRobots[1] && chosenRobots[0]!=-1 && chosenRobots[1]!=-1) {
			
			if(Name.values().length-1-chosenRobots[0]>=1)
				data[1]=chosenRobots[1]+1;
			else
			data[1]=chosenRobots[1]-1;	
			
		}
		
		
		if(widthOfArena[0]==-1 && widthOfArena[1]!=-1)
		data[2]=widthOfArena[1];
		if(widthOfArena[0]!=-1 && widthOfArena[1]==-1)
		data[2]=widthOfArena[0];
		if(widthOfArena[0]==-1 && widthOfArena[1]==-1)
		data[2]=10;
		if(widthOfArena[0]!=-1 && widthOfArena[1]!=-1) 
		data[2]=widthOfArena[0]*10+widthOfArena[1];
		if(data[2]<2)
		data[2]=2;
		
		if(lengthOfArena[0]==-1 && lengthOfArena[1]!=-1)
		data[3]=lengthOfArena[1];
		if(lengthOfArena[0]!=-1 && lengthOfArena[1]==-1)
		data[3]=lengthOfArena[0];
		if(lengthOfArena[0]==-1 && lengthOfArena[1]==-1)
		data[3]=10;
		if(lengthOfArena[0]!=-1 && lengthOfArena[1]!=-1)
		data[3]=lengthOfArena[0]*10+lengthOfArena[1];
		if(data[3]<2)
		data[3]=2;
	
		
		if(numberOfMatches[0]==-1 && numberOfMatches[1]!=-1)
		data[4]=numberOfMatches[1];
		if(numberOfMatches[0]!=-1 && numberOfMatches[1]==-1)
		data[4]=numberOfMatches[0];
		if(numberOfMatches[0]!=-1 && numberOfMatches[1]!=-1)
		data[4]=numberOfMatches[0]*10+numberOfMatches[1];
		if(numberOfMatches[0]==-1 && numberOfMatches[1]==-1)
		data[4]=100;
		
		if(armorsOfA[0]==-1 && armorsOfA[1]!=-1)
		data[5]=armorsOfA[1];
		if(armorsOfA[0]!=-1 && armorsOfA[1]==-1)
		data[5]=armorsOfA[0];
		if(armorsOfA[0]!=-1 && armorsOfA[1]!=-1)
		data[5]=armorsOfA[0]*10+armorsOfA[1];
		if(armorsOfA[0]==-1 && armorsOfA[1]==-1)
		data[5]=10;
		
		
		if(armorsrOfB[0]==-1 && armorsrOfB[1]!=-1)
		data[6]=armorsrOfB[1];
		if(armorsrOfB[0]!=-1 && armorsrOfB[1]==-1)
		data[6]=armorsrOfB[0];
		if(armorsrOfB[0]!=-1 && armorsrOfB[1]!=-1)
		data[6]=armorsrOfB[0]*10+armorsrOfB[1];
		if(armorsrOfB[0]==-1 && armorsrOfB[1]==-1)
		data[6]=10;
		
		
		return data;
	}
	
	
	
	private void inputDataDisplay(int[] inputData){
		
			
		displayer.addText("-\'A\' robot: ");
		displayer.addText("+"+Name.values()[inputData[0]]);
		displayer.addText("-Its number of armor: ");
		displayer.addText("+"+inputData[5]);
		displayer.addText("-\'B\' robot: ");
		displayer.addText("+"+Name.values()[inputData[1]]);
		displayer.addText("-Its number of armor: ");
		displayer.addText("+"+String.valueOf(inputData[6]));
		displayer.addText("-Size of the arena: ");
		displayer.addText("+"+inputData[2]+" X "+inputData[3]);
		displayer.addText("-Number of the game: ");
		displayer.addText("+"+inputData[4]);
		
		displayer.addText("2Then press Enter...");
	}
	
	
	private void playGame() {
		
		GameRunning running=new GameRunning(inputData);
		
		displayer.gameDisplayer(running.getArena(), running.getA(), running.getB(), inputData[5], inputData[6]);
		
		Random rnd=new Random();
		
		int rounds=0;
	try {	
		while(rounds<running.getArena().getNumberOfMatches() && !running.getA().areRobotsMet(running.getArena()) && !running.getB().areRobotsMet(running.getArena())) {
			
		
			Thread.sleep(1000);
			
			int stepA=rnd.nextInt(8)+1;
			int stepB=rnd.nextInt(8)+1;
			
			running.getA().stepping(stepA, running.getArena());
			running.getB().stepping(stepB, running.getArena());
			
			displayer.gameDisplayer(running.getArena(), running.getA(), running.getB(), inputData[5], inputData[6]);
				
			rounds++;
		}	
		
		
		
		while(rounds<running.getArena().getNumberOfMatches() && running.getA().getOwnArmor()!=0 && running.getB().getOwnArmor()!=0) {
			
			
			Thread.sleep(1000);
			int action=rnd.nextInt(6)+1;
			
			switch (action) {
			case 1:
				running.getA().attacking(running.getB());
				running.getB().attacking(running.getA());
				break;
			case 2:
				running.getA().attacking(running.getB());
				running.getB().defensing();
				break;
			case 3:
				running.getA().attacking(running.getB());
				running.getB().waiting(1);
				break;
			case 4:
				running.getB().attacking(running.getA());
				running.getA().defensing();	
				break;
			case 5:
				running.getB().attacking(running.getA());
				running.getA().waiting(1);
				break;
			case 6:
				running.getB().waiting(1);
				running.getA().waiting(1);
				break;
			default:
				break;
			}
			
			displayer.gameDisplayer(running.getArena(), running.getA(), running.getB(), inputData[5], inputData[6]);
			
			rounds++;
		}
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
		
		displayer.finalResultDisplayer(running.getA(), running.getB());
	
		}
			
		
		
		
	}
	
	
		 
			
	
	
	
	

