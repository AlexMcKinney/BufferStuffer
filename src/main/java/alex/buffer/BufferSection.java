package alex.buffer;

import java.nio.DoubleBuffer;
import java.util.List;

import alex.buffer.render.triangle.RenderingTriangle;

public class BufferSection {
	private static final double[] EMPTY3 = new double[]{0,0,0,  0,0,0,  0,0,0};
	private static final double[] EMPTY4 = new double[]{0,0,0,0,  0,0,0,0,  0,0,0,0};
	
	
	private Bufferable object;
	private int vertexOffset = 0, colorOffset=0;
	private boolean visible = true;
	
	public BufferSection(Bufferable object, int vertexOffset, int colorOffset) {
		this.object = object;
		this.vertexOffset = vertexOffset;
		this.colorOffset = colorOffset;
	}

	public void update(DoubleBuffer vertices, DoubleBuffer colors){
		vertices.position(this.vertexOffset);
		colors.position(this.colorOffset);
		
		List<RenderingTriangle> list = this.object.getRenderingTriangles();
		for(RenderingTriangle tri : list){
			if(this.visible){
				tri.pushVerticesArray3(vertices);
				tri.pushColorsArray4(colors);
			}
			else{
				vertices.put(EMPTY3);
				colors.put(EMPTY4);
			}
		}
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public int getNextVertexIndex(){
		return this.vertexOffset + this.object.getRenderingTriangles().size() * Buffer.POINT_SIZE * Buffer.POINT_SIZE;
	}

	public int getNextColorIndex(){
		return this.colorOffset + this.object.getRenderingTriangles().size() * Buffer.POINT_SIZE * Buffer.COLOR_SIZE;
	}
}
