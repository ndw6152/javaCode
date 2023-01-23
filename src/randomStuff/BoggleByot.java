package randomStuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by ndw6152 on 7/24/2018.
 */
public class BoggleByot {

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public class Trie {
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
    }

    public void search(TreeSet<String> set, char[][]board, int r, int c, Trie dict, StringBuilder sb, HashSet<Integer> visited) {
        int rowSize = board.length;
        int colSize = board[0].length;

        if(r< 0 || r >= rowSize || c<0 || c >= colSize) {
            return;
        }

        int pos = r*rowSize + c;
        if(visited.contains(pos)) {
            return;
        }

        sb.append(board[r][c]);
        visited.add(pos);

        if(dict.searchPrefix(sb.toString())) {
            if(dict.searchWord(sb.toString())) {
                set.add(sb.toString());
            }

            search(set, board, r+1, c, dict, sb, visited); // bottom
            search(set, board, r-1, c, dict, sb, visited); // top
            search(set, board, r, c+1, dict, sb, visited); // right
            search(set, board, r, c-1, dict, sb, visited); // left
        }

        visited.remove(pos);
        sb.deleteCharAt(sb.length()-1);
    }


    public ArrayList<String> boggleByot(char[][] board, ArrayList<String> dictionary){
        int rowSize = board.length;
        int colSize = board[0].length;
        Trie dict = new Trie();
        for(String s : dictionary) {
            dict.insertWord(s);
        }

        TreeSet<String> set = new TreeSet<>();

        for(int r =0; r< rowSize; r++) {
            for(int c = 0; c < colSize; c++) {
                search(set, board, r, c, dict, new StringBuilder(), new HashSet<Integer>());
            }
        }



        return new ArrayList<String>(set);
    }
}
