class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = rows * cols - 1;

        while (i <= j) {

            int mid = i + (j - i) / 2;

            int rowMid = mid / cols;
            int colMid = mid % cols;

            if (matrix[rowMid][colMid] == target) {
                return true;
            }

            if (target < matrix[rowMid][colMid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }
}