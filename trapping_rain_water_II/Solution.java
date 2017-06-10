import java.util.*;

public class Solution {
    public int trapRainWater(int[][] heightMap) {

		int nRow = heightMap.length;
		if (nRow<=0) return 0;
		int nCol = heightMap[0].length;
		if (nCol<=0) return 0;

		int[][] peekMap = new int[nRow][nCol];

		// initialize inner peekMap to be largest values
		for(int i=1; i<nRow-1; i++) {
			for (int j=1; j<nCol-1; j++) {
				peekMap[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<Index> queue = new LinkedList<Index>();

		// initialize boundary and push boundary to queue
		for (int i=0; i<nRow; i++) {
			peekMap[i][0] = heightMap[i][0];
			peekMap[i][nCol-1] = heightMap[i][nCol-1];
			queue.add( new Index(i,0) );
			queue.add( new Index(i, nCol-1 ) );
		}

		for (int j=1; j<nCol-1; j++) {
			peekMap[0][j] = heightMap[0][j];
			peekMap[nRow-1][j] = heightMap[nRow-1][j];
			queue.add( new Index(0,j) );
			queue.add( new Index(nRow-1,j) );
		}



		// BFS search to update peekMap
		while( !queue.isEmpty() ) {
			Index curIdx = queue.remove();
			Index[] nexIdxArray = {
				new Index(curIdx.x, curIdx.y-1), new Index(curIdx.x, curIdx.y+1),
				new Index(curIdx.x-1, curIdx.y), new Index(curIdx.x+1, curIdx.y)
			};

			for (Index nextIdx : nexIdxArray) {
			  
				int nx = nextIdx.x;
				int ny = nextIdx.y;
				if (nx<=0 || nx>=nRow-1 || ny<=0 || ny>=nCol-1 ) { continue; }

				int peekHeight = Math.max(peekMap[curIdx.x][curIdx.y], heightMap[nx][ny]);
				if (peekMap[nx][ny] > peekHeight) {
					peekMap[nx][ny] = peekHeight;
					queue.add( new Index(nx, ny) );
				}
				
			}
		}

		int ret = 0;
		for (int i=0; i<nRow; i++) {
			for (int j=0; j<nCol; j++) {
				ret += peekMap[i][j]-heightMap[i][j];
			}
		}
		
		return ret;
    }
}

class Index {
	int x;
	int y;
	Index (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
