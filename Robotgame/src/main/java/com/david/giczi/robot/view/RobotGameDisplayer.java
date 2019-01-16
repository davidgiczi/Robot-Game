package com.david.giczi.robot.view;



import java.io.IOException;

import com.david.giczi.robot.model.AbstractRobot;
import com.david.giczi.robot.model.Arena;
import com.david.giczi.robot.model.Name;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


public class RobotGameDisplayer {

	
	private Terminal terminal;
	private Screen screen;
	private TextGraphics tg;
	private KeyStroke keyPressed;
	private int row=Name.values().length+3;
	private int lenghtOfText;
	private String[] arena;
	private int numberOfMatches=0;
	
	public RobotGameDisplayer()  {
		
		
		try {
			
			terminal=new DefaultTerminalFactory().createTerminal();
			screen=new TerminalScreen(terminal);
			tg=screen.newTextGraphics();
			screen.startScreen();
			starterPageText();
		
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	

	public Terminal getTerminal() {
		return terminal;
	}



	public KeyStroke getKeyPressed() {
		return keyPressed;
	}
	
	


	public void setKeyPressed(KeyStroke keyPressed) {
		this.keyPressed = keyPressed;
	}



	public void escapePressed() {
		
		try {
			screen.stopScreen();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void enterPressed() {
			
			try {
				
			tg.setForegroundColor(TextColor.ANSI.MAGENTA);
			
			for (int i = 20; i < 60; i++) {
			tg.putString(i,22, String.valueOf(Symbols.BLOCK_SOLID));
				screen.refresh();
				Thread.sleep(100);
			}
			
			
			} catch (InterruptedException | IOException e) {
				
				e.printStackTrace();
			}
			
		}
	
	
	public int chosenRobotDisplayer(Character c) {
		
		
		tg.setForegroundColor(TextColor.ANSI.RED);
		int col=45;
		int row=1;
		int index;
		Name[] robots=Name.values();
		 
		 
		try {
			
			 index=Integer.parseInt(String.valueOf(c))-1;
			 
			 
		} catch (Exception e) {
			
			index=-1;
			
		}
		
			try {
				
				if(index!=-1 && index<robots.length) {
					
				tg.putString(col, row+index, (index+1)+") "+robots[index].toString(), SGR.BOLD);
				screen.refresh();
				
				return index;
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		return -1;
		
	}
	
	
	public int getInputNumber(Character c) {
		
		int value=-1;
		
		try {
			
		 value=Integer.parseInt(String.valueOf(c));
		 
		 if(0>value)
		 new NumberFormatException();
		 
			
		} catch (NumberFormatException e) {
			System.out.println("Input value is negative or not a number!");
			return -1;
		}
			
		
		return value;
		
	}
	
	
	
	public void addText(String text) {
		
		int col=1;
		
		try {
			
			tg.setForegroundColor(TextColor.ANSI.DEFAULT);
			tg.setForegroundColor(TextColor.ANSI.DEFAULT);
			
			if(text.startsWith("-")) {
				tg.putString(col, row, text.substring(1), SGR.BOLD);
				lenghtOfText=text.length()-1;
			}
			
			else if(text.startsWith("+")) {
				tg.setForegroundColor(TextColor.ANSI.RED);
				tg.putString(col+lenghtOfText, row++, text.substring(1), SGR.BOLD);
				
			}
			else if(text.startsWith("1")) {
				
				tg.putString(col,  row++, text.substring(1), SGR.BOLD);
				lenghtOfText=text.length();
				tg.setForegroundColor(TextColor.ANSI.BLUE);
				tg.putString(col+lenghtOfText, row++, " Arrow Down button...", SGR.BOLD);
				row+=2;
			}
			else if(text.startsWith("2")) {
				tg.setForegroundColor(TextColor.ANSI.BLUE);
				tg.putString(49, row, text.substring(1), SGR.BOLD);
			}
			else {
				tg.putString(col,  row++, text, SGR.BOLD);
			}
				
			
			screen.refresh();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void robotsDisplayer() {
		
		screen.clear();
		
		String text1="Choose two robots of them by their numbers: "; 
		
		Name[] robots=Name.values();
		
	try {
		tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
		tg.setForegroundColor(TextColor.ANSI.DEFAULT);
		
		int col=1;
		int row=1;
		
		tg.putString(col, row, text1, SGR.BOLD);
		
		for (Name name : robots) {

			tg.putString(col+text1.length(), row, (row++)+") "+name.toString(), SGR.BOLD);
			screen.refresh();
		}
		
		
		screen.refresh();
		
	}
			catch (IOException e) {
	
				e.printStackTrace();
			}
	
	}
	
	
	
	public void gameDisplayer(Arena arena, AbstractRobot a, AbstractRobot b, int armorA, int armorB) {
		
		int col=1;
		
		convertArena(arena);
		
		try {
			screen.clear();
			
			tg.setForegroundColor(TextColor.ANSI.DEFAULT);
		
			
			if(this.arena.length>=7) {
			
			for (int row=0 ; row<this.arena.length; row++) {
				
				if(row==0)
				tg.putString(col, row+1, this.arena[row]+"      "+(numberOfMatches++)+".kör", SGR.BOLD);
				else if(row==2)
				tg.putString(col, row+1, this.arena[row]+"     \"A\" robot: "+a.getName()+".class", SGR.BOLD);
				else if(row==3)
				tg.putString(col, row+1, this.arena[row]+"      Páncél: "+a.getOwnArmor()+"/"+armorA, SGR.BOLD);
				else if(row==5)
				tg.putString(col, row+1, this.arena[row]+"     \"B\" robot: "+b.getName()+".class", SGR.BOLD);
				else if(row==6)
				tg.putString(col, row+1, this.arena[row]+"      Páncél: "+b.getOwnArmor()+"/"+armorB, SGR.BOLD);
				else
					tg.putString(col, row+1, this.arena[row], SGR.BOLD);
			}
		}	
			else {
				
				for (int row=0 ; row<this.arena.length; row++) {
					
					if(row==0)
					tg.putString(col, row+1, this.arena[row]+"      "+(numberOfMatches++)+".kör", SGR.BOLD);
					else if(row==2)
					tg.putString(col, row+1, this.arena[row]+"     \"A\" robot: "+a.getName()+".class     \"B\" robot: "+b.getName()+".class", SGR.BOLD);
					else if(row==3)
					tg.putString(col, row+1, this.arena[row]+"      Páncél: "+a.getOwnArmor()+"/"+armorA+"              Páncél: "+b.getOwnArmor()+"/"+armorB, SGR.BOLD);
					else
						tg.putString(col, row+1, this.arena[row], SGR.BOLD);
					
			}
			
			}	
			screen.refresh();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void finalResultDisplayer(AbstractRobot a, AbstractRobot b) {
		
		int col=28;
		int row=20;
		
	try {	
		tg.setForegroundColor(TextColor.ANSI.RED);
		
		if(a.getOwnArmor()<b.getOwnArmor()) {
			tg.putString(col,row, b.getName().toString(), SGR.BOLD);
			tg.putString(col+b.getName().toString().length(),row, " the winner!", SGR.BOLD);
			
		}
		
		else if(a.getOwnArmor()==b.getOwnArmor()) {
			tg.putString(col,row, "Draw!", SGR.BOLD);
			
		}
			
		else {
			tg.putString(col,row, a.getName().toString(), SGR.BOLD);
			tg.putString(col+b.getName().toString().length(),row, " the winner!", SGR.BOLD);
			
		}
			
		tg.setForegroundColor(TextColor.ANSI.BLUE);
		tg.putString(col, row+2, "Esc - Exit", SGR.BOLD);
		screen.refresh();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	private void convertArena(Arena arena) {
		
		this.arena=new String[arena.getLength()+2];
		boolean addRobot=false;
		int arrayCounter=1;
		
		
		StringBuilder sb=new StringBuilder();
		
		for (int i = 0; i < arena.getWidth()+2; i++) {
			sb.append("*");
		}
		
		this.arena[0]=sb.toString();
		
		sb.delete(0, sb.length());
		
		
		
		for (int i=0; i < arena.getLength(); i++) {
			
			sb.delete(0, sb.length());
			sb.append("*");
			
			for (int j = 0; j < arena.getWidth(); j++) {
				
				
				
				if(arena.getArena().get(i*arena.getWidth()+j)==null) {
					
					sb.append(".");
				}
				if(arena.getArena().get(i*arena.getWidth()+j)!=null && !addRobot) {
					
					sb.append("A");
					addRobot=true;
					continue;
					
				}
				if (arena.getArena().get(i*arena.getWidth()+j)!=null && addRobot){
					
					sb.append("B");
			
				}
				
			}
			
			sb.append("*");
			
			
			this.arena[arrayCounter++]=sb.toString();
			
		}
		
		sb.delete(0, sb.length());
		

		for (int i = 0; i < arena.getWidth()+2; i++) {
			sb.append("*");
		}
		
		this.arena[arrayCounter]=sb.toString();
	}
	
	
	
	private void starterPageText() {
		
		String text1="ROBOT Game";
		String text2="Enter - Start Game";
		String text3="Esc - Exit";

	try	{
			
		int col=terminal.getTerminalSize().getColumns()/2-text1.length()/2;
		int row=terminal.getTerminalSize().getRows()/2-5;
		
		tg.setBackgroundColor(TextColor.ANSI.WHITE);
		tg.setForegroundColor(TextColor.ANSI.RED);
		
		tg.putString(col, row, text1);
		
		tg.setForegroundColor(TextColor.ANSI.BLUE);
		
		tg.putString(col, row+2, text2);
		tg.putString(col, row+3, text3);
		
		screen.refresh();
		
		
	}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

	
	
	
	
}		
			
			
			