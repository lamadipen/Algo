package com.dp.cci.graphandtrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class WallAndGate {

    public static void wallAndGate(int[][] rooms) {
        Queue<Integer> queue = new LinkedList<>();

        int rowLen = rooms.length;
        int colLen = rooms[0].length;

        if (rooms.length == 0) {
            return;
        }

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(row * rooms[0].length + col); //0 * 4 + 3 = 3 // 3 * 4 + 0 = 12
                }
            }
        }

        queue.stream().forEach(System.out::println);

        while (!queue.isEmpty()) {
            int head = queue.poll();
            int x = head / rowLen;
            int y = head % rowLen;

            if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
                rooms[x-1][y] = rooms[x][y]+1;
                queue.offer((x+1)*rowLen+colLen);
            }
            if(x < rowLen -1 && rooms[x+1][y] == Integer.MAX_VALUE){
                rooms[x+1][y] = rooms[x][y]+1;
                queue.offer((x+1)*rowLen+y);
            }
            if(y > 0 && rooms[x][y-1] == Integer.MAX_VALUE){
                rooms[x][y-1] = rooms[x][y]+1;
                queue.offer(x*rowLen+y-1);
            }
            if (y < colLen - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.offer(x*rowLen+colLen+1);
            }
        }
    }

    public static void main(String[] args) {
        //int [][] rooms = new int[4][4];
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {{INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}};

        //wallAndGate(rooms);
        findExitWallsAndGates(rooms);

        //Stream.of(rooms).forEach(System.out::print);
        for(int row = 0; row < rooms.length; row++){
            for(int col = 0; col < rooms[0].length; col++){
                System.out.print(rooms[row][col] + " ");
            }
            System.out.println(" ");
        }


    }


    public static void findExitWallsAndGates(int[][] room){
        Queue<Pair> queue = new LinkedList<>();
        int n = room.length;
        int m = room[0].length;
        //down, right, up, left
        Pair[] dirs = {new Pair(1, 0), new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1)};

        for(int i=0; i<room.length; i++){
            for(int j=0;j<room[0].length; j++){
                if(room[i][j] == 0){
                    queue.offer(new Pair(i, j));
                }
            }
        }

        //BFS search
        while(!queue.isEmpty()){
            Pair pos = queue.poll();
            int r = pos.first;
            int c = pos.second;

            for(Pair dir : dirs){
                int i = r+dir.first;
                int j = c+dir.second;

                //prune the tree
                if(i < 0 || j < 0 || i>=n || j >= m || room[i][j] <= room[r][c]+1){
                    continue;
                }

                room[i][j] = room[r][c]+1;
                queue.offer(new Pair(i, j));
            }
        }
    }
}
/* Question
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
0  -1 INF INF
 */

/* Answer
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

/**
 https://www.programcreek.com/2014/05/leetcode-walls-and-gates-java/

 http://massivealgorithms.blogspot.com/2015/09/leetcode-286-walls-and-gates.html

 http://www.learn4master.com/algorithms/leetcode-wall-and-gates

 https://www.geeksforgeeks.org/find-shortest-distance-guard-bank/

 https://stackoverflow.com/questions/26220456/door-in-an-infinite-wall-algorithm

 http://www.zrzahid.com/walls-and-gates-shortest-escape-paths/
 **/