
public class XYZ {
	double X;
	double Y;
	double Z;
	
	public XYZ(double x, double y, double z){
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	public void setX(double x){
		this.X = x;
	}
	
	public void setY(double y){
		this.Y = y;
	}
	
	public void setZ(double z){
		this.Z = z;
	}
	
	public double getX(XYZ point){
		return point.X;
	}
	
	public double getY(XYZ point){
		return point.Y;
	}
	
	public double getZ(XYZ point){
		return point.Z;
	}
	
	public void printXYZ(){
		System.out.println("(" + this.X + ", " + this.Y + ", " + this.Z + ")");
	}
}
