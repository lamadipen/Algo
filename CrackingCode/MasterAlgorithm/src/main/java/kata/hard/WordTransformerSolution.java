package kata.hard;

import java.util.*;

/**
 * Hard
 * Word Transform
 * CC: pg 187 Q: 17.11
 */
public class WordTransformerSolution {

    public List<String> transform(String start, String end, String[] words) {
        Set<String> dictonary = buildDicotnary(words);
        Set<String> visited = new HashSet<>();
        return transform(visited, start.toLowerCase(), end.toLowerCase(), dictonary);
    }

    private List<String> transform(Set<String> visited, String start, String end, Set<String> dictonary) {
        if (start.equals(end)) {
            LinkedList<String> path = new LinkedList<>();
            //path.add(start);
            return path;
        } else if (visited.contains(start) || !dictonary.contains(start)) {
            return null;
        }
        visited.add(start);
        List<String> children = getOneWordAway(start);
        for (String word : children) {
            LinkedList<String> path = (LinkedList<String>) transform(visited, word, end, dictonary);

            if (path != null) {
                path.addFirst(word);
                return path;
            }
        }
        return null;
    }

    private List<String> getOneWordAway(String word) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String w = word.substring(0, i) + c + word.substring(i + 1);
                words.add(w);
            }
        }
        return words;
    }

    private Set<String> buildDicotnary(String[] words) {
        Set<String> dictonary = new HashSet<>();
        for (String word : words) {
            dictonary.add(word.toLowerCase());
        }
        return dictonary;
    }

    public List<String> transformBFS(String start, String end, String[] words) {
        Map<String, List<String>> wildcardToList = createWildcardToWordMap(words);
        BFSData startBFS = new BFSData(start);
        BFSData endBFS = new BFSData(end);

        while (!startBFS.isFinished() && !endBFS.isFinished()) {
            String collusion = searchLevel(startBFS, endBFS, wildcardToList);

            if (collusion != null) {
                return merge(startBFS, endBFS, collusion);
            }

            collusion = searchLevel(endBFS, startBFS, wildcardToList);

            if (collusion != null) {
                return merge(startBFS, endBFS, collusion);
            }
        }

        return null;
    }

    private List<String> merge(BFSData startBFS, BFSData endBFS, String collusion) {
        PathNode end1 = startBFS.visited.get(collusion);
        PathNode end2 = endBFS.visited.get(collusion);

        LinkedList<String> pathOne = end1.collapse(false);//forward
        LinkedList<String> pathTwo = end2.collapse(true);// reverse

        pathTwo.removeFirst();
        pathOne.addAll(pathTwo);

        return pathOne;
    }

    private String searchLevel(BFSData startBFS, BFSData endBFS, Map<String, List<String>> wildcardToList) {
        int count = startBFS.toVisit.size();

        for (int i = 0; i < count; i++) {
            PathNode pathNode = startBFS.toVisit.poll();
            String word = pathNode.word;

            if (endBFS.visited.containsKey(word)) {
                return word;
            }

            List<String> children = getValidLinkedWords(word, wildcardToList);

            for (String w : children) {
                PathNode next = new PathNode(w, pathNode);
                startBFS.visited.put(w, next);
                startBFS.toVisit.add(next);
            }
        }
        return null;
    }

    private List<String> getValidLinkedWords(String word, Map<String, List<String>> wildcardToWords) {
        ArrayList<String> wildcards = getWildcardRoots(word);
        ArrayList<String> linkedWords = new ArrayList<>();

        for (String wildCard : wildcards) {
            List<String> words = wildcardToWords.get(wildCard);
            for (String linkedWord : words) {
                if (!linkedWord.equals(word)) {
                    linkedWords.add(linkedWord);
                }
            }
        }
        return linkedWords;
    }

    private ArrayList<String> getWildcardRoots(String word) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String w = word.substring(0, i) + "_" + word.substring(i + 1);
            words.add(w);
        }
        return words;
    }

    private Map<String, List<String>> createWildcardToWordMap(String[] words) {
        HashMap<String, List<String>> wildcardToWords = new HashMap<>();
        for (String word : words) {
            ArrayList<String> linked = getWildcardRoots(word);
            for (String linkedWord : linked) {
                if (wildcardToWords.containsKey(linkedWord)) {
                    List<String> wordList = wildcardToWords.get(linkedWord);
                    wordList.add(word);
                } else {

                    List<String> wordList = new ArrayList();
                    wordList.add(word);
                    wildcardToWords.put(linkedWord, wordList);
                }
            }
        }
        return wildcardToWords;
    }
}


class BFSData {
    Queue<PathNode> toVisit = new LinkedList<>();
    Map<String, PathNode> visited = new HashMap<>();

    public BFSData(String root) {
        PathNode srcPath = new PathNode(root, null);
        toVisit.add(srcPath);
        visited.put(root, srcPath);
    }

    public boolean isFinished() {
        return this.toVisit.isEmpty();
    }
}

class PathNode {
    String word;
    PathNode previous;

    public PathNode(String word, PathNode previous) {
        this.word = word;
        this.previous = previous;
    }

    public LinkedList<String> collapse(boolean startWithRoot) {
        LinkedList<String> path = new LinkedList<>();
        PathNode node = this;

        while (node != null) {
            if (startWithRoot) {
                path.addLast(node.word);
            } else {
                path.addFirst(node.word);
            }
            node = node.previous;
        }
        return path;
    }
}