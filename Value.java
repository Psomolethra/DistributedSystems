import java.io.*;
import java.net.*;

public class Value {
	
	public Bus bus;
	public double latitute;
	public double longtitude;
	
	public Value(Bus bus, double latitute, double longtitude) {
		this.bus=bus;
		this.latitute=latitute;
		this.longtitude=longtitude;
	}

	public Bus getBus() {
		return bus;
	}
	
	public double getLatitute() {
		return latitute;
	}
	
	public double getLongtitude() {
		return longtitude;
	}
}
