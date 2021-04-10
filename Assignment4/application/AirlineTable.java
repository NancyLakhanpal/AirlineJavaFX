package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AirlineTable {
	SimpleStringProperty airline;
	SimpleStringProperty airlineNo;
	SimpleStringProperty departure;
	SimpleStringProperty arrival;
	
	public AirlineTable(String airline, String airlineNo, String departure, String arrival) 
	{
		super();
		this.airline = new SimpleStringProperty(airline);
		this.airlineNo = new SimpleStringProperty(airlineNo);
		this.departure = new SimpleStringProperty(departure);
		this.arrival = new SimpleStringProperty(arrival);
	}
	
	public StringProperty airlineProperty()
	{
		return airline;
	}
	
	public StringProperty airlineNoProperty()
	{
		return airlineNo;
	}
	
	public StringProperty departureProperty()
	{
		return departure;
	}
	
	public StringProperty arrivalProperty()
	{
		return arrival;
	}
}
