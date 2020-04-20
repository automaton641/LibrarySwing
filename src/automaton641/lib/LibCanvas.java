package automaton641.lib;

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.Graphics2D;

public class LibCanvas extends JComponent {
    private FontMetrics metrics;
    private LibPosition position = new LibPosition(0.0, 0.0);
    private LibTheme theme = new LibTheme();
    private LibContainer container = new LibContainer(this, theme, 1.0);
    private LibCanvasComponentAdapter componentAdapter = new LibCanvasComponentAdapter();
    private LibMouseAdapter mouseAdapter = new LibMouseAdapter();
    public LibCanvas() {
        addComponentListener(componentAdapter);
        addMouseListener(mouseAdapter);
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setAntialiasing(graphics);
        clear(graphics);
        draw(graphics);
    }

    private void setAntialiasing(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
    }

    public LibContainer getContainer() {
        return container;
    }

    private void draw(Graphics graphics) {
        //drawString(graphics, "HELLO PIXEL, HOLA JOSÉ MANUEL MARTÍNEZ QUEVEDO", 0, 0);
        drawContainer(graphics);
    }

    private void drawContainer(Graphics graphics) {
        container.draw(graphics);
    }

    void resized() {
        //Terminal.printLine(canvas.getPixelSize());
        container.revalidate(getPixelSize(), position);
    }

    public void drawString(Graphics graphics, String string, int x, int y) {
        graphics.setColor(theme.getForeGroundColor());
        graphics.setFont(theme.getFont());
        metrics = graphics.getFontMetrics(theme.getFont());
        int height = metrics.getHeight();
        //int width = metrics.stringWidth(string);
        graphics.drawString(string, x, height);
    }

    private void clear(Graphics graphics) {
        graphics.setColor(theme.getBackGroundColor());
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    public LibSize getPixelSize() {
        return new LibSize(getWidth(), getHeight());
    }
}
