package com.lab4tech.web.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lab4tech.entities.DisplayData;
import com.lab4tech.services.DisplayDataService;
import com.lab4tech.web.models.DisplayDataList;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DisplayDataController {
	
	@Autowired
	private DisplayDataService displayDataService;
	
	
    @RequestMapping("/displayData")
	public DisplayDataList displayAllDatas() {
		System.out.println("==== in list all displayData ====");
		
		List<DisplayData> displayDatas=displayDataService.getAllDisplayData();
		
		DisplayDataList displayDataList=new DisplayDataList(displayDatas);
		
		return displayDataList;
	}
    
    @RequestMapping("/displayData/valid")
	public List<DisplayData> displayValidDatas() {
		System.out.println("==== in list valid displayData ====");
		return displayDataService.getAllCurrentValidDisplayData();
	}
    
    @RequestMapping(value="/displayData/add", method=RequestMethod.POST)
	public DisplayData addDisplayData(@RequestBody DisplayData data) {
		System.out.println("==== in add DisplayData ====");
		return displayDataService.createDisplayData(data);
	}

    @RequestMapping(value="/displayData/update", method=RequestMethod.POST)
	public DisplayData updateDisplayData(@RequestBody DisplayData data) {
		System.out.println("==== in update DisplayData ====");
		return displayDataService.updateDisplayData(data);
	}

    @RequestMapping(value="/displayData/delete", method=RequestMethod.POST)
	public void deleteDisplayData(@RequestBody long id) {
		System.out.println("==== in delete DisplayData ====");
		displayDataService.deleteDisplayData(id);
	}
    
    @RequestMapping(value="/displayData/{id}", method=RequestMethod.GET)
	public DisplayData retrieveDisplayDataById(@PathVariable long id) {
		System.out.println("==== in retrieveDisplayDataById  ====");
		return displayDataService.getDisplayDataById(id);
	}

}

