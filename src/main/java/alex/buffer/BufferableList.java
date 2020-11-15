package alex.buffer;

import java.util.ArrayList;
import java.util.List;

import alex.buffer.render.triangle.RenderingTriangle;

@SuppressWarnings("serial")
public class BufferableList extends ArrayList<Bufferable> implements Bufferable{

	public BufferableList(){
		super();
	}

	@Override
	public List<RenderingTriangle> getRenderingTriangles() {
		List<RenderingTriangle> tris = new ArrayList<RenderingTriangle>();
		for(Bufferable buff : this){
			tris.addAll(buff.getRenderingTriangles());
		}
		return tris;
	}

}
