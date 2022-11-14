import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class AlmostTetris{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        //int sol=func("azcabcab", "acb");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        int n = 4;
		int m = 4;
		char[] figures = {'D','B', 'A', 'C'};
		AlmostTetris almostTetris = new AlmostTetris();
		int[][] sol=almostTetris.almostTetris(n, m, figures);
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
        //System.out.println(sol);
        scan.close();
    }  

    int[][][] figureDimension = {{{0, 0}}, {{0, 0}, {0, 1}, {0, 2}}, {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, {{0, 1}, {1, 0}, {1, 1}, {1, 2}}};
    

	public int[][] almostTetris(int n, int m, char[] figures) {
		int[][] matrix = new int[n][m];
		int[] figure1=new int[figures.length];
		for (int i = 0; i < figures.length; i++) {
			int x=(int)figures[i]-65;
			figure1[i]=x+1;
		}
		int code = 1;
		for (int figure : figure1) {
			boolean figurePlaced = false;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (isPossibleAtThisPoint(matrix, figureDimension[figure - 1], i, j, code)) {
						figurePlaced = true;
						code++;
						break;
					}
				}
				if (figurePlaced) {
					break;
				}
			}
		}
		return matrix;
	}

	private boolean isPossibleAtThisPoint(int[][] matrix, int[][] fd, int x, int y, int code) {
		for (int i = 0; i < fd.length; i++) {
			int next_x = fd[i][0] + x;
			int next_y = fd[i][1] + y;
			if (next_x >= 0 && next_x < matrix.length && next_y >= 0 && next_y < matrix[0].length) {
				if (matrix[next_x][next_y] != 0) {
					return false;
				}
			} else {
				return false;
			}
		}
		for (int i = 0; i < fd.length; i++) {
			int next_x = fd[i][0] + x;
			int next_y = fd[i][1] + y;
			matrix[next_x][next_y] = code;
		}
		return true;
	}
}  