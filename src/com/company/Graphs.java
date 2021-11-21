package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graphs{

        int[][] edgeGraph; //adjacancy array, for edgeGraphs and weight. Is the foundation of the graph.
        int [][] weightGraph;
        int numberofverticies; //number of vertices in the graph.
        int totalweight;

        public Graphs( int numberofverticies){ //constructor of the graph, where the arrays get updated after number of vertices.
            this.edgeGraph = new int[numberofverticies][numberofverticies];
            this.weightGraph = new int[numberofverticies][numberofverticies];
            this.numberofverticies = numberofverticies;
        }

        public void addEdge(int from, int to, int weight){ //adds and edgeGraph to the graph, and updates the lists.
            edgeGraph[from][to]=1; //is equal to one so the edgeGraphs get a uniqe number, 1 in this case
            weightGraph[from][to]= weight;
        }

        public void printGraph(){ //prints the graph, through a for-loop where fromi is created and is less than the edgeGraphs length
            for (int fromi = 0; fromi < edgeGraph.length; fromi++){ //
                System.out.println("From " + fromi); //the index number of the from vertex.
                for(int toj = 0; toj < edgeGraph.length; toj++){
                    if(edgeGraph[fromi][toj]==1){ //toj is the index number to the end vertex.
                        System.out.print("To " + toj + " ");
                        System.out.println("Length " + weightGraph[fromi][toj]+"km"); //prints the weight
                    }
                }

                System.out.println(" ");
            }
        }

        public void PrimsT(){
            int[] distance = new int[edgeGraph.length]; //distance array with the length of edgeGraph
            int[] predecessor = new int[edgeGraph.length]; //predecessor array with the edgeGraph length

            ArrayList<Pair> vertexPairs = new ArrayList<>(); //an arraylist of vertex pairs.
            MyHeap <Pair> Q = new MyHeap<>(); //a new myheap (q) with the type of pair.

            Arrays.fill(predecessor,-1); //Predecessor is 0
            Arrays.fill(distance,Integer.MAX_VALUE); //distance is set to infinite, or max value

            if (distance.length>0) //if the length of the distance array is greater than 0 the index 0 of the list is 0.
                distance[0]=0;

            for(int i = 0; i<edgeGraph.length; i++) { //iterator to add the pairs to the vertexpairs arraylist. insert the iterated indexes of vertexpair.
                vertexPairs.add(new Pair(distance[i], i));
                Q.insert(vertexPairs.get((i))); //now the q.arraylist is inserted with the weight of the iterated vertexpairs.
            }


            int MST = 0; //MST starts at zero

            while(!Q.isEmpty()){ //while the list of weights is not empty
                Pair minweight  = Q.extractMin(); //Pair minweight is the extracted minimum weight of the arraylist

                for (int v = 0; v<edgeGraph.length; v++){ //Iteration v ("to" index) with the length of edgeGraph.
                   if (edgeGraph[minweight.index][v]==1 && weightGraph[minweight.index][v] < distance[v]){ //If the edge is added(==1), and the weight with same indexes is less than the iterated indexes of the distance array.

                       distance[v] = weightGraph[minweight.index][v]; //then the iterated distance will collect the weight values of the pair.
                       predecessor[v] = minweight.index; //The index of the predecessor is updated to the pair index.
                       int pos = Q.getPosition(vertexPairs.get(v)); //Returns the the position of the vertexPairs indexes and is now in the integer pos to further use to decrease key.
                       vertexPairs.get(v).distance = weightGraph[minweight.index][v]; //the distance to the vertexPairs is equal to the weight of the pairs index and the iterator (to).
                       Q.decreasekey(pos); //decreases the key for the heap, swaps the current position and the parent position in the heap.
                   }
               }

               MST +=distance[minweight.index]; //The minimum spanning tree is the value of the weight found in the distance array on index u plus itself with each of iteration in the while loop..
           }

            System.out.println("Min Span tree distance");
            for (int i=0; i<edgeGraph.length; i++) { //iterator i is less than the length of the array
                System.out.println(i + "Parent " + predecessor[i] + " to " + i + " weight " + distance[i]);
               totalweight += distance[i];
           }
            System.out.println();
            System.out.println("The weight of minimum spanning tree is in total " + totalweight);
        }
}