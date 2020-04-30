import java.util.LinkedList;
import java.util.Queue;

class LeetCode1091 {
    class Position {
        int x;
        int y;
        int distance;

        Position(int x, int y, int distance) {
            this.x= x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int []offset = new int[]{-1,0,1};

        if (grid[0][0] == 1)
            return -1;
        boolean [][]isVisited = new boolean[row][col];
        Queue<Position> neighbors = new LinkedList();

        Position p1 = new Position(0,0,1);
        neighbors.add(p1);
        isVisited[0][0] = true;

        while(!neighbors.isEmpty()) {
            p1 = neighbors.poll();
            if (p1.x == row-1 && p1.y == col-1)
                return p1.distance;
            for (int i=0;i<offset.length;i++) {
                for (int j=0;j<offset.length;j++) {
                    int newX= p1.x + offset[i];
                    int newY = p1.y + offset[j];
                    if (newX == p1.x && newY == p1.y)
                        continue;

                    if (isValid(newX, newY, row, col) && grid[newX][newY] == 0
                            && !isVisited[newX][newY]) {
                        Position p2 = new Position(newX, newY, p1.distance+1);
                        neighbors.add(p2);
                        isVisited[newX][newY] = true;
                    }
                }
            }
        }

        return -1;

    }

    private boolean isValid(int x, int y, int row, int col) {
        return (x >=0 && x <row && y >=0 && y <col);
    }
}