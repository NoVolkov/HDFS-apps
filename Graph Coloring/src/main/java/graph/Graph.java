package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Graph(int n) {
        this();

        for (int i = 0; i < n; i++) {
            addVertex("V_" + i);
        }
        System.out.println(
                "Vertices has been created: "+
                        vertices.stream().map(v->v.getName()).collect(Collectors.toList())
        );
    }

    public boolean addVertex(String name) {
        return addVertex(name, 0.0);
    }

    public boolean addVertex(String name, Double weight) {
        if (isExistVertex(name)) return false;
        vertices.add(new Vertex(name, weight));
        return true;
    }

    public boolean removeVertex(String name) {
        if (!isExistVertex(name)) return false;
        vertices.removeIf(v -> v.getName().equals(name));
        return true;
    }

    public boolean isExistVertex(String vertexName) {
        return vertices.stream().filter(v -> v.getName().equals(vertexName)).count() > 0;
    }

    public boolean addEdge(String startVertex, String endVertex){
        return addEdge(startVertex,endVertex,0.0);
    }
    public boolean addEdge(String startVertex, String endVertex, Double weight){
        if (!isExistVertex(startVertex)){
            System.out.println("Vertex \""+startVertex+"\" not exist.");
            return false;
        }
        if (!isExistVertex(endVertex)){
            System.out.println("Vertex \""+endVertex+"\" not exist.");
            return false;
        }
        if(startVertex.equals(endVertex)){
            System.out.println("Self-loops cannot be created yet. :(");
            return false;
        }
        Vertex start=vertices.stream().filter(v->v.getName().equals(startVertex)).findAny().orElseThrow(RuntimeException::new );
        Vertex end=vertices.stream().filter(v->v.getName().equals(endVertex)).findAny().orElseThrow(RuntimeException::new );
        Edge edge=new Edge(start,end,weight);
        edges.add(edge);
        start.addEdge(edge);
        end.addEdge(edge);
        return true;
    }

    public List<Vertex> getAdjVertex(String nameVertex){
        if (!isExistVertex(nameVertex)){
            System.out.println("Vertex \""+nameVertex+"\" not exist.");
            return null;
        }
        List<Vertex> adjacentVertices=new ArrayList<>();
        Vertex vertex=vertices.stream().filter(v->v.getName().equals(nameVertex)).findAny().orElseThrow(RuntimeException::new );
        for(Edge e: vertex.getEdges()){
            if(e.getStart()==vertex){
                adjacentVertices.add(e.getEnd());
            }else{
                adjacentVertices.add(e.getStart());
            }
        }
        return adjacentVertices;
    }

    public void show(){
        for(Vertex v: vertices){
            System.out.println(v.getName()+":");
            System.out.print("\t[\n");
            List<Edge> edges=v.getEdges();
            for (Edge e:edges){
                System.out.print("\t"+e.getWeight()+": ");
                if(e.getStart()==v){
                    System.out.print("to "+e.getEnd().getName());
                }else{
                    System.out.print("from "+e.getStart().getName());
                }
                System.out.println();
            }

            System.out.println("\t]");

        }
    }
}
