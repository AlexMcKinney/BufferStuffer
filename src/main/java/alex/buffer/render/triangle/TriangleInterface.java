package alex.buffer.render.triangle;

import alex.buffer.render.Color;
import alex.buffer.render.RenderableVertex;

public interface TriangleInterface {
	public RenderableVertex getFirstVertex();
	public RenderableVertex getSecondVertex();
	public RenderableVertex getThirdVertex();
	
	public Color getFirstColor();
	public Color getSecondColor();
	public Color getThirdColor();
	
	public void setColor(Color color);
}
