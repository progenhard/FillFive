package com.example.fillfive;

public class Grid {
    
	private int maxLength = 9;
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
				grid[i][j].setPlayer(-1);
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
					if(checkRightDiag(player,i,j)> 5) return true;
					if(checkLeftDiag(player,i,j)> 5) return true;
					if(checkVertical(player,i,j) > 5) return true;
					if(checkHorizontal(player,i,j)> 5) return true;
				}
			}
		}
		
		return false;
	}


// angle check
	private int checkVertical(int player, int x, int y){
		if(grid[x][y].getPlayer() != player || x < 0 || 
				y < 0 || x > maxLength || y > maxLength)
			return 0;
		return checkVertical(player, x, y+1) + checkVertical(player, x, y-1) + 1;
	}
	
	private int checkHorizontal(int player, int x, int y){
		if(grid[x][y].getPlayer() != player || x < 0 || 
				y < 0 || x > maxLength || y > maxLength)
			return 0;
		return checkVertical(player, x+1, y) + checkVertical(player, x, x-1) + 1;
	}

	private int checkLeftDiag(int player, int x, int y){
		if(grid[x][y].getPlayer() != player || x < 0 || 
				y < 0 || x > maxLength || y > maxLength)
			return 0;
		return checkVertical(player, x-1, y+1) + checkVertical(player, x+1, y-1) + 1;
	}
	
	private int checkRightDiag(int player, int x, int y){
		if(grid[x][y].getPlayer() != player || x < 0 || 
				y < 0 || x > maxLength || y > maxLength)
			return 0;
		return checkVertical(player, x+1, y+1) + checkVertical(player, x-1, y-1) + 1;
	}


}
