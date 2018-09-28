package com.app.kraken.dao;

import java.util.List;

import com.app.kraken.bean.Domestic;

public interface IDomesticDao {
	long updateDomestic(Domestic domestic, long modelno);
	Domestic getDomestic(long modelno);
	List<Domestic> getAllDomestic();
//	long cancelDomestic(long modelno);
	Domestic registerDomestic(Domestic domestic);
}
