package cot4400;

import java.util.Objects;

public class JumpNode {

    private int i, j;
    private int spaces;

    public JumpNode(int i, int j, int spaces) {
        this.i = i;
        this.j = j;
        this.spaces = spaces;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JumpNode jumpNode = (JumpNode) o;
        return i == jumpNode.i &&
                j == jumpNode.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString(){
        return spaces + " (" + i + ", " + j + ")";
    }

}
