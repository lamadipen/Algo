package kata.systemdesign.socialnetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * System Design and Scalability
 * Social Network
 * CC: pg 145 Q: 9.2
 */
public class FindFriends {

    LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() || !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return merge(sourceData, destData, collision.id);
            }

            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return merge(sourceData, destData, collision.id);
            }
        }
        return null;
    }

    private LinkedList<Person> merge(BFSData sourceData, BFSData destData, int personId) {
        PathNode end1 = sourceData.visited.get(personId);
        PathNode end2 = destData.visited.get(personId);

        LinkedList<Person> path1 = end1.collapse(false);
        LinkedList<Person> path2 = end2.collapse(true);
        path2.removeFirst();
        path1.addAll(path2);

        return path1;
    }

    private Person searchLevel(HashMap<Integer, Person> people, BFSData sourceData, BFSData destData) {
        int count = sourceData.toVisit.size();

        for (int i = 0; i < count; i++) {
            PathNode pathNode = sourceData.toVisit.poll();
            int personId = pathNode.person.id;

            if (destData.visited.containsKey(personId)) {
                return pathNode.person;
            }

            Person person = pathNode.person;

            List<Integer> friends = person.friends;

            for (int friendId : friends) {
                if (!sourceData.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    sourceData.visited.put(friendId, next);
                    sourceData.toVisit.add(next);
                }
            }
        }
        return null;
    }
}
