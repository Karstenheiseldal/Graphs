package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList cities = new ArrayList();
        cities.add(0, "Eskildstrup");
        cities.add(1, "Haslev");
        cities.add(2, "Holbæk");
        cities.add(3, "Jægerspris");
        cities.add(4, "Kalundborg");
        cities.add(5, "Korsør");
        cities.add(6, "Køge");
        cities.add(7, "Maribo");
        cities.add(8, "Næstved");
        cities.add(9, "Ringsted");
        cities.add(10, "Slagelse");
        cities.add(11, "Nykøbing");
        cities.add(12, "Vordingborg");
        cities.add(13, "Sorø");
        cities.add(14, "Nakskov");
        cities.add(15, "Roskilde");

        int EskildstrupID = cities.indexOf("Eskildstrup");
        int HaslevID = cities.indexOf("Haslev");
        int HolbækID = cities.indexOf("Holbæk");
        int JægersprisID = cities.indexOf("Jægerspris");
        int KalundborgID = cities.indexOf("Kalundborg");
        int KorsørID = cities.indexOf("Korsør");
        int KøgeID = cities.indexOf("Køge");
        int MariboID = cities.indexOf("Maribo");
        int NæstvedID = cities.indexOf("Næstved");
        int RingstedID = cities.indexOf("Ringsted");
        int SlagelseID = cities.indexOf("Slagelse");
        int NykøbingID = cities.indexOf("Nykøbing");
        int VordingborgID = cities.indexOf("Vordingborg");
        int SorøID = cities.indexOf("Sorø");
        int NakskovID = cities.indexOf("Nakskov");
        int RoskildeID = cities.indexOf("Roskilde");

        int numberofverticies = cities.size();

        Graphs myGraph = new Graphs(numberofverticies);
        myGraph.addEdge(EskildstrupID, MariboID, 28);
        myGraph.addEdge(EskildstrupID, NykøbingID, 13);
        myGraph.addEdge(EskildstrupID, VordingborgID, 25);

        myGraph.addEdge(HaslevID, KorsørID, 60);
        myGraph.addEdge(HaslevID, KøgeID, 24);
        myGraph.addEdge(HaslevID, NæstvedID, 25);
        myGraph.addEdge(HaslevID, RingstedID, 19);
        myGraph.addEdge(HaslevID, RoskildeID, 47);
        myGraph.addEdge(HaslevID, SlagelseID, 48);
        myGraph.addEdge(HaslevID, SorøID, 34);
        myGraph.addEdge(HaslevID, VordingborgID, 40);

        myGraph.addEdge(HolbækID, JægersprisID, 34);
        myGraph.addEdge(HolbækID, KalundborgID, 44);
        myGraph.addEdge(HolbækID, KorsørID, 66);
        myGraph.addEdge(HolbækID, RingstedID, 36);
        myGraph.addEdge(HolbækID, RoskildeID, 32);
        myGraph.addEdge(HolbækID, SlagelseID, 46);
        myGraph.addEdge(HolbækID, SorøID, 34);

        myGraph.addEdge(JægersprisID, KorsørID, 94);
        myGraph.addEdge(JægersprisID, KøgeID, 58);
        myGraph.addEdge(JægersprisID, RingstedID, 56);
        myGraph.addEdge(JægersprisID, RoskildeID, 33);
        myGraph.addEdge(JægersprisID, SlagelseID, 74);
        myGraph.addEdge(JægersprisID, SorøID, 63);

        myGraph.addEdge(KalundborgID, RingstedID, 62);
        myGraph.addEdge(KalundborgID, RoskildeID, 70);
        myGraph.addEdge(KalundborgID, SlagelseID, 51);

        myGraph.addEdge(KorsørID, NæstvedID, 45);
        myGraph.addEdge(KorsørID, SlagelseID, 20);

        myGraph.addEdge(KøgeID, NæstvedID, 45);
        myGraph.addEdge(KøgeID, RingstedID, 28);
        myGraph.addEdge(KøgeID, RoskildeID, 25);
        myGraph.addEdge(KøgeID, VordingborgID, 60);

        myGraph.addEdge(MariboID, NakskovID, 27);
        myGraph.addEdge(MariboID, NykøbingID, 26);

        myGraph.addEdge(NæstvedID, RoskildeID, 57);
        myGraph.addEdge(NæstvedID, RingstedID, 26);
        myGraph.addEdge(NæstvedID, SlagelseID, 37);
        myGraph.addEdge(NæstvedID, SorøID, 32);
        myGraph.addEdge(NæstvedID, VordingborgID, 28);


        myGraph.addEdge(RingstedID, RoskildeID, 31);
        myGraph.addEdge(RingstedID, SorøID, 15);
        myGraph.addEdge(RingstedID, VordingborgID, 58);

        myGraph.addEdge(SlagelseID, SorøID, 14);


        myGraph.printGraph();
        myGraph.PrimsT();
        System.out.println("The price of the minimum spanning tree is " + myGraph.totalweight*100000 +" DKK");
        }
}
