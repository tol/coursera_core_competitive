import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class King {

	static int[][] dirs = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };

	static boolean inBounds(int  i, int  j, int r, int c) {
		return 0 <= i && i < c && 0 <= j && j < r;
	};

	static int  adjSpaces(int[][] table,int i, int  j,int r,int c) {
		int spaces=0;
		for (int[] dir: dirs) {
			int u = i + dir[0];
			int v = j + dir[1];
			if (inBounds(u, v,r,c) && table[u][v] == 0)
				++spaces;
		}
		return spaces;
	};

	static boolean blockNeighbour(int[][] table,int i, int  j,int r,int c){
		for (int[] dir: dirs) {
			int u = i + dir[0];
			int v = j + dir[1];
			if (inBounds(u, v,r,c) && table[u][v] == 1 && adjSpaces(table,u, v,r,c) <= 1)
				return true;
		}
		return false;
	}
	static boolean canMove(int[][] table,int r, int c,int i, int j){
		if (table[i][j]==1) return false;

		if (blockNeighbour(table,i,j,r,c)) return false;

		if (i+1<c && table[i+1][j]==0) return true;
		if (i>0 && table[i-1][j]==0) return true;
		if (j+1<r && table[i][j+1]==0) return true;
		if (j>0 && table[i][j-1]==0) return true;

		if (i+1<c && j>0 && table[i+1][j-1]==0) return true;
		if (i+1<c && j+1<r && table[i+1][j+1]==0) return true;

		if (i>0 && j>0 && table[i-1][j-1]==0 ) return true;
		if (i>0 && j+1<r && table[i-1][j+1]==0) return true;
		return false;
	}

	static  int solver(int[][] table,int r, int c,int i,int j,int max) {

		//System.out.println(i + "  " + j);
		//System.out.println(max);
		//System.out.println(Arrays.toString(table));
//		for (int i=0;i<c;i++)
//			for (int j=0;j<r;j++){
		int nexti=i;
		int nextj=j;
		if ((j+1)<r) nextj=j+1;
		else {
			if (i + 1 < c) {
				nexti = i + 1;
				nextj = 0;
			}
			else return canMove(table, r, c, i, j)?max+1:max;
		}

		int [][] temp=new int[c][r];
		for(int a=0;a<c;a++)
			for(int b=0;b<r;b++)
				temp[a][b]=table[a][b];
		//int m1 = solver(table, r, c, nexti, nextj, max);
		int m2=0;
		if (canMove(table, r, c, i, j)) {
			table[i][j] = 1;
			 m2 = solver(table, r, c, nexti, nextj, max+1);
		}else{
			m2 = solver(table, r, c, nexti, nextj, max);
		}





		return m2;

	}
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r, c;
        r = in.nextInt();
        c = in.nextInt();

        int result = 0;

        // your code
		int[][] t=new int[c][r];
		result=solver(t,r,c,0,0,result);

        out.println(result);

        in.close();
        out.close();
    }
}
