package com.app.kraken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.kraken.bean.Domestic;
import com.app.kraken.service.IDomesticService;

@RestController
public class DomesticController {
	
	@Autowired
	IDomesticService service;
	
  @PostMapping("/domestic/register")
	public ResponseEntity<Domestic> register(@RequestBody Domestic domestic)
	{
		Domestic domestic1 = service.registerDomestic(domestic);		
		if(domestic1!=null)
		{
			return new ResponseEntity<Domestic>(domestic1, HttpStatus.CREATED);
		}
		return new ResponseEntity<Domestic>(HttpStatus.BAD_REQUEST);
	}
 
	@PutMapping("/domestic/update/{modelno}")
	public ResponseEntity<Domestic> updateDomestic(@PathVariable long modelno,@RequestBody Domestic domestic)
	{
		long status=0;
			status = service.updateDomestic(domestic, modelno);
			Domestic domestic1=service.getDomestic(modelno);
			if(status!=0)
			{
				return new ResponseEntity<Domestic>(domestic1, HttpStatus.CREATED);
			}
			return new ResponseEntity<Domestic>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/domestic/get/{modelno}")
	public ResponseEntity<Domestic> getDomestic(@PathVariable long modelno )
	{
		Domestic domestic;
			domestic= service.getDomestic(modelno);
			if(domestic!=null)
			{
				return new ResponseEntity<Domestic>(domestic,HttpStatus.CREATED);
			}
			return new ResponseEntity<Domestic>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/domestic/getall")
	public List<Domestic> getAllDomestic()
	{
		List<Domestic> domestic;
		try {
			domestic = service.getAllDomestic();
		} catch (Exception e) {
			return null;
		}
		return domestic;
	}
	
	/*@PutMapping("/domestic/cancel/{modelno}")
	public ResponseEntity<Domestic> cancelDomestic(@PathVariable long modelno)
	{
		long success=0;
		success=service.cancelDomestic(modelno);
		if(success>0)
		{
			return new ResponseEntity<Domestic>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Domestic>(HttpStatus.BAD_REQUEST);
		}
	}*/
}