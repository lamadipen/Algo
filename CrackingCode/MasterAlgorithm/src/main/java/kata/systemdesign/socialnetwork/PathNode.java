package kata.systemdesign.socialnetwork;

import java.util.LinkedList;

public class PathNode {
    Person person = null;
    PathNode previousNode = null;

    public PathNode(Person person, PathNode previousNode) {
        this.person = person;
        this.previousNode = previousNode;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}
