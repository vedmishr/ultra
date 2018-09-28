package com.app.kraken.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DomesticRowMapper implements RowMapper<Domestic> {

	@Override
	public Domestic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Domestic domestic=new Domestic();
		domestic.setModelno(rs.getLong("modelno"));
		domestic.setCarrier(rs.getString("carrier"));
		domestic.setDeparture_airport(rs.getString("departure_airport"));
		domestic.setArrival_airport(rs.getString("arrival_airport"));
		domestic.setDeparture_date(rs.getDate("departure_date"));
		domestic.setArrival_date(rs.getDate("arrival_date"));
		return domestic;
	}
}