package automaton641.lib;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class LibImage {
	private int width;
	private int height;
	private LibColor[][] colors = null;
	public LibImage(int width, int height) {
		this.width = width;
		this.height = height;
		colors = new LibColor[width][height];
		for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
            	colors[x][y] = new LibColor(0.0, 0.0, 0.0, 1.0);
            }
		}
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getColor(int x, int y) {
		return colors[x][y].getColor();
	}
	public void setLibColor(int x, int y, LibColor libColor) {
		colors[x][y] = libColor;
	}
	public LibSize getSize() {
		return new LibSize(width, height);
	}
}
