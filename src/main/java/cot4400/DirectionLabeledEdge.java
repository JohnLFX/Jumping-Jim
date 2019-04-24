package cot4400;

import org.jgrapht.graph.DefaultEdge;

public class DirectionLabeledEdge extends DefaultEdge {

    private Direction direction;

    public DirectionLabeledEdge(){}

    public DirectionLabeledEdge(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "(" + getSource() + " : " + getTarget() + " : " + direction + ")";
    }

}
