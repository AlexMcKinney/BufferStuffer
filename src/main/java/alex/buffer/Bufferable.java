package alex.buffer;

import java.util.List;

import alex.buffer.render.triangle.RenderingTriangle;

public interface Bufferable {
	
	public List<RenderingTriangle> getRenderingTriangles();
}
