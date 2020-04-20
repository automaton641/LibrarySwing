package automaton641.lib;

import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class LibTheme {
    private int blackRGB = 0x000000;
    private int whiteRGB = 0xffffff;
    private Color backGroundColor = new Color(blackRGB);
    private Color foreGroundColor = new Color(whiteRGB);
    private Font baseFont;
    private Font font;
    private FontMetrics metrics;
    public LibTheme() {
        InputStream fontInputStream = getClass().getResourceAsStream("/fonts/JetBrainsMono-1.0.3/ttf/JetBrainsMono-ExtraBold.ttf");
        try {
            baseFont = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
        } catch(Exception exception) {
            exception.printStackTrace();
            System.exit(0);
        }
        font = baseFont.deriveFont(16.0f);
    }
    public Font getFont() {
        return font;
    }
    public Color getBackGroundColor() {
        return backGroundColor;
    }
    public Color getForeGroundColor() {
        return foreGroundColor;
    }
}
