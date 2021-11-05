package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graphs{

        int[][] edge;
        int [][] weight;
        int numberofverticies;

        public Graphs( int numberofverticies){
            this.edge = new int[numberofverticies][numberofverticies];
            this.weight = new int[numberofverticies][numberofverticies];
            this.numberofverticies = numberofverticies;
        }

        public void addEdge(int from, int to, int weight){
            this.edge[from][to]=1;
            this.weight[from][to]= weight;
        }

        public void printGraph(){
            for (int fromi = 0; fromi < edge.length; fromi++){
                System.out.println("From " + fromi);
                for(int toj = 0; toj < edge.length; toj++){
                    if(edge[fromi][toj]==1){
                        System.out.print("To " + toj + " ");
                        System.out.println("Length " + weight[fromi][toj]+"km");
                    }
                }

                System.out.println(" ");
            }
        }

        public void PrimsT(){
            int[] d = new int[edge.length]; //distance
            int[] p = new int[edge.length]; //predecessor

            MyHeap <Pair> Q = new MyHeap<>();
            ArrayList<Pair> vertexPairs = new ArrayList<>();
            Arrays.fill(d,-1);
            Arrays.fill(p,Integer.MAX_VALUE);

            if (d.length>0)
                d[0]=0;

            for(int i = 0; i<edge.length; i++) {
                vertexPairs.add(new Pair(d[i], i));
                Q.insert(new Pair(d[i], i));
            }

            int pos = Q.getPosition(vertexPairs.get(0));
            vertexPairs.get(0).distance = 0;
            Q.decreasekey(pos);
            int MST = 0;

            while(!Q.isEmpty()){
                Pair u = Q.extractMin();
                for (int v = 0; v<edge.length; v++){
                    if (edge[u.index][v]== 1 && weight[u.index][v] < d[v]){
                        d[v] = weight[u.index][v];
                        p[v] = u.index;
                        pos = Q.getPosition(vertexPairs.get(v)); //Changing the position in the heap
                        vertexPairs.get(v).distance = d[v];
                        Q.decreasekey(pos);
                    }
                }

                MST +=d[u.index];
                System.out.println("Edge " + p[u.index] + "," + u.index +  d[u.index] + "km");

            }
        }
}