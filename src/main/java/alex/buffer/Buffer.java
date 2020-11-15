package alex.buffer;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.media.opengl.GL2;

import com.jogamp.common.nio.Buffers;

public class Buffer {
	public static final int POINT_SIZE = 3;
	public static final int COLOR_SIZE = 4;
	
	private List<BufferSection> sections = new ArrayList<BufferSection>();
	private DoubleBuffer vertexBuffer, colorBuffer;
	
	private int pointCount = 0;
	
	private Map<Bufferable, BufferSection> map = new HashMap<Bufferable, BufferSection>();
	
	
	public Buffer(int capacity){
		this.vertexBuffer = Buffers.newDirectDoubleBuffer(POINT_SIZE*capacity);
		this.colorBuffer = Buffers.newDirectDoubleBuffer(COLOR_SIZE*capacity);
		//System.out.println("created Buffer");
	}
	
	public boolean willFit(Bufferable object){
		return (vertexBuffer.capacity() > (this.pointCount + object.getRenderingTriangles().size()*POINT_SIZE)*POINT_SIZE);
	}
	
	public void add(Bufferable buff){
		BufferSection bs;
		this.pointCount += buff.getRenderingTriangles().size()*POINT_SIZE;
		if(this.sections.isEmpty()){
			bs = new BufferSection(buff, 0, 0);
		}
		else{
			BufferSection last = this.sections.get(this.sections.size()-1);
			bs = new BufferSection(buff, last.getNextVertexIndex(), last.getNextColorIndex());
		}
		this.sections.add(bs);
		this.map.put(buff, bs);
		bs.update(this.vertexBuffer, this.colorBuffer);
	}
	
	public boolean has(Bufferable object){
		return (this.map.get(object) != null);
	}
	
	public void update(Bufferable buff){
		BufferSection bs = this.map.get(buff);
		if(bs == null){
			return;
		}
		bs.update(this.vertexBuffer, this.colorBuffer);
	}
	
	public void update(){
		for(BufferSection bs : this.map.values()){
			bs.update(this.vertexBuffer, this.colorBuffer);
		}
	}
	
	public void setVisible(Bufferable buff, boolean visible){
		BufferSection bs = this.map.get(buff);
		if(bs == null){
			return;
		}
		bs.setVisible(visible);
		bs.update(this.vertexBuffer, this.colorBuffer);
	}
	
	public boolean isVisible(Bufferable obj){
		BufferSection bs = this.map.get(obj);
		if(bs == null){
			return false;
		}
		return bs.isVisible();
	}
	
	public void render(GL2 gl){
		this.vertexBuffer.rewind();
		this.colorBuffer.rewind();
		this.drawArrays(gl);
	}
		
	private void drawArrays(GL2 gl){
        gl.glVertexPointer(POINT_SIZE, GL2.GL_DOUBLE, 0, vertexBuffer);
        gl.glColorPointer(COLOR_SIZE, GL2.GL_DOUBLE, 0, colorBuffer);
        gl.glDrawArrays(GL2.GL_TRIANGLES, 0, this.pointCount );
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < this.pointCount*POINT_SIZE; i++){
			sb.append(this.vertexBuffer.get(i)).append(" ");
		}
		sb.append("\n");
		for(int i=0; i < this.pointCount*COLOR_SIZE; i++){
			sb.append(this.colorBuffer.get(i)).append(" ");
		}
		return sb.toString();
	}
}
