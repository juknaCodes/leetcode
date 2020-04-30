import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode317 {
    /*public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] dist = new int[row][col];
        boolean[][] isVisited = new boolean[row][col];
        List<Point> buildings = new ArrayList();
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == 1) {
                    buildings.add(new Point(i,j,0));
                }
                grid[i][j] = -grid[i][j];
            }
        }

        for (Point pt : buildings) {
            dobfs(pt, grid, dist, isVisited, row, col);
            for (int i=0;i<row;i++) {
                for (int j=0;j<col;j++) {
                    isVisited[i][j] = false;
                }
            }
        }

        int ans = -1;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (ans < 0 || dist[i][j] < ans)
                    ans = dist[i][j];
            }
        }
        return ans;

    }

    private void dobfs(Point point, int[][] grid, int[][] dist, boolean[][] isVisited, int row, int col) {
        Queue<Point> neighbors = new LinkedList<>();

        neighbors.add(point);

        while(!neighbors.isEmpty()) {
            Point pt = neighbors.poll();
            dist[pt.x][pt.y] += pt.distance;
            int newX = pt.x-1, newY = pt.y;
            if (isValid(newX, newY, row, col) && !isVisited[newX][newY] && grid[newX][newY] >= 0) {
                neighbors.add(new Point(newX, newY, pt.distance+1));
                isVisited[newX][newY] = true;
            }
            newX = pt.x;
            newY = pt.y-1;
            if (isValid(newX, newY, row, col) && !isVisited[newX][newY] && grid[newX][newY] >= 0) {
                neighbors.add(new Point(newX, newY, pt.distance+1));
                isVisited[newX][newY] = true;
            }
            newX = pt.x;
            newY = pt.y+1;
            if (isValid(newX, newY, row, col) && !isVisited[newX][newY] && grid[newX][newY] >= 0) {
                neighbors.add(new Point(newX, newY, pt.distance+1));
                isVisited[newX][newY] = true;
            }
            newX = pt.x+1;
            newY = pt.y;
            if (isValid(newX, newY, row, col) && !isVisited[newX][newY] && grid[newX][newY] >= 0) {
                neighbors.add(new Point(newX, newY, pt.distance+1));
                isVisited[newX][newY] = true;
            }
        }
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >=0 && x< row && y >=0 && y <col;
    }*/
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        // Initialize building list and accessibility matrix `grid`
        List<Tuple> buildings = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1)
                    buildings.add(new Tuple(i, j, 0));
                grid[i][j] = -grid[i][j];
            }
        // BFS from every building
        for (int k = 0; k < buildings.size(); ++k)
            bfs(buildings.get(k), k, dist, grid, m, n);
        // Find the minimum distance
        int ans = -1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans))
                    ans = dist[i][j];
        return ans;
    }

    public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tuple b = q.poll();
            dist[b.y][b.x] += b.dist;
            for (int i = 0; i < 4; ++i) {
                int x = b.x + dx[i], y = b.y + dy[i];
                if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
                    grid[y][x] = k + 1;
                    q.add(new Tuple(y, x, b.dist + 1));
                }
            }
        }
    }
}
class Tuple {
    public int y;
    public int x;
    public int dist;

    public Tuple(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
class Point {
    int x;
    int y;
    int distance;

    Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
