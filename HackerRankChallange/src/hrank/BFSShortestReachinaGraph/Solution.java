package hrank.BFSShortestReachinaGraph;

/**
 * Created by dipen on 6/4/2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();

        for (int i=0; i < query; i++)
        {
            int noNode = sc.nextInt();
            int noEdge = sc.nextInt();
            HashMap<Integer,LinkedList<Integer>> node = new HashMap<>();

            for (int j=1;j <= noNode; j++)
            {
                node.put(j,new LinkedList<>());
            }
            for (int k=0; k < noEdge; k++)
            {
                int source = sc.nextInt();
                int destination = sc.nextInt();

                LinkedList<Integer> adjcentList =  node.get(source);
                adjcentList.add(destination);
                node.put(source,adjcentList);
            }

            int start = sc.nextInt();

            for (int j=1;j <= noNode; j++)
            {
                if(j!=start)
                {
                    System.out.print(performBFS(start,j,node));
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static int performBFS(int start, int destination,HashMap<Integer, LinkedList<Integer>> node) {
        Queue<Integer> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(start);

        int[] distances = new int[node.size()+1];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        int count =0;
        while(!nextToVisit.isEmpty())
        {
            int head = nextToVisit.poll();
            if(head == destination)
            {
                return distances[head];
            }
            if(visited.contains(head))
            {
                continue;
            }
            visited.add(head);
            for (int child: node.get(head)) {
                nextToVisit.add(child);
                distances[child] = distances[head] + 6;
            }
        }
        return -1;
    }
}


/**

 public static class Graph {
 List<List<Integer>> adjLst;
 int size;
 public Graph(int size) {
 adjLst = new ArrayList<>();
 this.size = size;
 while(size-- > 0)//Initialize the adjancency list.
 adjLst.add(new ArrayList<Integer>());
 }

 public void addEdge(int first, int second) {
 adjLst.get(first).add(second);
 adjLst.get(second).add(first);
 // For undirected graph, you gotta add edges from both sides.
 }

 public int[] shortestReach(int startId) { // 0 indexed
 int[] distances = new int[size];
 Arrays.fill(distances, -1); // O(n) space.
 Queue<Integer> que = new LinkedList<>();

 que.add(startId); // Initialize queue.
 distances[startId] = 0;
 HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized. I leave it to you to optimize it.

 seen.add(startId);
 while(!que.isEmpty()) { // Standard BFS loop.
 Integer curr = que.poll();
 for(int node : adjLst.get(curr)) {
 if(!seen.contains(node)) {
 que.offer(node);
 // Right place to add the visited set.
 seen.add(node);
 // keep on increasing distance level by level.
 distances[node] = distances[curr] + 6;
 }
 }
 }
 return distances;
 }
 }
 **/