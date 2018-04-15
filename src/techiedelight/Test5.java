package techiedelight;

import BinaryTree.Btree;
import BinaryTree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anonealio on 9/24/2017.
 * reorder a linkedlist
 */
class Test5 {
    boolean isFound;
    Test5() {
        isFound = false;
    }

    class Coord{
        int r;
        int c;

        public Coord(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }


    public boolean isValid(boolean[][] visited, int r, int c) {
        if(r >=0 && r < visited.length && c >=0 && c < visited[0].length && visited[r][c] != true) {
            return true;
        }
        return false;
    }

    public List<Coord> getNextSteps(boolean[][] visited, int r, int c, int step) {  //3
        List<Coord> result = new ArrayList<>();
        if(isValid(visited, r+step, c)) {  // down
            result.add( new Coord(r+step, c));
        }
        if(isValid(visited, r-step, c)) {
            result.add( new Coord(r-step, c));
        }
        if(isValid(visited, r, c-step)){
            result.add( new Coord(r, c-step));  //left
        }
        if(isValid(visited, r, c+step)) {
            result.add(new Coord(r,c+step));
        }
        return result;
    }
    public void backTrack(List<List<Coord>> allSolution,
                          List<Coord> solution,
                          int[][] grid,
                          int r,
                          int c,
                          boolean[][] visited) {

        if(r == grid.length-1 && c == grid[0].length-1) {
            allSolution.add(new ArrayList<>(solution));
            isFound = false;
            return;
        }

        List<Coord> neighbors = getNextSteps( visited,  r, c, grid[r][c]);
        int nextRow;
        int nextCol;

        for(Coord coord : neighbors) {
            nextRow = coord.r;   // 3, 1
            nextCol = coord.c;

            visited[nextRow][nextCol] = true;
            solution.add(coord);
            if(!isFound) {
                backTrack(allSolution, solution, grid, nextRow, nextCol, visited);
            }
            else {
                return;
            }
            visited[nextRow][nextCol] = false;
            solution.remove(solution.size()-1);
        }
    }

    public List<List<Coord>> findPath(int[][] grid) {
        List<List<Coord>> result = new ArrayList<>();
        int rowSize = grid.length;
        int colSize = 0;
        if(rowSize > 0) {
            colSize = grid[0].length;
        }
        if(rowSize == 0 || colSize== 0) {
            return result;
        }

        boolean[][] visited = new boolean[rowSize][colSize];
        List<Coord> solution = new ArrayList<>();
        solution.add(new Coord(0,0));
        visited[0][0] = true;
        backTrack(result, solution, grid, 0, 0, visited);
        return result;
    }



    public int findNumberOfSetBits(int value) {
        int count = 0;
        while(value != 0) {
            count += value &1;
            value = value>>>1;
        }
        return count;
    }

    public int findSum(Node root) {
        if(root == null) {
            return 0;
        }
        int value = findSum(root.left) + findSum(root.right);
        int old = root.value;
        root.value = value;
        return root.value + old;
    }

    public void testFindSumBinaryTree() {
        Node start = new Node(50, new Node(9, new Node(4, null,null),new Node(5,null,null)), new Node(13, new Node(6,null,null), new Node(7,null,null)));
        System.out.println(findSum(start));
        System.out.println();


    }



    public static void main(String[] args) {
        Test5 t = new Test5();

        int[][] grid =
                {       {1,3,5,2},
                        {5,4,1,1},
                        {3,2,1,8},
                        {1,1,1,2},
                        {2,2,1,2}
                };

        List<List<Coord>> result = t.findPath(grid);
        for(int i =0; i <result.size(); i++) {
            for(Coord coord : result.get(i)) {
                System.out.print("("+coord.r + "," + coord.c+")  ");
            }
            System.out.println();
        }

        System.out.println(t.findNumberOfSetBits(100));
        System.out.println(t.findNumberOfSetBits(-1));
        System.out.println(t.findNumberOfSetBits(5));
        System.out.println(t.findNumberOfSetBits(-2));


        System.out.println("----------------");
        t.testFindSumBinaryTree();
    }
}

