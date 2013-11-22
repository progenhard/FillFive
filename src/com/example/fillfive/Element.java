package com.example.fillfive;

public class Element {
	
	//player
	private int player = 0;
	
	//drawing element 
	public int top = 0;
	public int bottom = 0;
	public int left = 0;
	public int right = 0;
	
	//color
	public int r = 0;
	public int g = 0;
	public int b = 0;
	
	public Element(){
		
	}
	
	public void setPlayer(int player){
		this.player = player;
	}
	public int getPlayer(){
		return player;
	}

}
