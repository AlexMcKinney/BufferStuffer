package alex.buffer.render;

public class Color implements Comparable<Color>{
	
	public static final Color RED = new Color(1.0, 0.0, 0.0);
	public static final Color ORANGE = new Color(1.0, 0.66, 0.0);
	public static final Color YELLOW = new Color(1.0, 1.0, 0.0);
	public static final Color GREEN = new Color(0.0, 1.0, 0.0);
	public static final Color BLUE = new Color(0.0, 0.0, 1.0);
	public static final Color PURPLE = new Color(1.0, 0.0, 1.0);
	public static final Color CYAN = new Color(0.0, 1.0, 1.0);
	public static final Color WHITE = new Color(1.0, 1.0, 1.0);
	public static final Color BLACK = new Color(0.0, 0.0, 0.0);
	public static final Color BROWN = new Color(0.66, 0.33, 0.0);

    //public static final Color[] colors6 = new Color[]{BLUE, RED, CYAN, GREEN, PURPLE, YELLOW};
	public static final Color[] colors6 = new Color[]{RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE};
    
	//red/green/blue
    public double r, g, b;
    //opacity
    public double o = 1.0;
    
    
    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Color add(Color c){
    	return new Color(this.r + c.r, this.g + c.g, this.b + c.b);
    }
    
    public Color mult(double d){
    	return new Color(this.r*d, this.g*d, this.b*d);
    }
    
    public Color clone(){
        return new Color(this.r, this.g, this.b);
    }
    
    @Override
    public String toString(){
        return "("+r + ", " + g + ", " + b+")";
    }
    
    @Override
    public boolean equals(Object obj){
    	if(obj instanceof Color){
    		return (this.compareTo((Color) obj) == 0);
    	}
    	return false;
    }

    @Override
    public int compareTo(Color arg0) {
        double limit = 0.000000001;
        if(Math.abs(this.r - arg0.r) > limit){
            return Double.compare(this.r,  arg0.r);
        }
        if(Math.abs(this.g - arg0.g) > limit){
            return Double.compare(this.g,  arg0.g);
        }
        return Double.compare(this.b,  arg0.b);
    }
    
    public static Color[] makeSpectrum(Color base, double... mults){
    	Color[] colors = new Color[mults.length];
    	for(int i=0; i < mults.length; i++){
    		colors[i] = base.mult(mults[i]);
    	}    	
    	return colors;
    }
    
    public static Color random(){
    	return new Color(Math.random(), Math.random(), Math.random());
    }
}