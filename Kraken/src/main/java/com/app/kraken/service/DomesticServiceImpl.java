package com.app.kraken.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kraken.bean.Domestic;
import com.app.kraken.dao.IDomesticDao;
@Service
public class DomesticServiceImpl implements IDomesticService{
	
	@Autowired
	IDomesticDao dao;

	@Override
	public long updateDomestic(Domestic domestic, long modelno) {
		return dao.updateDomestic(domestic,modelno);
	}

	@Override
	public Domestic getDomestic(long modelno) {
		return dao.getDomestic(modelno);
	}

	@Override
	public List<Domestic> getAllDomestic() {
		return dao.getAllDomestic();
	}

	/*@Override
	public long cancelDomestic(long modelno) {
		return dao.cancelDomestic(modelno);
	}*/

	@Override
	public Domestic registerDomestic(Domestic domestic) {
		return dao.registerDomestic(domestic);
	}
}