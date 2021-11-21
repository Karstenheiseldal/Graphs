package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class MyHeap<T extends Comparable>{
    HashMap<T, Integer> positionTable=new HashMap<>();
    ArrayList<T> minheap;
    private int size;
    public MyHeap(){
        this.minheap=new ArrayList<T>();
        this.size=0;
    }

    public int getPosition(T item){
        return  positionTable.get(item);
    }

    public  boolean isEmpty(){if (size>0){
        return false;}
    return true;}

    private int parent(int pos){
        return (pos-1)/2;
    }
    private  int leftChild(int pos){
        return pos*2 +1;
    }
    private  int rightChild(int pos){
        return pos*2 +2;
    }
    private void swap(int pos1,int pos2){
        T dummy=minheap.get(pos1);
        minheap.set(pos1,minheap.get(pos2));
        minheap.set(pos2,dummy);
        positionTable.put(minheap.get(pos1),pos1);
        positionTable.put(minheap.get(pos2),pos2);
    }
    public void insert(T item){
        minheap.add(item);
        positionTable.put(item,size);
        size++;
        decreasekey(size-1);
    }
    public  void decreasekey(int pos){
        int currentpos=pos;
        while(minheap.get(currentpos).compareTo(minheap.get(parent(currentpos)))<0){
            swap(currentpos,parent(currentpos));
            currentpos=parent(currentpos);
        }
    }
    public T viewMin(){
        return minheap.get(0);
    }

    public T extractMin() { //Extracts the minimum in the minheap.
        T min = minheap.get(0);
        minheap.set(0, minheap.get(size - 1));
        positionTable.put(minheap.get(0), 0);
        size--;
        increasekey(0);
        return min;
    }

    private boolean movedown(int pos){
        boolean leftsmaller= leftChild(pos)<size && minheap.get(leftChild(pos)).compareTo(minheap.get(pos))<0;
        boolean rightsmaller = rightChild(pos)<size && minheap.get(rightChild(pos)).compareTo(minheap.get(pos))<0;
        return (leftsmaller || rightsmaller);
    }
    public void increasekey(int pos){
        int currentpos = pos;
        while (movedown(currentpos)){
            int rpos=rightChild(currentpos);
            int lpos=leftChild(currentpos);
            if(rpos<size && minheap.get(rpos).compareTo(minheap.get(lpos))<0){
                swap(rpos,currentpos);
                currentpos=rpos;
            }
            else{
                swap(lpos,currentpos);
                currentpos=lpos;
            }
        }
    }
}
