public class Needle {


    public Needle(double y1,double y2, boolean crossLine) {
        this.y1 = y1;
        this.y2 = y2;
        this.crossLine = crossLine;
    }

    double y1;
    double y2;
    boolean crossLine;

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setCrossLine(boolean crossLine) {
        this.crossLine = crossLine;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public boolean isCrossLine() {
        return crossLine;
    }

}
