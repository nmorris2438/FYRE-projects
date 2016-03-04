/* defines the Vector Object
 * Includes methods for creating vectors, finding midpoint vectors, 
 * cross product, dot product, magnitude, and angle between two angles
 */
public class Vector {
	double X;
	double Y;
	double Z;
	
	public Vector(double x, double y, double z){ //Vector constructor
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
	
	public void printVector(){
		System.out.println("(" + this.X + ", " + this.Y + ", " + this.Z + ")");
	}
	
	public static Vector VectorFromPoints(XYZ pointA, XYZ pointB){ //forms a vector from two points
		double x = pointA.X - pointB.X;
		double y = pointA.Y - pointB.Y;
		double z = pointA.Z - pointB.Z;
		
		Vector vector = new Vector(x, y, z);
		return vector;
	}
	
	public static Vector MidpointVector(XYZ pointA, XYZ pointB){ //creates vector to midpoint of two points
		double x = (pointA.X + pointB.X) / 2;
		double y = (pointA.Y + pointB.Y) / 2;
		double z = (pointA.Z + pointB.Z) / 2;
		
		Vector vector = new Vector(x, y, z);
		return vector;
	}
	
	public Vector MidVectorXY(){ //projects the midpoint vector onto the xy plane
		double x = this.X;
		double y = this.Y;
		double z = 0;
		
		Vector vector = new Vector(x, y, z);
		return vector;
	}
	
	public static Vector CrossProduct(Vector vector1, Vector vector2){ //takes the cross product of two vectors
		double x = (vector1.Y * vector2.Z) - (vector1.Z * vector2.Y);
		double y = (vector1.Z * vector2.X) - (vector1.X * vector2.Z);
		double z = (vector1.X * vector2.Y) - (vector1.Y * vector2.X);
		
		Vector vector = new Vector(x, y, z);
		return vector;
	}
	
	public static double DotProduct(Vector vector1, Vector vector2){ //takes the dot product of two vectors
		double x = vector1.X * vector2.X;
		double y = vector1.Y * vector2.Y;
		double z = vector1.Z * vector2.Z;
		
		double sum = x + y + z;
		return sum;
	}
	
	public double Magnitude(){ //returns the magnitude of the vector
		double x = this.X * this.X;
		double y = this.Y * this.Y;
		double z = this.Z * this.Z;
		
		double mag = Math.sqrt(x + y + z);
		return mag;
	}
	
	public static double Angle(Vector A, Vector B){ //north vector MUST go first
		double numerator = DotProduct(A, B);
		double denominator = A.Magnitude() * B.Magnitude();
		double fraction = numerator / denominator;
		double angle = Math.acos(fraction);
		
		return angle; 									//angle will be between 0 and pi
	}
	
	public static Vector NorthVector(Vector A, Vector B){
		Vector northOrSouth = CrossProduct(A, B);
		if(northOrSouth.Z > 0){
			return northOrSouth;
		}
		else {
			northOrSouth.X = -northOrSouth.X;
			northOrSouth.Y = -northOrSouth.Y;
			northOrSouth.Z = -northOrSouth.Z;
			return northOrSouth;
		}	
	}
	
}
