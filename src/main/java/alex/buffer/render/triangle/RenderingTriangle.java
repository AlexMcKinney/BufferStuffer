package alex.buffer.render.triangle;

import java.nio.DoubleBuffer;

import alex.buffer.render.Color;
import alex.buffer.render.RenderableVertex;

public abstract class RenderingTriangle implements TriangleInterface{
	
	public void setOpacity(double d){
		Color c1 = this.getFirstColor();
		Color c2 = this.getSecondColor();
		Color c3 = this.getThirdColor();
		
		c1.o = d;
		c2.o = d;
		c3.o = d;
	}
	
	public double[] getVerticesArray3(){
		RenderableVertex v1 = this.getFirstVertex();
		RenderableVertex v2 = this.getSecondVertex();
		RenderableVertex v3 = this.getThirdVertex();
		return new double[]{v1.x, v1.y, v1.z, v2.x, v2.y, v2.z, v3.x, v3.y, v3.z};
	}
	
	public double[] getVerticesArray4(){
		RenderableVertex v1 = this.getFirstVertex();
		RenderableVertex v2 = this.getSecondVertex();
		RenderableVertex v3 = this.getThirdVertex();
		return new double[]{v1.x, v1.y, v1.z, v1.a, v2.x, v2.y, v2.z, v2.a, v3.x, v3.y, v3.z, v3.a};
	}

	public double[] getColorsArray3(){
		Color c1 = this.getFirstColor();
		Color c2 = this.getSecondColor();
		Color c3 = this.getThirdColor();		
		return new double[]{c1.r, c1.g, c1.b, c2.r, c2.g, c2.b, c3.r, c3.g, c3.b};
	}
	
	public double[] getColorsArray4(){
		Color c1 = this.getFirstColor();
		Color c2 = this.getSecondColor();
		Color c3 = this.getThirdColor();
		return new double[]{c1.r, c1.g, c1.b, c1.o, c2.r, c2.g, c2.b, c2.o, c3.r, c3.g, c3.b, c3.o};
	}
	
	
	
	
	
	
	public void pushVerticesArray3(DoubleBuffer buffer){
		RenderableVertex v1 = this.getFirstVertex();
		RenderableVertex v2 = this.getSecondVertex();
		RenderableVertex v3 = this.getThirdVertex();
		
		buffer.put(v1.x);
		buffer.put(v1.y);
		buffer.put(v1.z);
		buffer.put(v2.x);
		buffer.put(v2.y);
		buffer.put(v2.z);
		buffer.put(v3.x);
		buffer.put(v3.y);
		buffer.put(v3.z);
	}
	
	public void pushVerticesArray4(DoubleBuffer buffer){
		RenderableVertex v1 = this.getFirstVertex();
		RenderableVertex v2 = this.getSecondVertex();
		RenderableVertex v3 = this.getThirdVertex();
		
		buffer.put(v1.x);
		buffer.put(v1.y);
		buffer.put(v1.z);
		buffer.put(v1.a);
		buffer.put(v2.x);
		buffer.put(v2.y);
		buffer.put(v2.z);
		buffer.put(v2.a);
		buffer.put(v3.x);
		buffer.put(v3.y);
		buffer.put(v3.z);
		buffer.put(v3.a);
	}

	public void pushColorsArray3(DoubleBuffer buffer){
		Color c1 = this.getFirstColor();
		Color c2 = this.getSecondColor();
		Color c3 = this.getThirdColor();
		
		buffer.put(c1.r);
		buffer.put(c1.g);
		buffer.put(c1.b);
		buffer.put(c2.r);
		buffer.put(c2.g);
		buffer.put(c2.b);
		buffer.put(c3.r);
		buffer.put(c3.g);
		buffer.put(c3.b);
	}
	
	public void pushColorsArray4(DoubleBuffer buffer){
		Color c1 = this.getFirstColor();
		Color c2 = this.getSecondColor();
		Color c3 = this.getThirdColor();
		
		buffer.put(c1.r);
		buffer.put(c1.g);
		buffer.put(c1.b);
		buffer.put(c1.o);
		buffer.put(c2.r);
		buffer.put(c2.g);
		buffer.put(c2.b);
		buffer.put(c2.o);
		buffer.put(c3.r);
		buffer.put(c3.g);
		buffer.put(c3.b);
		buffer.put(c3.o);
	}
}
