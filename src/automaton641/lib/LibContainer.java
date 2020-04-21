package automaton641.lib;

import java.util.ArrayList;
import java.awt.Graphics;


public class LibContainer extends LibVisual {
    public enum Flow {
        Horizontal,
        Vertical
    }
    private double growAdder = 0.0;
    private ArrayList<LibVisual> visuals = new ArrayList<LibVisual>();
    private Flow flow = Flow.Horizontal;
    public LibContainer(LibCanvas canvas, LibTheme theme, double growRatio) {
        super(canvas, theme, growRatio);
    }
    public void event(LibEvent event) {
        super.event(event);
        for (LibVisual visual : visuals) {
            visual.event(event);
        }
    }
    public void setFlow(Flow flow) {
        this.flow = flow;
    }
    public Flow getFlow() {
        return flow;
    }
    @Override
    public void revalidate(LibSize size, LibPosition position) {
        arrange(size, position);
        canvas.repaint();
    }
    public void arrange(LibSize size, LibPosition position) {
    	super.revalidate(size, position);
        LibPosition newPosition = this.position.addMBP(margin, border, padding);
        LibSize previousSize = new LibSize(0, 0);
        LibSize newSize = this.size.removeMBP(margin, border, padding);
        for (LibVisual visual : visuals) {
        	visual.proportion =  visual.growRatio / growAdder;
        	//LibTerminal.printLine("visual.proportion: " + visual.proportion);
            if (flow == Flow.Horizontal) {
            	newPosition = newPosition.addHorizontal(previousSize.getWidth());
                visual.revalidate(newSize.proportionHorizontal(visual.proportion), newPosition);
            } else {
            	newPosition = newPosition.addVertical(previousSize.getHeight());
                visual.revalidate(newSize.proportionVertical(visual.proportion), newPosition);
            }
            visual.calculateAvailableSize();
            previousSize = visual.size;
        }
    }
    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        for (LibVisual visual : visuals) {
            visual.draw(graphics);
        }
    }
    public LibContainer addContainer(Flow flow, double growRatio) {
        LibContainer container = new LibContainer(canvas, theme, growRatio);
        container.setFlow(flow);
        addVisual(container);
        return container;
    }
	public LibContainer addContainer(Flow flow) {
		return addContainer(flow, 1);
	}
	public void addVisual(LibVisual visual) {
    	growAdder += visual.growRatio;
		this.visuals.add(visual);
        revalidate(size, position);
	}
	public LibImageViewer addImageViewer(int width, int height, double growRatio) {
		LibImageViewer imageViewer = new LibImageViewer(canvas, theme, growRatio, width, height);
		addVisual(imageViewer);
		return imageViewer;
	}
	public LibImageViewer addImageViewer(int width, int height) {
		return addImageViewer(width, height, 1);
	}
    public LibTextComponent addTextComponent(String[] lines, double growRatio) {
        LibTextComponent textComponent = new LibTextComponent(canvas, theme, growRatio, lines);
        addVisual(textComponent);
        return textComponent;
    }
}
