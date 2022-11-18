package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private final List<Edge> edges;
    private Double weight;
    private int data;

    public Vertex(String name) {
        this.name=name;
        edges = new ArrayList<>();
    }

    public Vertex(String name, Double weight) {
        this(name);
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}