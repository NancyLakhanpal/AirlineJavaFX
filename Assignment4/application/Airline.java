package application;

public class Airline {
	public String airline;
	public String airlineNo;
	public String deptAirport;
	
	public Airline(String airline, String airlineNo, String deptAirport, String arrAirport) {
		super();
		this.airline = airline;
		this.airlineNo = airlineNo;
		this.deptAirport = deptAirport;
		this.arrAirport = arrAirport;
	}
	
	
	public String getAirline() {
		return airline;
	}

	public String getAirlineNo() {
		return airlineNo;
	}

	public String getDeptAirport() {
		return deptAirport;
	}

	public String getArrAirport() {
		return arrAirport;
	}

	public String arrAirport;
	
	
}
