package alex.buffer;

import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

public class BufferMaster {

	private int baseCapacity;
	private List<Buffer> buffers = new ArrayList<Buffer>();
	
	
	public BufferMaster(int baseCapacity){
		this.baseCapacity = baseCapacity;
		this.addBuffer();
	}
	
	private void addBuffer(){
		//System.out.println("BufferMaster::addBuffer("+this.baseCapacity+") to "+this.buffers.size()+" buffers");
		this.buffers.add(new Buffer(this.baseCapacity));
	}
	
	public Buffer getCurrentBuffer(){
		return this.buffers.get(this.buffers.size()-1);
	}
	
	public List<Buffer> getBuffers(){
		return this.buffers;
	}
	
	public void add(Bufferable object){
		if(this.getCurrentBuffer().willFit(object) == false){
			this.addBuffer();
		}
		try{
			this.getCurrentBuffer().add(object);
		}
		catch(BufferOverflowException ex){
			System.out.println("ERROR BufferMaster::add() too many triangles? "+object.getRenderingTriangles().size());
		}
	}
	
	public boolean has(Bufferable object){
		for(Buffer buff : this.buffers){
			if(buff.has(object)){
				return true;
			}
		}		
		return false;
	}
	
	public void update(Bufferable object){
		for(Buffer buff : this.buffers){
			buff.update(object);
		}
	}
	
	public void update(){
		for(Buffer buff : this.buffers){
			buff.update();
		}		
	}
	
	public void setVisible(Bufferable object, boolean visible){
		for(Buffer buff : this.buffers){
			buff.setVisible(object, visible);
		}
	}
	
	public boolean isVisible(Bufferable obj){
		boolean b = false;
		for(Buffer buff : this.buffers){
			b = b || buff.isVisible(obj);
		}
		return b;
	}
	
	public void render(GL2 gl){
        gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL2.GL_COLOR_ARRAY);
		for(Buffer buff : this.buffers){
			buff.render(gl);
		}
        gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL2.GL_COLOR_ARRAY);        
	}
}
