import java.util.LinkedList;

/**
 * Created by ankujgup on 23-Mar-20.
 */
class WallsAndGates {
  class Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }
  public void wallsAndGates(int[][] rooms) {
    int row = rooms.length;
    int col = rooms[0].length;
    LinkedList<Coordinate> gates = new LinkedList<Coordinate>();
    for (int i=0;i<row;i++) {
      for (int j=0;j<col;j++) {
        if (rooms[i][j] == 0) {
          gates.add(new Coordinate(i,j));
        }
      }
    }

    while(!gates.isEmpty()) {
      Coordinate gate = gates.poll();

      int neighborX = gate.x-1;
      int neighborY = gate.y;

      if (isValid(neighborX, neighborY, row, col) && rooms[neighborX][neighborY] == Integer.MAX_VALUE) {
        rooms[neighborX][neighborY] = Math.min(rooms[gate.x][gate.y] +1, rooms[neighborX][neighborY]);

        gates.add(new Coordinate(neighborX,neighborY));
      }

      neighborX = gate.x+1;
      neighborY = gate.y;

      if (isValid(neighborX, neighborY, row, col) && rooms[neighborX][neighborY] == Integer.MAX_VALUE) {
        rooms[neighborX][neighborY] = Math.min(rooms[gate.x][gate.y] +1, rooms[neighborX][neighborY]);
        gates.add(new Coordinate(neighborX,neighborY));
      }

      neighborX = gate.x;
      neighborY = gate.y+1;

      if (isValid(neighborX, neighborY, row, col) && rooms[neighborX][neighborY] == Integer.MAX_VALUE) {
        rooms[neighborX][neighborY] = Math.min(rooms[gate.x][gate.y] +1, rooms[neighborX][neighborY]);
        gates.add(new Coordinate(neighborX,neighborY));
      }

      neighborX = gate.x;
      neighborY = gate.y-1;

      if (isValid(neighborX, neighborY, row, col) && rooms[neighborX][neighborY] == Integer.MAX_VALUE) {
        rooms[neighborX][neighborY] = Math.min(rooms[gate.x][gate.y] +1, rooms[neighborX][neighborY]);
        gates.add(new Coordinate(neighborX,neighborY));
      }

    }

  }

  private boolean isValid(int x, int y, int maxRow, int maxCol) {
    return x >=0 && x < maxRow && y >=0 && y < maxCol;
  }
}
