package BinaryTree;

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.IntStream;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        if (word.length() == 0) {
            return;
        }
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {    // this char does not exist, add a new connection
                cur.children.put(ch, new TrieNode(ch));
            }
            cur = cur.children.get(ch);             // get the actual node
            if (i == word.length() - 1) {
                cur.isLeaf = true;
            }
        }
    }

    public Boolean searchWord(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (Character ch : arr) {
            if (cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            } else {
                return false;
            }
        }
        return cur.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (Character ch : arr) {
            if (cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Trie t = new Trie();

        t.insertWord("ABC");
        t.insertWord("AS");

        System.out.println("-Those words do not exist");
        System.out.println(t.searchWord("ZZ"));
        System.out.println(t.searchWord("B"));

        System.out.println("-Those words are not full words in the trie");
        System.out.println(t.searchWord("AB"));
        System.out.println(t.searchWord("B"));

        System.out.println("-Those are full words");
        System.out.println(t.searchWord("ABC"));
        System.out.println(t.searchWord("AS"));


        System.out.println("-Those are full prefix");
        System.out.println(t.searchPrefix("ABC"));
        System.out.println(t.searchPrefix("AB"));
        System.out.println(t.searchPrefix("A"));

        System.out.println("-Those are not prefix");
        System.out.println(t.searchPrefix("AC"));
        System.out.println(t.searchPrefix("SSS"));


        Trie dictionary = new Trie();
        dictionary.insertWord("java");
        boolean val1 = dictionary.searchPrefix("j")  ;
        System.out.println(val1);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("1");arr.add("1");arr.add("1");
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("5");arr3.add("3");arr3.add("4");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.addAll(arr);
        arr2.addAll(arr3);
        arr3.add("7");arr3.add("9");arr3.add("11");
        System.out.println(arr2);
    }
}