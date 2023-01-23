package BinaryTree;

import randomStuff.HouseRobber3;

import java.util.*;

/**
 * Created by Anonealio on 6/13/2017.
 */


public class Btree {

    private Node root;

    public Btree() {

    }

    public Btree(Node n) {
        root = n;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int val) {
        if (root == null) {
            Node temp = new Node(val, null, null);
            root = temp;
            return;
        }
        if (val < root.value) {
            root.left = insert2(root.left, val);
        } else {
            root.right = insert2(root.right, val);
        }
    }

    public void insert(int val, Node root) {
        if (val < root.value) {
            if (root.left == null) {
                Node temp = new Node(val, null, null);
                root.left = temp;
            } else {
                insert(val, root.left);
            }
        } else {
            if (root.right == null) {
                Node temp = new Node(val, null, null);
                root.right = temp;
            } else {
                insert(val, root.right);
            }
        }
    }


    public Node insert2(Node root, int val) {
        if (root == null) {
            return new Node(val, null, null);
        }
        if (val < root.value) {
            root.left = insert2(root.left, val);
        } else {
            root.right = insert2(root.right, val);
        }
        return root;

    }

    public Node insertIterative(Node root, int val) {
        Node current = root;
        while (current != null) {
            if (val <= current.value) {
                if (current.left == null) {
                    current.left = new Node(val, null, null);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(val, null, null);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }


    public Node remove(Node root, int val) {
        if(root != null) {
            if(root.value == val) {
                root = deleteNode(root);
            }
            else if(val < root.value) {
                root.left = remove(root.left, val);
            }
            else {
                root.right = remove(root.right, val);
            }
        }
        return root;
    }

    // function finds the minimum value from a node in a BST
    // loops left until null, return prev value.
    public Node findMinNode(Node node) {
        if(node == null) {
            return null;
        }

        while(node.left != null) {
            node = node.left;
        }

        System.out.println("hellooo: " + node.value);
        return node;
    }

    public Node deleteNode(Node node) {
        if(node == null) {
            return null;
        }
        if(node.left == null) {
            return node.right;
        }
        else if(node.right == null) {
            return node.left;
        }

        // has two children
        Node minRightNode = findMinNode(node.right);
        remove(node, minRightNode.value);
        node.value = minRightNode.value;
        return node;
    }


// Traversals
    public void BFSbtree() {
        Node temp = root;
        java.util.Queue<Node> q = new LinkedList<>();

        if (temp != null) {
            q.add(temp);

            while (!q.isEmpty()) {
                Node current = q.poll();
                if (!current.visited) {
                    System.out.print(current.value + " ");
                    q.add(current.left);
                    q.add(current.right);
                    current.visited = true;
                }
            }
        }
    }

    public void DFSbtree() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();

        if (temp != null) {
            stack.push(temp);

            while (!stack.isEmpty()) {
                Node current = stack.pop();
                if (!current.visited) {
                    System.out.print(current.value + " ");
                    stack.push(current.left);
                    stack.push(current.right);
                    current.visited = true;
                }
            }
        }
    }

    public void levelTraversal() {
        Node temp = root;
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.add(temp);

        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                Node val = currentLevel.poll();
                if (val != null) {
                    System.out.print(val.value + " ");
                    nextLevel.add(val.left);
                    nextLevel.add(val.right);
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
    }

    public ArrayList<ArrayList<Integer>> levelTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) {
            result.add(new ArrayList<>());
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int n = queue.size();
            TreeNode cur;
            for(int i =0; i< n; i++) {
                cur = queue.poll();
                currentLevel.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }


    public void inOrderTraversal(Node root, boolean ascending) {
        if (root == null) {
            return;
        }
        if (ascending) {
            inOrderTraversal(root.left, ascending);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right, ascending);
        } else {
            inOrderTraversal(root.right, ascending);
            System.out.print(root.value + " ");
            inOrderTraversal(root.left, ascending);
        }
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value + " ");

    }

    public boolean isPath(Node start, Node dest) {
        if (start != null || dest != null) {
            return false;
        }

        Node temp = start;
        java.util.Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current != null) {
                if (!current.visited) {

                    if (current == dest) {
                        return true;
                    }
                    q.add(current.left);
                    q.add(current.right);
                }
            }
        }
        return false;
    }


    /// Function checking if diff between left and right side of tree is not greater than 1
    /// if it is then, stop recursing and push the error message
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int right = getHeight(root.right);
        if (right == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        System.out.println(left - right);
        if (Math.abs(left - right) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public boolean isBalanced(Node root) {
        return getHeight(root) != Integer.MIN_VALUE;
    }





    public int height2(TreeNode root, int[] result) {
        if(root == null) {
            return 0;
        }
        int left = height2(root, result);
        int right = height2(root.right, result);

        if(Math.abs(left - right) > 1) {
            result[0] = 0;
        }

        return 1 + Math.max(left, right);
    }

    public int isBalanced2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = 1;
        height2(root, result);
        return result[0];
    }


    public int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        queue.add(root);
        depthQueue.add(1);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int depth = depthQueue.poll();
            System.out.println(depth + "\n");
            if(visited.contains(cur)) {
                continue;
            }

            if(cur != null) {
                queue.add(root.left);
                queue.add(root.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }

        return 0;
    }



    public static void main(String[] args) {
        Node _25 = new Node(25, null, new Node(45, null, null));
        Node _75 = new Node(75, new Node(65, null, null), new Node(90, null, null));
        Node _50 = new Node(50, _25, _75);
        Node _200 = new Node(200, null, null);
        Node root = new Node(100, _50, _200);
        Btree b = new Btree(root);

        b.levelTraversal();
        b.insert(30);
        b.insert(35);
        b.insert(15);

        b.insert(10);
        b.levelTraversal();


        System.out.println("------------");

        Node start = new Node(100, null, null);
        Btree tree = new Btree(start);

        tree.insert2(start, 45);
        tree.insert2(start, 105);
        tree.insert2(start, 200);
        tree.insert2(start, 150);
        tree.insert2(start, 10);
        tree.insert2(start, 55);
        tree.insert2(start, 50);
        tree.insert2(start, 70);

        tree.levelTraversal();

        System.out.println("----- deletion 45 replaced by min node on right side aka 50-------");
        tree.remove(start, 45);
        tree.levelTraversal();

        System.out.println("----- deletion 105 replaced by right node since left node is null -------");
        tree.remove(start, 105);
        tree.levelTraversal();


        System.out.println("--------inorder -----");
        tree.inOrderTraversal(start, true);
        System.out.println();
        tree.inOrderTraversal(start, false);
        System.out.println();

        System.out.println("--------preorder-----");
        tree.preOrderTraversal(start);

        System.out.println("--------postorder-----");
        tree.postOrderTraversal(start);


        System.out.println("-------------");
        Node start2 = new Node(15, null, null);
        Btree tree2 = new Btree(start2);
        tree2.insert2(start2, 10);
        tree2.insert2(start2, 20);
        tree2.insert2(start2, 8);
        tree2.insert2(start2, 12);
        tree2.insert2(start2, 25);
        tree2.insertIterative(start2, 16);
        tree2.inOrderTraversal(start2, false);
        System.out.println("\n-------------");
        tree2.levelTraversal();

    }


}

