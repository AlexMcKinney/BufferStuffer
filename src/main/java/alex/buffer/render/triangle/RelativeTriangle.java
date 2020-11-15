package alex.buffer.render.triangle;

import alex.buffer.render.Color;
import alex.buffer.render.RenderableVertex;

public class RelativeTriangle extends RenderingTriangle{
	private TriangleInterface wrapped;
	private VertexTranslator translator;
	
	
	public RelativeTriangle(TriangleInterface wrapped, VertexTranslator translator) {
		super();
		this.wrapped = wrapped;
		this.translator = translator;
	}

	@Override
	public void setColor(Color color) {
		this.wrapped.setColor(color);
	}

	@Override
	public RenderableVertex getFirstVertex() {
		return translator.translate(this.wrapped.getFirstVertex());
	}

	@Override
	public RenderableVertex getSecondVertex() {
		return translator.translate(this.wrapped.getSecondVertex());
	}

	@Override
	public RenderableVertex getThirdVertex() {
		return translator.translate(this.wrapped.getThirdVertex());
	}

	@Override
	public Color getFirstColor() {
		return wrapped.getFirstColor();
	}

	@Override
	public Color getSecondColor() {
		return wrapped.getSecondColor();
	}

	@Override
	public Color getThirdColor() {
		return wrapped.getThirdColor();
	}
}
