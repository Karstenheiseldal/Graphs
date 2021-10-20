package com.company;

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
            for (int from = 0; from < edge.length; from++) {
                for(int to = 0; to < edge.length; to++){
                    System.out.println("Hey");
                }
            }
        }

        public void PrimsT(){
            int[] d = new int[edge.length];
            int[] p = new int[edge.length];
            MyHeap <Pair> Q = new MyHeap<>();
            Pair[] vertexPair = new Pair[edge.length];

            for(int i = 0; i<edge.length; i++){
                d[i] = Integer.MAX_VALUE;
                p[i] = -1;
                Pair newPair = new Pair(d[i], i);
                Q.insert(newPair);
                vertexPair[i] = newPair;
            }

            if (d.length>0)
                d[0]=0;
            int pos = Q.getPosition(vertexPair[0]);
            vertexPair[0].distance = 0;
            Q.decreasekey(pos);
            int MST = 0;

            while(!Q.isEmpty()){
                Pair u = Q.extractMin();
                for (int v = 0; v<numberofverticies; v++){
                    if (edge[u.index][v]== 1 && weight[u.index][v] < d[v]){
                        d[v] = weight[u.index][v];
                        p[v] = u.index;
                        pos = Q.getPosition(vertexPair[v]);
                        vertexPair[v].distance = d[v];
                        Q.decreasekey(pos);
                    }
                }

                MST +=d[u.index];
                System.out.println("Edge " + p[u.index] + " , " + u.index + "Weight " + d[u.index]);

            }

        }
}
