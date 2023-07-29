package truningkick.week_01;

import java.util.*;

public class BOJ_13549_숨바꼭질3 {
 
    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;
    static int max = 100000;
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        k = scan.nextInt();
        
        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }
    
    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));	//출발위치 추가
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;	//방문 시 해당 위치 true
            if(node.x == k) min = Math.min(min, node.time); //동생위치 도착 시 최단시간 최신화
            
            if(node.x * 2 <= max && visited[node.x * 2] == false) q.offer(new Node(node.x * 2, node.time));
            if(node.x + 1 <= max && visited[node.x + 1] == false) q.offer(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && visited[node.x - 1] == false) q.offer(new Node(node.x - 1, node.time + 1));
        }
    }
    
    public static class Node {
        int x;
        int time;
        
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
