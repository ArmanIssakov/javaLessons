package HW04;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class Node{
    int x,y,dist;
    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class CreateArray{
    static int[][] createMaze(int row, int col){
        int[][] maze = new int[row][col];
        Random rnd = new Random();
        for(int i = 0; i < maze.length;i++){
            for(int j = 0; j < maze[0].length; j ++){
                maze[i][j] = rnd.nextInt(2);
                System.out.print(maze[i][j] + " ");
                
            }
            System.out.println();
        }
        return maze;
    }
}
class Main{
    /* Вверх(х, у) --> (x - 1, y)
     * Налево(х, у) -->(x, y - 1)
     * Направо(x,y) -->(x, y + 1)
     * Вниз(x,y) -->(x + 1, y)
    */
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};
    private static boolean isValid(int[][] maze, boolean[][] visited, int row, int col){
        return (row >= 0) && (row < maze.length) && (col >= 0) && (col < maze[0].length)
                && maze[row][col] == 1 && !visited[row][col];
    }
    static int findShortesPathLength(int[][] maze, int ix, int jy, int x, int y){
        if(maze == null || maze.length == 0 || maze[ix][jy] == 0 || maze[x][y]==0){
            System.exit(0);
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new ArrayDeque<>();
        visited[ix][jy] = true;
        q.add(new Node(ix, jy, 0));
        int min_dist = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node node = q.poll();
            ix = node.x;
            jy = node.y;
            int dist = node.dist;
            if(ix == x && jy == y){
                min_dist = dist;
                break;
            }
            for(int k = 0; k < 4; k++){
                if(isValid(maze, visited,ix + row[k], jy + col[k])){
                    visited[ix + row[k]][jy + col[k]] = true;
                    q.add(new Node(ix+ row[k], jy + col[k], dist +1));
                }
            }
        }
        if(min_dist != Integer.MAX_VALUE){
            return min_dist;
        }
        return -1;
    }
    static void showShortesPathLength(int[][] maze, int ix, int jy, int x, int y){
        if(maze == null || maze.length == 0 || maze[ix][jy] == 0 || maze[x][y]==0){
            System.exit(0);
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new ArrayDeque<>();
        visited[ix][jy] = true;
        q.add(new Node(ix, jy, 0));
        int min_dist = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node node = q.poll();
            ix = node.x;
            // System.out.println(node.x);
            jy = node.y;
            // System.out.println(node.y);
            int dist = node.dist;
            if(ix == x && jy == y){
                min_dist = dist;
                break;
            }
            for(int k = 0; k < 4; k++){
                if(isValid(maze, visited,ix + row[k], jy + col[k])){
                    visited[ix + row[k]][jy + col[k]] = true;
                    maze[ix + row[k]][jy + col[k]] += dist;
                    q.add(new Node(ix+ row[k], jy + col[k], dist +1));
                }
            }
        }
        for(int i = 0; i < maze.length;i++){
            for(int j = 0; j < maze[0].length;j++){
                if(maze[i][j] > 10){
                    System.out.print(maze[i][j]+"   ");
                }
                else{
                    System.out.print(maze[i][j] + "    ");
                }
            }
            System.out.println();
        }
        System.out.println(String.format("От старта до финиша  %d шагов", min_dist));
    }
}
public class hw04 {

    public static void main(String[] args) {
        int[][] maze =         
        {
            //0  1  2  3  4  5  6  7  8  9
            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, //0
            { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 }, //1
            { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 }, //2
            { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, //3
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 }, //4
            { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, //5
            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, //6
            { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 }, //7
            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, //8
            { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 }, //9
        };
        Main.showShortesPathLength(maze, 0, 0, 7, 5);
    };
    
}
