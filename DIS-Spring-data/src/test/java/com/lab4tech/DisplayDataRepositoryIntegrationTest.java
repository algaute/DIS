/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lab4tech;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.lab4tech.entities.DisplayData;
import com.lab4tech.entities.QDisplayData;
import com.lab4tech.repositories.DisplayDataRepository;
import com.lab4tech.services.DisplayDataService;
import com.mysema.query.types.expr.BooleanExpression;

/**
 * Integration tests for {@link DisplayDataRepository}.
 */
public class DisplayDataRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired DisplayDataService displayDataService;

	/**
	 * Save a new record 
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void saveNewDisplayData() {
				
		Long from_millisecondes = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Long to_millisecondes =  LocalDateTime.now().plusDays(2).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		
		List<DisplayData> displayDatas = displayDataService.getAllDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas.size()>0);
		
		String message="mon nouveau message";
		BigInteger start_date_millisec=BigInteger.valueOf(from_millisecondes);
		BigInteger end_date_millisec=BigInteger.valueOf(to_millisecondes);
		Integer time_interval_sec=2;
		Boolean valid=true;
		String notes="ma note";

		ClassLoader classLoader = this.getClass().getClassLoader();  
		// Getting resource(File) from class loader  
		File file=new File(classLoader.getResource("testImage.jpg").getFile());  
		byte[] b = new byte[(int) file.length()];
    	FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			fis.read(b);
			fis.close();
		} catch (FileNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		} catch (IOException e) {
			Assert.fail(e.getLocalizedMessage());
		} 
		byte[] image=b;
		
		String created_by="JUnit";
		BigInteger created_on=BigInteger.valueOf(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		String subject="Insertion de test";
		Integer the_order=0;
		DisplayData displayData=new DisplayData(message, 
												start_date_millisec, 
												end_date_millisec, 
												time_interval_sec, 
												valid, 
												notes, 
												image, 
												created_by, 
												created_on, 
												subject, 
												the_order);
		displayData=displayDataService.createDisplayData(displayData);
		
		List<DisplayData> displayDatas2 = displayDataService.getAllDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas2.size()>0);
		
		Assert.assertTrue("le nombre de record doit être augmenté de 1",displayDatas2.size() == displayDatas.size()+1);
	}

	/**
	 * Remove an existing record
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void removeDisplayData() {
		List<DisplayData> displayDatas = displayDataService.getAllDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas.size()>0);

		displayDataService.deleteDisplayData(displayDatas.get(0).getId());
		
		List<DisplayData> displayDatas2 = displayDataService.getAllDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas2.size()>0);

		Assert.assertTrue("le nombre d'item après insertion doit être inférieur de 1",displayDatas2.size()+1 == displayDatas.size());
	}
	
	/**
	 * Update a record
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void updateDisplayData() {
		DisplayData displayData = displayDataService.findBySubject("Bienvenue");
		Assert.assertNotNull("Record with subject 'Bienvenue' not found", displayData);
		
		displayData.setSubject("Bienvonue");
		displayDataService.updateDisplayData(displayData);
		
		displayData = displayDataService.findBySubject("Bienvenue");
		Assert.assertNull("Record with subject 'Bienvenue' should not be found", displayData);

		displayData = displayDataService.findBySubject("Bienvonue");
		Assert.assertNotNull("Record with subject 'Bienvonue' should be found", displayData);

	}
	
	/**
	 * Extract all records available a this date
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void findsDisplayDataBetweenDate() {
		List<DisplayData> displayDatas = displayDataService.getAllCurrentValidDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas.size()>0);
	}
	
	/**
	 * Extract a record by his id
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void findsDisplayDataById() {
		List<DisplayData> displayDatas = displayDataService.getAllDisplayData();
		Assert.assertTrue("No data found in displaydata table, please control default insertion test values",displayDatas.size()>0);
		
		for (DisplayData dd: displayDatas) {
			DisplayData displayData = displayDataService.getDisplayDataById(dd.getId());

			assertThat(displayData, is(notNullValue()));
		}
		
		
		//assertThat(displayData.getFirstname(), is("Dave"));
		//assertThat(displayData.getLastname(), is("Matthews"));
	}
	
	/**
	 * Execute some predicates queries
	 */
	@Test
	@Sql({"/test-displaydata.sql"})
	public void executesQuerydslPredicate() {
		DisplayData displayData = displayDataService.findBySubject("Bienvenue");
		
		QDisplayData qDisplayData = QDisplayData.displayData;

		BooleanExpression subjectStartWithOb = qDisplayData.subject.startsWith("Bien");
		BooleanExpression subjectContainCoaching = qDisplayData.subject.contains("Coach");

		List<DisplayData> result = displayDataService.getAllDisplayData(subjectStartWithOb.or(subjectContainCoaching));

		assertThat(result, is(Matchers.<DisplayData> iterableWithSize(2)));
		assertThat(result, hasItems(displayData));
	}
}
