package graph;

public class EdgeModel {
    private VertexModel start;
    private VertexModel finish;
    private int weight;

    public EdgeModel(VertexModel start,VertexModel finish){
        setStart(start);
        setFinish(finish);
        setWeight(1);
    }

    public VertexModel getStart() {
        return start;
    }

    public void setStart(VertexModel start) {
        this.start = start;
    }

    public VertexModel getFinish() {
        return finish;
    }

    public void setFinish(VertexModel finish) {
        this.finish = finish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
