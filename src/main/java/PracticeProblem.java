public class PracticeProblem {

    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Find the start position (bottom-left)
        int startRow = rows - 1;
        int startCol = 0;

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] visited = new boolean[rows][cols];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        // Add start point to the queue with step count 0
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int steps = current[2];

            if (maze[r][c].equals("F")) {
                return steps; // Finish found
            }

            // Explore 4 directions
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                // Check bounds and wall
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols &&
                    !maze[newR][newC].equals("*") && !visited[newR][newC]) {

                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC, steps + 1});
                }
            }
        }

        return -1; // No path to finish found
    }
}



