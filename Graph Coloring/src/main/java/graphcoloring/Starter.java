package graphcoloring;

import graph.Graph;

public class Starter {
    public static void main(String[] args) {
        Graph g=new Graph(3);
        g.addEdge("V_0","V_2");
        g.addEdge("V_1","V_0",2.0);
        g.addVertex("B_1");
        g.addVertex("C_1");
        g.addEdge("B_1","C_1",3.2);
        g.addEdge("C_1","V_1",4.0);
        g.addVertex("D_1");
        g.addEdge("V_2","V_2",3.0);
//        g.show();
        g.getAdjVertex("V_2").forEach(v -> System.out.println(v.getName()));
    }
}
