package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graphs{

        int[][] edge; //adjacancy array, for edges and weight. Is the foundation of the graph.
        int [][] weightGraph;
        int numberofverticies; //number of vertices in the graph.
        int totalweight;
        int dummy;

        public Graphs( int numberofverticies){ //constructor of the graph, where the arrays get updated after number of vertices.
            this.edge = new int[numberofverticies][numberofverticies];
            this.weightGraph = new int[numberofverticies][numberofverticies];
            this.numberofverticies = numberofverticies;
        }

        public void addEdge(int from, int to, int weight){ //adds and edge to the graph, and updates the lists.
            edge[from][to]=1; //is equal to one so the edges get a uniqe number, 1 in this case
            weightGraph[from][to]= weight;
        }

        public void printGraph(){ //prints the graph, through a for-loop where fromi is created and is less than the edges length
            for (int fromi = 0; fromi < edge.length; fromi++){ //
                System.out.println("From " + fromi); //the index number of the from vertex.
                for(int toj = 0; toj < edge.length; toj++){
                    if(edge[fromi][toj]==1){ //toj is the index number to the end vertex.
                        System.out.print("To " + toj + " ");
                        System.out.println("Length " + weightGraph[fromi][toj]+"km"); //prints the weight
                    }
                }

                System.out.println(" ");
            }
        }

        public void PrimsT(){
            int[] d = new int[edge.length]; //distance array length of edge
            int[] p = new int[edge.length]; //predecessor array with the edge of length
            ArrayList<Pair> vertexPairs = new ArrayList<>();
            MyHeap <Pair> Q = new MyHeap<>(); //a new myHeap of the pairs of vertices

            Arrays.fill(p,0);
            Arrays.fill(d,Integer.MAX_VALUE);

            if (d.length>0)
                d[0]=0;

            for(int i = 0; i<edge.length; i++) {
                vertexPairs.add(new Pair(d[i], i));
                Q.insert(vertexPairs.get((i)));
            }


            int MST = 0;

            while(!Q.isEmpty()){
                Pair u = Q.extractMin();
                for (int v = 0; v<edge.length; v++){
                   if (edge[u.index][v]== 1 && weightGraph[u.index][v] < d[v]){
                       d[v] = weightGraph[u.index][v];
                       p[v] = u.index;
                       int pos = Q.getPosition(vertexPairs.get(v)); //Changing the position in the heap
                       vertexPairs.get(v).distance = weightGraph[u.index][v];
                       Q.decreasekey(pos);
                   }
               }

               MST +=d[u.index];
           }
            System.out.println("Min Span tree distance");
            for (int i=0; i<edge.length; i++) {
                System.out.println("Vertex " + p[i] + " to Vertex " + i + " weight " + d[i]);
                dummy = p[i];
               totalweight += d[i];
           }
            System.out.println();
            System.out.println("The weight of minimum spanning tree is in total " + totalweight);
        }
}