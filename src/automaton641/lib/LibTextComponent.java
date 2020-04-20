package automaton641.lib;

import java.awt.FontMetrics;
import java.awt.Graphics;

public class LibTextComponent extends LibComponent {
    private String[] lines;
    public LibTextComponent(LibCanvas canvas, LibTheme theme, double growRatio, String[] lines) {
    	super(canvas, theme, growRatio);
        this.lines = lines;
    }
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        LibPosition position = this.position.addMBP(margin, border, padding);
        graphics.setFont(theme.getFont());
        FontMetrics metrics = graphics.getFontMetrics();
        int height = metrics.getHeight();
        position = position.center(availableSize, new LibSize(0, height*lines.length));
        graphics.setColor(theme.getForeGroundColor());
        int n = 1;
        for (String line : lines) {
            int width = metrics.stringWidth(line);
            graphics.drawString(line, position.getXInteger() - width/2, height*n + position.getYInteger());
            n++;
        }
    }

}
