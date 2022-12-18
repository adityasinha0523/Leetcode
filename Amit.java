import java.io.*;
import java.util.*;
class Amit{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int matrix[][] = new int[r][c];
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();
            }
            //Solution ob = new Solution();
            ArrayList<Integer> ans = spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
        sc.close();
    }
    public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int r1 = 0; 
        int r2 = r-1;
        int c1 = 0; 
        int c2 = c-1;
        while (r1 != r2 && c1 != c2) {
            int j = c1;
            for(; j<=c2; j++){
                list.add(matrix[r1][j]);
            }
            r1++;
            j--;
            for(int i = r1; i<=r2; i++){
                list.add(matrix[i][j]);
            }
            c2--;
            
            j = c2;
            for(; j>= c1; j--) {
                list.add(matrix[r2][j]);
            }
            r2--;
            j++;
            
            for(int i = r2; i>= r1; i--) {
                list.add(matrix[i][j]);
            }
            c1++;
        }
        return list;
    }
}
// } Driver Code Ends



    //Function to return a list of integers denoting spiral traversal of matrix.
    
