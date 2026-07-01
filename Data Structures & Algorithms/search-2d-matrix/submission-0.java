class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix.length-1;

        while(i<=j){
            int midRow = (i+j)/2;

            if(target>=matrix[midRow][0] && target<=matrix[midRow][matrix[0].length-1]){
                int k=0,l=matrix[0].length-1;
                while(k<=l){
                    int midCol = (k+l)/2;
                    if(target==matrix[midRow][midCol]){
                        return true;
                    }
                    if(target>matrix[midRow][midCol]){
                        k=midCol+1;
                    }
                    else{
                        l=midCol-1;
                    }
                }
                return false;
            }
            if(target<matrix[midRow][0]){
                j=midRow-1;
            }
            else{
                i=midRow+1;
            }
        }
        return false;
    }
}
