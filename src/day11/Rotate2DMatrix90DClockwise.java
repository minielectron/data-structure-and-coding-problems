package day11;

public class Rotate2DMatrix90DClockwise {

    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void rotate(int[][] matrix) {

        int size = matrix.length - 1;
        print(matrix);

        for (int layer = 0; layer < matrix.length / 2; layer++) {
            for (int i = layer; i < size - layer; i++) {

                int topLeft = matrix[layer][i];
                int topRight = matrix[i][size - layer];
                int bottomRight = matrix[size - layer][size - i];
                int bottomLeft = matrix[size - i][layer];

                matrix[layer][i] = bottomLeft;
                matrix[size - i][layer] = bottomRight;
                matrix[size - layer][size - i] = topRight;
                matrix[i][size - layer] = topLeft;
            }
        }

        print(matrix);

    }

    public static void print(int[][] matrix) {
        for (int[] i : matrix) {
            for (int value : i) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
