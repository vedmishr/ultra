package com.app.kraken.bean;

import java.util.Date;

public class Domestic {
	private String carrier;
	private long modelno;
	private String departure_airport;
	private String arrival_airport;
	private Date departure_date;
	private Date arrival_date;
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public long getModelno() {
		return modelno;
	}
	public void setModelno(long modelno) {
		this.modelno = modelno;
	}
	public String getDeparture_airport() {
		return departure_airport;
	}
	public void setDeparture_airport(String departure_airport) {
		this.departure_airport = departure_airport;
	}
	public String getArrival_airport() {
		return arrival_airport;
	}
	public void setArrival_airport(String arrival_airport) {
		this.arrival_airport = arrival_airport;
	}
	public Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}
	public Date getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}
	@Override
	public String toString() {
		return "Domestic [carrier=" + carrier + ", modelno=" + modelno + ", departure_airport=" + departure_airport
				+ ", arrival_airport=" + arrival_airport + ", departure_date=" + departure_date + ", arrival_date="
				+ arrival_date + "]";
	}
	public Domestic(long modelno, String carrier,  String departure_airport, String arrival_airport,
			Date departure_date, Date arrival_date) {
		super();
		this.modelno = modelno;
		this.carrier = carrier;
		this.departure_airport = departure_airport;
		this.arrival_airport = arrival_airport;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
	}
	public Domestic() {
		super();
	}
	
}