package company;

public class Plot {

    private int x;
    private int y;
    private int width;
    private int length;

    public Plot() {
        this.x=0;
        this.y=0;
        this.width=1;
        this.length=1;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.length = otherPlot.length;
    }

    public Plot(int x, int y, int width, int length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public boolean overlaps(Plot otherPlot){

        if(this.x==otherPlot.x && this.y== otherPlot.y && this.length==otherPlot.length &&
                this.width==otherPlot.length) return true;

        return false;
    }

    public boolean encompasses(Plot otherPlot){

        if(this.x> otherPlot.x || this.y> otherPlot.y) return false;

        if((otherPlot.x+ otherPlot.length) > (this.x+ this.length) ||
                (otherPlot.y + otherPlot.width) >(this.y +this.width)) return false;

        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
