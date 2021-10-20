package com.company;

public class Pair implements Comparable<Pair> {
    Integer distance;
    Integer index;
    public Pair(int distance, int index){
        this.distance = distance;
        this.index = index;
    }


    @Override
    public int compareTo(Pair o) {
        return distance.compareTo(o.distance);

    }
}
