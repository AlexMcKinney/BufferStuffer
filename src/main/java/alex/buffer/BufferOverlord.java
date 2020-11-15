package alex.buffer;

import javax.media.opengl.GL2;

/**
 * Contain a pair of BufferMasters, one that is ready to draw and one that is updating
 * This allows JOGL to display() without waiting for buffer updates
 * */
public class BufferOverlord {	
	private BufferMaster[] buffers = new BufferMaster[2];
	private int current = 0;
	private boolean busy = false;
	
	
	public BufferOverlord(int baseCapacity){
		this.buffers[0] = new BufferMaster(baseCapacity);
		this.buffers[1] = new BufferMaster(baseCapacity);
	}
	
	public BufferMaster getRenderingBuffer(){
		return this.buffers[current%2];
	}
	
	public BufferMaster getUpdatingBuffer(){
		return this.buffers[(current+1)%2];
	}
	
	public void add(Bufferable object){
		this.buffers[0].add(object);
		this.buffers[1].add(object);
	}
	
	public void update(){
		if(this.busy == true){
			return;
		}
		new Thread(){
			@Override
			public void run(){
				busy = true;
				getUpdatingBuffer().update();
				current++;
				busy = false;
			}
		}.start();
	}
	
	public void render(GL2 gl){
		this.getRenderingBuffer().render(gl);
	}
}
