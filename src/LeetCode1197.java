import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ankujgup on 02-May-20.
 */
class LeetCode1197 {
    class Position {
        int x;
        int y;
        int cost;
        Position (int x, int y , int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }
    public int minKnightMoves(int x, int y) {
        int offset[] = new int[]{-2,-1,1,2};
        Queue<Position> bfs = new LinkedList();
        Position start = new Position(0,0,0);
        bfs.add(start);

        while(!bfs.isEmpty()) {
            Position p = bfs.poll();
            if (p.x == x && p.y == y)
                return p.cost;
            for (int i =0;i<offset.length;i++) {
                for (int j=0;j<offset.length;j++) {
                    if (offset[i] == offset[j] || offset[i] == (-1*offset[j]))
                        continue;
                    Position newPosition = new Position(p.x + offset[i], p.y+offset[j], p.cost+1);
                    bfs.add(newPosition);

                }
            }
        }

        return -1;

    }
}