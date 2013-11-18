package com.example.fillfive;

public class Grid {
    
	private int maxLength = 14;
	public Element[][] grid = new Element[maxLength][maxLength];
	 
	
	public Grid(){
		createGrid();
	}
	
	public Grid(int maxLength){
		this.maxLength = maxLength;
		createGrid();
	}
	
	public void createGrid(){
		for(int i = 0; i < maxLength; i++){
			for(int j = 0; j < maxLength; j++){
				grid[i][j].setPlayer(0);
			}
		}
	}
	
	public int getMaxLength(){
		return maxLength;
	}
	
// solver
	public Boolean checkWin(int player){
		for(int i = 0; i < maxLength; i++){
			for(int j = 0; j < maxLength; j++){
				if(grid[i][j].getPlayer() == player){
					if(checkRightDiag(player,i,j)) return true;
					if(checkLeftDiag(player,i,j)) return true;
					if(checkVertical(player,i,j)) return true;
					if(checkHorizontal(player,i,j)) return true;
				}
			}
		}
		
		return false;
	}


// angle check
	private int checkAngle(int player, int x, int y, int addX, int addY){
		if(grid[x][y].getPlayer() != player || x < 0 || 
				y < 0 || x > maxLength || y > maxLength)
			return 0;	
		return checkAngle(player, x+addX, y+addY, addX, addY) + 1;
	}
	
	private Boolean checkVertical(int player, int x, int y){
		if(checkAngle(player, x, y+1,0,1) + 
				checkAngle(player, x, y-1,0,-1) + 1 > 5) return true;
		return false;
	}
	
	private Boolean checkHorizontal(int player, int x, int y){
		if(checkAngle(player, x + 1, y,1,0) + 
				checkAngle(player, x-1, y,-1,0) + 1 > 5) return true;
		return false;
	}

	private Boolean checkLeftDiag(int player, int x, int y){
		if(checkAngle(player, x-1, y+1,-1,1) + 
				checkAngle(player, x+1, y-1,1,-1) + 1 > 5) return true;
		return false;
	}
	
	private Boolean checkRightDiag(int player, int x, int y){
		if(checkAngle(player, x+1, y+1,1,1) + 
				checkAngle(player, x-1, y-1,-1,-1) + 1 > 5) return true;
		return false;
	}


}
