package alex.buffer.render;

import javax.media.opengl.glu.GLU;

/**
 * Represents a movable camera, mostly for controlling the WebGL lookAt() and perspective() functions
 * */
public abstract class RenderingCamera {
	protected double near = 0.01, far = 100.0, radius = 4.0;

	//adjust GLU based on private class values
	public void runLookAt(GLU glu){
		RenderableVertex eye = this.getRenderingEye();
		RenderableVertex aim = this.getRenderingAim();
		RenderableVertex up = this.getRenderingUp();
		glu.gluLookAt(eye.x, eye.y, eye.z, aim.x, aim.y, aim.z, up.x, up.y, up.z);
	}
	
	public void runPerspective(GLU glu){
		glu.gluPerspective(45, 1, near, far);
	}
	
	//increase/decrease NEAR and FAR
	public void zoom(double factor){
		this.near *= factor;
		this.far *= factor;
	}
	
	public void multiplyRadius(double factor){
		this.radius *= factor;
	}
	
	protected abstract RenderableVertex getRenderingEye();

	protected abstract RenderableVertex getRenderingAim();
	
	protected abstract RenderableVertex getRenderingUp();
	
	public void setFar(double far){
		this.far = far;
	}
	
	public double getNear(){
		return this.near;
	}
	
	public double getFar(){
		return this.far;
	}
}
