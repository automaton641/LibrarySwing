package automaton641.lib;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import automaton641.lib.LibContainer.Flow;

public class LibWindow {
    private JFrame frame;
    private LibCanvas canvas = new LibCanvas();
    private LibWindowComponentAdapter componentAdapter = new LibWindowComponentAdapter(this);
    public LibWindow(String title) {
    	buildFromTitle(title);
    }
    public LibWindow(String title, Flow flow) {
        setFlow(flow);
    	buildFromTitle(title);
    }

    private void buildFromTitle(String title) {
    	frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        //Terminal.printLine("Canvas size: " + canvas.getWidth() + ", " + canvas.getHeight());
        frame.add(canvas);
        frame.addComponentListener(componentAdapter);
    }
	public void show() {
        frame.setVisible(true);
        //Terminal.printLine("Canvas size: " + canvas.getWidth() + ", " + canvas.getHeight());
    }
    LibCanvas getCanvas() {
        return canvas;
    }
    public void setFlow(LibContainer.Flow flow) {
        canvas.getContainer().setFlow(flow);
    }
    public LibContainer addContainer(Flow flow, double growRatio) {
        return canvas.getContainer().addContainer(flow, growRatio);
    }
	public LibContainer addContainer(Flow flow) {
        return canvas.getContainer().addContainer(flow);
	}
	public LibImageViewer addImageViewer(int width, int height, double growRatio) {
		return canvas.getContainer().addImageViewer(width, height, growRatio);
	}
	public void draw() {
		canvas.repaint();
	}
    public LibTextComponent addTextComponent(String[] lines, double growRatio) {
        return canvas.getContainer().addTextComponent(lines, growRatio);
    }
    public LibTextComponent addTextComponent(String[] lines) {
        return addTextComponent(lines, 1.0);
    }
	public LibImageViewer addImageViewer(int width, int height) {
		return canvas.getContainer().addImageViewer(width, height);
	}
}
