package alex.buffer.render.triangle;

import alex.buffer.render.RenderableVertex;

/**
 * Used for RelativeTriangle
 * */
public abstract class VertexTranslator {
	public abstract RenderableVertex translate(RenderableVertex vertex);
}
