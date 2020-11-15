package alex.buffer.render.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alex.buffer.render.Color;
import alex.buffer.render.RenderableVertex;

public class AbsoluteTriangle extends RenderingTriangle{
	
	private RenderableVertex v1, v2, v3;
	private Color c1, c2, c3;

	
	public AbsoluteTriangle(AbsoluteTriangle tri){
		this.v1 = tri.v1.clone();
		this.v2 = tri.v2.clone();
		this.v3 = tri.v3.clone();
		
		this.c1 = tri.c1.clone();
		this.c2 = tri.c2.clone();
		this.c3 = tri.c3.clone();		
	}
	
	public AbsoluteTriangle(RenderableVertex v1, RenderableVertex v2, RenderableVertex v3, Color color) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		
		this.c1 = color;
		this.c2 = color;
		this.c3 = color;
	}
	
	public void setVertice(RenderableVertex v1, RenderableVertex v2, RenderableVertex v3){
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public AbsoluteTriangle clone(){
		return new AbsoluteTriangle(this);
	}
	
	public List<RenderableVertex> getVertices(){
		return new ArrayList<RenderableVertex>(Arrays.asList(v1, v2, v3));
	}
	
	public List<Color> getColors(){
		return new ArrayList<Color>(Arrays.asList(c1, c2, c3));
	}
	
	@Override
	public void setColor(Color color){
		this.c1 = color;
		this.c2 = color;
		this.c3 = color;
	}
	
	@Override
	public String toString(){
		return "WebGLTriangle: "+v1+""+v2+""+v3;
	}

	@Override
	public RenderableVertex getFirstVertex() {
		return this.v1;
	}

	@Override
	public RenderableVertex getSecondVertex() {
		return this.v2;
	}

	@Override
	public RenderableVertex getThirdVertex() {
		return this.v3;
	}

	@Override
	public Color getFirstColor() {
		return this.c1;
	}

	@Override
	public Color getSecondColor() {
		return this.c2;
	}

	@Override
	public Color getThirdColor() {
		return this.c3;
	}
}
