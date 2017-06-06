package hrank.TriesContacts;

/**
 * Created by dipen on 5/31/2017.
 */

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tries tries = new Tries();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if(op.equals("add"))
            {
                tries.add(contact);

            }
            else
            {
                System.out.println(tries.find(contact));
            }
        }
    }
}

class Node{

    public HashMap<Character, Node> children = new HashMap<>();
    public boolean isComplete;
    public int size;
}

class Tries{

    Node root = new Node();


    public void add(String word)
    {
        Node currentNode = root;
        for(int i =0 ; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            currentNode.children.putIfAbsent(ch, new Node());
            currentNode = currentNode.children.get(ch);
            currentNode.size++;
        }
    }

    public int find(String prefix)
    {
        Node currentNode = root;

        for (int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
            currentNode = currentNode.children.get(ch);
            if(currentNode == null)
            {
                return 0;
            }
        }
        return  currentNode.size;
    }

}


/** solution 1
 import java.util.Scanner;
 import java.util.HashMap;

 public class Solution {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int n = scan.nextInt();
 Trie trie = new Trie();
 for (int i = 0; i < n; i++) {
 String operation = scan.next();
 String contact   = scan.next();
 if (operation.equals("add")) {
 trie.add(contact);
 } else if (operation.equals("find")) {
 System.out.println(trie.find(contact));
 }
 }
 scan.close();
 }
 }

 /* Based loosely on tutorial video in this problem
class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    Trie(){} // default constructor

    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    public void add(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;

        /* Traverse down tree to end of our prefix
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}
**/


/**
 Solution 2

 public static class Phone {
 String contact;
 int counter;
 Map<Character, Phone> map;

 public Phone() {
 map = new HashMap<Character, Phone>();
 counter=0;
 contact=null;
 }

 }

 public static Phone phone = new Phone();

 public void add(String contact) {
 Phone local = phone;
 for(Character c:contact.toCharArray()) {
 Phone local2 =local.map.get(c);
 if ( local2==null) {
 local2 = new Phone();
 local.map.put(c, local2);

 }
 local2.counter++;
 local = local2;
 }
 local.contact=contact; //buisness data
 }

 public void find(String contact) {
 Phone local = phone;
 for(Character c:contact.toCharArray()) {
 Phone local2 =local.map.get(c);
 if ( local2==null) {
 local=null;
 break;
 } else {
 local=local2;
 }
 }
 if ( local==null )
 System.out.println(0);
 else {
 System.out.println(local.counter);
 }
 }

 public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 int n = in.nextInt();
 Solution solution = new Solution();

 for(int a0 = 0; a0 < n; a0++){
 String op = in.next();
 String contact = in.next();

 if ( "add".equals(op) )
 solution.add(contact);

 if ( "find".equals(op) )
 solution.find(contact);

 }
 }
 }

 **/

/** Input
 4
 add hack
 add hackerrank
 find hac
 find hak
 **/
/** output
 2
 0
 **/