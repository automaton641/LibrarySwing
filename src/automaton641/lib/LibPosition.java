package automaton641.lib;

public class LibPosition {
    private double x;
    private double y;
    public LibPosition(int x, int y) {
        setX((double)x);
        setY((double)y);
    }
    public LibPosition(double x, double y) {
        setX(x);
        setY(y);
    }
    @Override
	public String toString() {
		return "x: " + x + " , y: " + y;
	}
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public LibPosition addVertical(double offset) {
        return new LibPosition(x, y+offset);
    }
    public LibPosition addHorizontal(double offset) {
        return new LibPosition(x+offset, y);
    }
    public LibPosition addMBP(double margin, double border, double padding) {
        return new LibPosition(x+margin+border+padding, y+margin+border+padding);
    }
    public LibPosition add(int x, int y) {
        return new LibPosition(this.x+x,this.y+y);
	}
	public void addInPlace(int x, int y) {
		setX(this.x + x);
		setY(this.y + y);
	}
	public int getXInteger() {
		return (int) x;
	}
	
	public int getYInteger() {
		return (int) y;
	}
	public LibPosition center(LibSize availableSize, LibSize size) {
		double x = this.x + availableSize.getWidth()/2.0 - size.getWidth()/2.0;
		double y = this.y + availableSize.getHeight()/2.0 - size.getHeight()/2.0;
		return new LibPosition(x, y);
	}
}
