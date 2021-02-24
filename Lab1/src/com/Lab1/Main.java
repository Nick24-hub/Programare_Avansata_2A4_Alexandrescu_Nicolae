package com.Lab1;

import java.util.Random;

public class Main {

    public static void main(String [] args) {
        // apelez compulsory
        compulsory();
        // verific argumentul si apelez optional
        if(args.length<1)
        {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        optional(n);
    }

    public static void compulsory() {
        System.out.println("Hello World!");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        n+=0b10101;
        n+=0xFF;
        n*=6;
        int result;
        if(n%9!=0)
            result = n%9;
        else result = 9;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }


    public static void optional(int n) {
        // Creez matricea de adiacenta folosind 0,1 random
        int i, j;
        Random rand = new Random();
        int[][] m = new int[n][n];
        for (i = 0; i < n; ++i) {
            for (j = i; j < n; ++j)
                if (i != j)
                    m[i][j] = m[j][i] = rand.nextInt(2);
                else m[i][j] = 0;
        }
        String simbol0 = "\u25CB";
        String simbol1 = "\u25FC";

        // Afisez matricea de adiacenta
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (m[i][j] == 1)
                    System.out.print(simbol1 + " ");
                else System.out.print(simbol0 + " ");
            }
            System.out.print('\n');
        }

        // creez vector de vizitare si componente conexe

        int[] vis = new int[n];
        int nrcx = Is_Connected(vis, m);

        // Este conex?
        if (nrcx == 1) {
            System.out.print("Yes, the graph is connected.\n");
            int[][] arb=new int[n][n];
            for(i=0;i<n;i++)
                vis[i]=0;
            dfsarb(0,vis,m,arb);
            System.out.print("Partial tree adjacency matrix:\n");
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(arb[i][j] + " ");
                System.out.print('\n');
            }
        }
        else {
            boolean ok;
            System.out.print("No, the graph is not connected.\nConnected components:\n");
            for (i = 1; i <= nrcx; i++) {
                System.out.print(i + ". {");
                ok=false;
                for (j = 0; j < vis.length; j++) {
                    if(!ok && vis[j]==i) {
                        System.out.print(j);
                        ok=true;
                    }
                    else if(ok && vis[j] == i)
                        System.out.print(", " + j);
                }
                System.out.print("};\n");
            }
        }
    }

    private static int Is_Connected( int[] vis,int[][] m) {
        int i;
        for( i=0;i< vis.length;i++)
            vis[i]=0;
        int nrcx=0;
        for(i=0;i< vis.length;i++)
        {
            if(vis[i]==0) {
                nrcx++;
                dfs(i, vis, m, nrcx);
            }
        }
        return nrcx;
    }

    private static void dfsarb(int x, int[] vis, int[][] m, int[][] arb) {
        vis[x] = 1;
        for (int i = 0; i < m.length; i++)
            if (m[x][i] == 1 && vis[i]==0) {
                arb[x][i]=arb[i][x]=1;
                dfsarb(i,vis,m,arb);
            }
    }

    private static void dfs(int x, int[] vis, int[][] m, int nrcx) {
        vis[x] = nrcx;
        for (int i = 0; i < m.length; i++)
            if (m[x][i] == 1 && vis[i]==0) {
                dfs(i,vis,m,nrcx);
            }
    }


}

