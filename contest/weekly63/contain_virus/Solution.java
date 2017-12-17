import java.util.*;
class Solution {
	private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int containVirus(int[][] grid) {
		int[] seed = {-1, -1};
		int maxBoundary = 0;
        for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int nBoundary = findBoundary(grid, i, j);
					if (nBoundary > maxBoundary) {
						maxBoundary = nBoundary;
						seed[0] = i;
						seed[1] = j;
					}
				}
			}
		}

		if (maxBoundary == 0) { return 0; }
		//System.out.println(seed[0] + ": " + seed[1]);
		//System.out.println("Before control -----------");
		//printGrid(grid);
		int nWall = containInfection(grid, seed[0], seed[1]);
		/*System.out.println("nWall: " + nWall);
		System.out.println("After control, before infection -------------");
		printGrid(grid);*/
		
		int nInfection = infect(grid);
		/*System.out.println("nInfection: " + nInfection);

		System.out.println("after infection --------------");
		printGrid(grid);*/
		
		if (nInfection != 0) {
			nWall += containVirus(grid);
		}

		return nWall;
    }

	private void printGrid(int[][] grid) {
		for (int[] line: grid) {
			System.out.println(Arrays.toString(line));
		}
	}

	private int infect(int[][] grid) {
		boolean[][] isNew = new boolean[grid.length][grid[0].length];
		int nNew = 0;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j] == 1 && !isNew[i][j]) {
					for (int k=0; k<dir.length; k++) {
						int nx = i + dir[k][0];
						int ny = j + dir[k][1];
						if (nx >= 0 && nx < grid.length &&
							ny >=0 && ny < grid[0].length &&
							grid[nx][ny] == 0) {
							grid[nx][ny] = 1;
							isNew[nx][ny] = true;
							nNew++;
						}
					}
				}
			}
		}
		return nNew;				   
	}

	private int containInfection(int[][] grid, int i, int j) {
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		xq.add(i);
		yq.add(j);

		int nWall = 0;

		while (!xq.isEmpty()) {
			int x = xq.poll();
			int y = yq.poll();
			grid[x][y] = -1;
			for (int k = 0; k<dir.length; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (nx >= 0 && nx < grid.length && ny >=0 && ny < grid[0].length) {
					if (grid[nx][ny] == 1) {
						xq.add(nx);
						yq.add(ny);
						grid[nx][ny] = -1;
					} else if (grid[nx][ny] == 0) {
						nWall++;
					}
				}
			}
		}
		return nWall;
	}

	private int findBoundary(int[][] grid, int i, int j) {
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		xq.add(i);
		yq.add(j);
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int nBoundary = 0;

		while (!xq.isEmpty()) {
			int x = xq.poll();
			int y = yq.poll();
			for (int k = 0; k<dir.length; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				if (nx >= 0 && nx < grid.length && ny >=0 && ny < grid[0].length &&
					!visited[nx][ny]) {
					if (grid[nx][ny] == 0) {
						nBoundary++;
					} else if (grid[nx][ny] == 1) {
						xq.add(nx);
						yq.add(ny);
					}
					visited[nx][ny] = true;
				}
			}
		}
		return nBoundary;
	}
}
