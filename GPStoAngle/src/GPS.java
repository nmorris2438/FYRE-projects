import java.lang.Math;

public class GPS {
	private double latitude;
	private double longitude;
	
	public GPS(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setLat(double lat) {
		this.latitude = lat;
	}
	
	public void setLong(double longitude){
		this.longitude = longitude;
	}
	
	public double getLat(GPS gps){
		return gps.latitude;
	}
	
	public double getLong(){
		return this.longitude;
	}
	
	public static XYZ GPStoXYZ(GPS gps){
		double latitudeRad = (gps.latitude * (3.14159 / 180));
		double longitudeRad = (gps.longitude * (3.14159 / 180));
		
		double x = 6371 * Math.sin(latitudeRad) * Math.cos(longitudeRad);
		double y = 6371 * Math.sin(latitudeRad) * Math.sin(longitudeRad);
		double z = 6371 * Math.cos(latitudeRad);
		
		XYZ xyz = new XYZ(x, y, z);
		return xyz;
	}
}
