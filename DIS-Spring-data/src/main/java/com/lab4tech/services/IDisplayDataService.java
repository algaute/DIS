package com.lab4tech.services;

import java.util.List;

import com.lab4tech.entities.DisplayData;
import com.mysema.query.types.expr.BooleanExpression;

public interface IDisplayDataService {

	// liste de tous les messages
	public List<DisplayData> getAllDisplayData();
	
	// liste de tous les messages avec query predicate
	public List<DisplayData> getAllDisplayData(BooleanExpression expression);
		
	// liste des messages actifs à l'instant
	public List<DisplayData> getAllCurrentValidDisplayData();
	
	// retrieve data by id
	public DisplayData getDisplayDataById(Long Id);
	
	// màj d'un message
	public DisplayData updateDisplayData(DisplayData displayData);
		
	// création d'un message
	public DisplayData createDisplayData(DisplayData displayData);
	
	// suppression d'un message
	public void deleteDisplayData(Long id);
	
	// recherche d'un message par son sujet
	public DisplayData findBySubject(String subject);
}