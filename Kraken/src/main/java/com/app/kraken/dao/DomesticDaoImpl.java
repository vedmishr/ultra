package com.app.kraken.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.kraken.bean.Domestic;
import com.app.kraken.bean.DomesticRowMapper;
@Repository
public class DomesticDaoImpl implements IDomesticDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	Date date = new Date();

	@Override
	public long updateDomestic(Domestic domestic, long modelno) {
		long success;
		String query = "UPDATE domestic SET carrier=?,departure_airport=?,arrival_airport=?,departure_date=?,arrival_date=? WHERE modelno=?";
		try {
			success = jdbcTemplate.update(query, domestic.getCarrier(), domestic.getDeparture_airport(),
					domestic.getArrival_airport(),domestic.getDeparture_date(),domestic.getArrival_date(), modelno);
		} catch (DataAccessException e) {
			return 0;
		}
		return success;
	}

	@Override
	public Domestic getDomestic(long modelno) {
		Domestic domestic;
		try {
			domestic = jdbcTemplate.queryForObject("SELECT * FROM domestic WHERE modelno = ?", new Object[] { modelno },
					new DomesticRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
		return domestic;
	}

	@Override
	public List<Domestic> getAllDomestic() {
		String query = "SELECT * FROM domestic";
		List<Domestic> domestic;
		try {
			domestic = jdbcTemplate.query(query, new DomesticRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
		return domestic;
	}

/*	@Override
	public long cancelDomestic(long modelno) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public Domestic registerDomestic(Domestic domestic) {
		String query="INSERT INTO domestic(carrier,departure_airport,arrival_airport,departure_date,arrival_date) VALUES (?,?,?,?,?)";
		Domestic domesti;
		try {
			jdbcTemplate.update(query,  domestic.getCarrier(),domestic.getDeparture_airport(),
					domestic.getArrival_airport(),domestic.getDeparture_date(),domestic.getDeparture_date());
		} catch (DataAccessException e) {
			return null;
		}
		 domesti = jdbcTemplate.queryForObject("select * from domestic where modelno in(select max(modelno) from domestic)",
				new DomesticRowMapper());
	  
	return domesti;	
	}

	/*@Override
	public long cancelDomestic(long modelno) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}