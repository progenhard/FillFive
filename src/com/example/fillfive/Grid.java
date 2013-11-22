package com.example.fillfive;

public class Grid {

	// grid properties
	private static int GRIDBORDER = 0;
	private static int GRIDSPACING = 2;
	private static int ELEMENTSIZE = 30;
	private static int DEFAULT_R = 238;
	private static int DEFAULT_G = 233;
	private static int DEFAULT_B = 233;

	private int maxLength = 14;
	public Element[][] grid = new Element[maxLength][maxLength];

	public Grid() {
		createGrid();
	}

	public Grid(int maxLength) {
		this.maxLength = maxLength;
		createGrid();
	}

	public int getMaxLength() {
		return maxLength;
	}

	// create the grid
	public void createGrid() {
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < maxLength; j++) {
				grid[i][j] = new Element();
				createElement(grid[i][j], i, j);
			}
		}
	}

	private void createElement(Element e, int i, int j) {
		e.left = GRIDBORDER + i * (ELEMENTSIZE + GRIDSPACING);
		e.right = GRIDBORDER + i * (ELEMENTSIZE + GRIDSPACING) + ELEMENTSIZE;
		e.top = GRIDBORDER + j * (ELEMENTSIZE + GRIDSPACING);
		e.bottom = GRIDBORDER + j * (ELEMENTSIZE + GRIDSPACING) + ELEMENTSIZE;
		e.r = DEFAULT_R;
		e.g = DEFAULT_G;
		e.b = DEFAULT_B;
	}

	// solver
	public Boolean checkWin(int player) {
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < maxLength; j++) {
				if (grid[i][j].getPlayer() == player) {
					if (checkRightDiag(player, i, j))
						return true;
					if (checkLeftDiag(player, i, j))
						return true;
					if (checkVertical(player, i, j))
						return true;
					if (checkHorizontal(player, i, j))
						return true;
				}
			}
		}

		return false;
	}

	// angle check
	private int checkAngle(int player, int x, int y, int addX, int addY) {
		if (x < 0 || y < 0 || x >= maxLength || y >= maxLength
				|| grid[x][y].getPlayer() != player)
			return 0;
		return checkAngle(player, x + addX, y + addY, addX, addY) + 1;
	}

	private Boolean checkVertical(int player, int x, int y) {
		if (checkAngle(player, x, y + 1, 0, 1)
				+ checkAngle(player, x, y - 1, 0, -1) + 1 >= 5)
			return true;
		return false;
	}

	private Boolean checkHorizontal(int player, int x, int y) {
		if (checkAngle(player, x + 1, y, 1, 0)
				+ checkAngle(player, x - 1, y, -1, 0) + 1 >= 5)
			return true;
		return false;
	}

	private Boolean checkLeftDiag(int player, int x, int y) {
		if (checkAngle(player, x - 1, y + 1, -1, 1)
				+ checkAngle(player, x + 1, y - 1, 1, -1) + 1 >= 5)
			return true;
		return false;
	}

	private Boolean checkRightDiag(int player, int x, int y) {
		if (checkAngle(player, x + 1, y + 1, 1, 1)
				+ checkAngle(player, x - 1, y - 1, -1, -1) + 1 >= 5)
			return true;
		return false;
	}

}
