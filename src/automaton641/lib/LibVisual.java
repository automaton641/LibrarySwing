package automaton641.lib;

import java.awt.Color;
import java.awt.Graphics;

public class LibVisual {
	protected static int count = 0;
    protected LibContainer container = null;
    protected LibTheme theme = null;
    protected LibCanvas canvas = null;
    protected double padding = 8.0;
    protected double border = 8.0;
    protected double margin = 8.0;
    protected double proportion = 1.0;
    protected double growRatio = 1.0;
    protected int id = 0;
    protected LibSize size = new LibSize(0.0, 0.0);
    protected LibSize availableSize = new LibSize(0.0, 0.0);
    protected LibPosition position = new LibPosition(0.0, 0.0);
    public LibVisual(LibCanvas canvas, LibTheme theme, double growRatio) {
    	id = count;
    	count++;
    	this.canvas = canvas;
        this.theme = theme;
        this.growRatio = growRatio;
    }

    public void revalidate(LibSize size, LibPosition position) {
        this.size = size;
        this.position = position;
    }
    public void drawMargin(Graphics graphics) {
        graphics.setColor(theme.getBackGroundColor());
        graphics.fillRect((int)(margin+border+position.getX()), (int)(margin+border+position.getY()), (int)(size.getWidth()-(margin+border)*2.0), (int)(size.getHeight()-(margin+border)*2.0));
    }
    public void drawBorder(Graphics graphics) {
    	Color color = theme.getForeGroundColor();
    	int x = (int)(margin+position.getX());
    	int y = (int)(margin+position.getY());
    	int width = (int)(size.getWidth()-margin*2.0);
    	int height = (int)(size.getHeight()-margin*2.0);
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
    }
    public void draw(Graphics graphics) {
        drawBorder(graphics);
        drawMargin(graphics);
    }

	public void calculateAvailableSize() {
		availableSize = size.removeMBP(margin, border, padding);

	}
}
