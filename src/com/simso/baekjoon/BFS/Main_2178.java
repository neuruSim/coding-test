package com.simso.baekjoon.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

    static int board[][];
    static int dist[][];
    static boolean vis[][];
    static int n;
    static int m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String arg[]) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();

            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(board[n-1][m-1] +1);


        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) { //(i, j)를 시작점으로 하고 싶은 상황
                if(board[i][j] == 0 || vis[i][j]) continue;



                Queue<Point> Q = new LinkedList<>();
                vis[i][j] = true;
                Q.offer(new Point(i,j));



                int area = 0;  // 그림의 넓이

                while (! Q.isEmpty()){
                    area ++; // 큐에 들어있는 원소를 하나 뺄 때 마다 넓이를 1 증가시킴

                    Point cur = Q.poll();

                    for (int dir  = 0; dir  < 4; dir ++) { // 상하좌우 칸을 살펴볼 것이다
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir]; // nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;  // 범위 밖일 경우 넘어감

                        if(vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우

                        vis[nx][ny] = true; // (nx, ny)를 방문했다고 명시



                        Q.offer(new Point(nx, ny));
                    }

                }
            }
        }
    }
}
