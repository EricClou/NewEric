package Leet;


//TO-DO
public class No_542_01Matrix {

    public static void main(String[] args){
      int[][] matrix = {{1,1,1},{0,0,0},{1,1,1}};
      System.out.println(distance(matrix,1,1));
    }


//        public int[][] updateMatrix(int[][] matrix){
//        int distance=
//    }


    public static boolean distance(int[][] matrix,int i,int j){
        if(i>matrix.length||j>matrix[0].length||i<0||j<0)
            return false;
        if(matrix[i][j+1]==0||matrix[i][j-1]==0||matrix[i+1][j]==0||matrix[i-1][j]==0){
            return true;
        }
        return false;
    }
}
