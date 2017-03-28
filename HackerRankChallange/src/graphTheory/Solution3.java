package graphTheory;

/**
 * Created by dipen on 3/18/2017.
 */

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            Map<Integer,List<Integer>> adjList = new HashMap<>();
            //System.out.println("Round "+a0);
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                adjList= createAdjList(city_1,city_2,adjList);
            }
            int noRoads = bfs(1,adjList);
            int costRoadLib = (noRoads*y)+x;
            //System.out.println("no raod" +noRoads+" y"+y+" x"+x);
            int costAllLib = n * x;
            System.out.println(Math.min(costAllLib,costRoadLib));
            //adjList.forEach((k,v)->System.out.println(k+ " "+ v.toString()));
        }
    }

    public static Map createAdjList(int city_1, int city_2,Map<Integer,List<Integer>> adjList)
    {
        List<Integer> adjVertex = adjList.get(city_1);
        if(adjVertex == null)
        {
            adjVertex = new ArrayList<>();
            adjVertex.add(city_2);
            adjList.put(city_1,adjVertex);
        }
       else
        {
            adjVertex.add(city_2);
            //System.out.println("adjList Size" + adjList.size());
            adjList.put(city_1,adjVertex);
        }

        adjVertex = adjList.get(city_2);

        if(adjVertex == null)
        {
            adjVertex = new ArrayList<>();
            adjVertex.add(city_1);
            adjList.put(city_2,adjVertex);
        }
        else
        {
            adjVertex.add(city_1);
            //System.out.println("adjList Size" + adjList.size());
            adjList.put(city_2,adjVertex);
        }
        return  adjList;
    }

    public static int bfs(int start,Map<Integer,List<Integer>> adjList)
    {
        Queue<Integer> bQueue = new LinkedList<>();
        List<Integer> visitedList = new ArrayList<>();
        bQueue.add(start);
        int distance =-1;
        while (!bQueue.isEmpty())
        {
            int visited = bQueue.remove();

            if(!visitedList.contains(visited))
            {
                visitedList.add(visited);

                List<Integer> adjVertex = adjList.get(visited);

                for (Integer vertex: adjVertex) {
                    bQueue.add(vertex);
                }
                distance++;
                //System.out.println("Inside bfs" +visited + distance);
            }
        }
        return distance;
    }
}
