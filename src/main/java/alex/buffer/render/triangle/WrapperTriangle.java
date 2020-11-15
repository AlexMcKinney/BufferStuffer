package alex.buffer.render.triangle;

import alex.buffer.render.Color;
import alex.buffer.render.RenderableVertex;

public class WrapperTriangle extends RenderingTriangle{
	private TriangleInterface inter;
	
	
	public WrapperTriangle(TriangleInterface inter){
		this.inter = inter;
	}
	
	@Override
	public RenderableVertex getFirstVertex() {
		return inter.getFirstVertex(); 
	}

	@Override
	public RenderableVertex getSecondVertex() {
		return inter.getSecondVertex();
	}

	@Override
	public RenderableVertex getThirdVertex() {
		return inter.getThirdVertex();
	}

	@Override
	public Color getFirstColor() {
		return inter.getFirstColor();
	}

	@Override
	public Color getSecondColor() {
		return inter.getSecondColor();
	}

	@Override
	public Color getThirdColor() {
		return inter.getThirdColor();
	}

	@Override
	public void setColor(Color color) {
		this.inter.setColor(color);
	}
	
	
}
