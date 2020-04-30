import java.util.PriorityQueue;

/**
 * Created by ankujgup on 28-Apr-20.
 */
public class LeetCode265 {
    class HouseIdxToColorIdx {
        int x;
        int y;
        int cost;

        HouseIdxToColorIdx(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }
    public int minCostII(int[][] costs) {

        int row = costs.length;
        if (row == 0)
            return 0;
        int col = costs[0].length;
        if (col == 0)
            return 0;
        int cost = 0;
        HouseIdxToColorIdx lastColor = null;
        for (int i=0;i<row;i++) {
            PriorityQueue<HouseIdxToColorIdx> queue = buildColorCostQueue(costs[i], i);
            if (lastColor == null) {
                lastColor = queue.poll();
                cost+= lastColor.cost;
            } else {
                if (queue.peek().x != lastColor.x && queue.peek().y != lastColor.y) {
                    lastColor = queue.poll();
                    cost+= lastColor.cost;
                } else {
                    queue.poll();
                    lastColor = queue.poll();
                    cost+= lastColor.cost;
                }
            }
        }
        return cost;
    }

    private PriorityQueue<HouseIdxToColorIdx> buildColorCostQueue(int [] costs, int row) {
        PriorityQueue<HouseIdxToColorIdx> queue = new PriorityQueue<HouseIdxToColorIdx>((c1, c2) -> {
            if (c1.cost != c2.cost)
                return c1.cost - c2.cost;
            return c1.x - c2.x;
        });

        for(int i=0;i<costs.length;i++) {
            HouseIdxToColorIdx cost = new HouseIdxToColorIdx(i, row, costs[i]);
            queue.add(cost);
        }

        return queue;
    }
}
