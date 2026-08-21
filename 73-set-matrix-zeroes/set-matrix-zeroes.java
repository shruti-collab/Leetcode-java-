class Solution{
    public void setZeroes(int[][] matrix){
        int m= matrix.length;
        int n= matrix[0].length;

        boolean[] row= new boolean[m];
        boolean[] col =new boolean[n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] ==0){
                    row[i]= true;
                    col[j]= true;
                }
            }
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(row[i]|| col[j]){
                    matrix[i][j] =0;
                }
            }
        }
    }
}


// class Solution {
//     public void setZeroes(int[][] matrix){

//     int m = matrix.length;
//     int n= matrix[0].length;

//     for(int i=0;i< m; i++){
//         for(int j=0;j<n;j++){
//             if(matrix[i][j]==0){
//                 for(int col=0; col<n; col++){
//                     if(matrix[i][col]!=0){
//                         matrix[i][col]= -1;
//                     }
//                 }
//                 for(int row=0; row<m; row++){
//                     if(matrix[row][j]!= 0){
//                         matrix[row][j]= -1;
//                     }
//                 }
//             }
           

//         }

//     }

//     for(int i=0; i<m;i++){
//         for(int j=0; j<n; j++){
//             if(matrix[i][j] == -1){
//                 matrix[i][j] =0;
//             }
//         }
//     }
        
//     }
// }
