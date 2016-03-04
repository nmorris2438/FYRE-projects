
public class GPStoAngle {
	public static double trueAngle(double angle, GPS A, GPS D){ //assumes western hemisphere
		if(D.getLong() > A.getLong()){							//if eastern hemisphere, switch to "<"
			angle = 360 - angle;
		}
		return angle;
	}
	
	public static void main(String[] args){
		//input the two GPS coordinates
		GPS ArrayGPS = new GPS(35.200371, -97.444641); //couch center
		GPS DroneGPS = new GPS(35.214150, -97.478953); //test
		
		//convert to XYZ points
		XYZ ArrayXYZ = GPS.GPStoXYZ(ArrayGPS);
		XYZ DroneXYZ = GPS.GPStoXYZ(DroneGPS);
		
		//Vector between the two points
		Vector arrayToDrone = Vector.VectorFromPoints(ArrayXYZ, DroneXYZ);
		//Vector to midpoint of arrayToDrone
		Vector midpointVector = Vector.MidpointVector(ArrayXYZ, DroneXYZ);
		//Projection of midpointVector onto xy-plane
		Vector midpointProjection = midpointVector.MidVectorXY();
		//vector perpendicular to both midpoint vectors as well as the future north vector
		Vector xyPerpendicular = Vector.CrossProduct(midpointVector, midpointProjection);
		//north vector
		Vector northVector = Vector.NorthVector(midpointVector, xyPerpendicular);
		//angle between northVector and arrayToDrone
		double arrayDroneAngle = Vector.Angle(northVector, arrayToDrone);
		//convert arrayDroneAngle back to degrees
		arrayDroneAngle = arrayDroneAngle * (180 / 3.14159);
		//account for east/west part of angle
		arrayDroneAngle = trueAngle(arrayDroneAngle, ArrayGPS, DroneGPS);
		
		System.out.println(arrayDroneAngle);
		
	}
}
