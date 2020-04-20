package automaton641.lib;

public class LibSize {
    private double width;
    private double height;
    public LibSize(int width, int height) {
        this.width = (double)width;
        this.height = (double)height;
    }
    public LibSize(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
	public String toString() {
		return "width: " + width + " , height: " + height;
	}
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public LibSize proportionHorizontal(double proportion) {
        return new LibSize(width*proportion, height);
    }
    public LibSize proportionVertical(double proportion) {
        return new LibSize(width, height*proportion);
    }
    public LibSize removeMBP(double margin, double border, double padding) {
        //Terminal.printLine("width: " + width);
        //Terminal.printLine("height: " + height);
        return new LibSize(width-2.0*(margin+border+padding), height-2.0*(margin+border+padding));
    }
	public LibSize scale(int proportion) {
        return new LibSize(width*proportion, height*proportion);
	}
}
