package datastructure.graphs.udemy.dfs;

public class MazeSolver {

    private int[][] maze;
    private boolean[][] visited;
    private int startRow;
    private int startColumn;

    public MazeSolver(int[][] maze, int startRow, int startCol) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startColumn = startCol;
    }

    public void findWay() {

        if (dfs(startRow, startColumn)) {
            System.out.println("Solution exists ..");
        } else {
            System.out.println("No solution");
        }
    }

    private boolean dfs(int startRow, int startColumn) {
        // base case
        if (startRow == maze.length - 1 && startColumn == maze.length - 1) {
            return true;
        }

        if (isFeasible(startRow, startColumn)) {
            visited[startRow][startColumn] = true;

            // Now we have to visit the next cells (U, D, L, R)
            if (dfs(startRow + 1, startColumn)) {
                // Move down
                return true;
            }

            if (dfs(startRow, startColumn + 1)) {
                // Move right
                return true;
            }

            if (dfs(startRow - 1, startColumn)) {
                // Move up
                return true;
            }

            if (dfs(startRow, startColumn - 1)) {
                // Move left
                return true;
            }

            // BACKTRACK
            visited[startColumn][startColumn] = false;
            return false;
        }

        return false;
    }

    private boolean isFeasible(int x, int y) {
        // We check vertical dimension
        if (x < 0 || x > maze.length - 1) {
            return false;
        }
        // We check horizontal dimension
        if (y < 0 || y > maze.length - 1) {
            return false;
        }

        if (visited[x][y]) {
            // Already considered this state
            return false;
        }

        if (maze[x][y] == 1) {
            // There is obstacle in the way
            return false;
        }

        return true;
    }


    public static void main(String[] args) {

        int[][] maze = {
                {1, 1, 1, 1, 1, 1},
                {2, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
        };

        MazeSolver solver = new MazeSolver(maze, 1, 0);
        solver.findWay();
    }
}
