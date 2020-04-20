package automaton641.lib;

import java.awt.Graphics;

public class LibImageViewer extends LibComponent {
	private LibImage image;
	private int pixelSize = 4;
	public LibImageViewer(LibCanvas canvas, LibTheme theme, double growRatio, LibImage image) {
		super(canvas, theme, growRatio);
		this.image = image;
	}
	public LibImageViewer(LibCanvas canvas, LibTheme theme, double growRatio, int width, int height) {
		super(canvas, theme, growRatio);
		image = new LibImage(width, height);
	}
	
	@Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        LibPosition position = this.position.addMBP(margin, border, padding);
        position = position.center(availableSize, image.getSize().scale(pixelSize));
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
            	graphics.setColor(image.getColor(x, y));
            	LibPosition colorPosition = position.add(x*pixelSize, y*pixelSize);
            	graphics.fillRect(colorPosition.getXInteger(), colorPosition.getYInteger(), pixelSize, pixelSize);
            }
		}
    }
	public void setPixelSize(int pixelSize) {
		this.pixelSize = pixelSize;
	}
	public int getImageHeight() {
		return image.getHeight();
	}
	public int getImageWidth() {
		return image.getWidth();
	}
	public void setLibColor(int x, int y, LibColor libColor) {
		image.setLibColor(x, y, libColor);
	}

}
