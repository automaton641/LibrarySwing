package automaton641.lib;

import java.awt.Color;
import java.util.Random;

public class LibColor {

	private double red;
	private double green;
	private double blue;
	private double alpha;
	private Color color;
	
	public LibColor(double red, double green, double blue, double alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
		color = new Color((float)red, (float)green, (float)blue, (float)alpha);
	}

	public static LibColor random() {
		Random random = new Random();
		return new LibColor(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);
	}

	public Color getColor() {
		return color;
	}

}
