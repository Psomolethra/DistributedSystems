import java.io.*;
import java.net.*;

public class Bus {
	
	public String lineNumber;
	public String routeCode;
	public String vehicleId;
	public String lineName;
	public String buslineId;
	public String info;
	
	public Bus(String lineNumber,String routeCode,String vehicleId,String lineName,String buslineId,String info){
		
		this.lineNumber=lineNumber;
		this.routeCode=routeCode;
		this.vehicleId=vehicleId;
		this.lineName=lineName;
		this.buslineId=buslineId;
		this.info=info;
		
	}
	
	public String getLineNumber(){
		return lineNumber;
	}
	
	public String getRouteCode() {
		return routeCode;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	
	public String getLineName() {
		return lineName;
	}
	
	public String getBuslineId() {
		return buslineId;
	}
	
	public String getInfo() {
		return info;
	}
	
	
	

}
