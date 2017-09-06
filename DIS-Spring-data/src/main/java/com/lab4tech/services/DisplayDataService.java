package com.lab4tech.services;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4tech.entities.DisplayData;
import com.lab4tech.repositories.DisplayDataRepository;
import com.mysema.query.types.expr.BooleanExpression;

@Service("displayDataService")
public class DisplayDataService implements IDisplayDataService {

	// répositories
	@Autowired
	private DisplayDataRepository displayDataRepository;

	// implémentation interface
	@Override
	public List<DisplayData> getAllDisplayData() {
		return displayDataRepository.findAll();
	}
	
	@Override
	public List<DisplayData> getAllDisplayData(BooleanExpression expression) {
		return (List<DisplayData>)displayDataRepository.findAll(expression);
	}
	
	@Override
	public List<DisplayData> getAllCurrentValidDisplayData() {
		Long current_millisecondes = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		BigInteger date_millisecondes = BigInteger.valueOf(current_millisecondes);
		
		return displayDataRepository.findByDatesValidFor(date_millisecondes);
	}
		
	@Override
	public DisplayData getDisplayDataById(Long Id) {
		return displayDataRepository.findOne(Id);
	}
	
	@Override
	public DisplayData updateDisplayData(DisplayData displayData) {
		return displayDataRepository.save(displayData);
	}

	@Override
	public DisplayData createDisplayData(DisplayData displayData) {
		return displayDataRepository.save(displayData);
	}

	@Override
	public void deleteDisplayData(Long id) {
		displayDataRepository.delete(id);
	}

	@Override
	public DisplayData findBySubject(String subject) {
		return displayDataRepository.findBySubject(subject);
	}
}
