package alex.buffer.render;

public class RenderableVertex {
	public double x, y, z ,a;
	
	
	public RenderableVertex(double x, double y, double z, double a) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}
	
	public RenderableVertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = 0;
	}
	
	public RenderableVertex(RenderableVertex v){
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
		this.a = v.a;
	}
	
	public RenderableVertex clone(){
		return new RenderableVertex(this);
	}
}
