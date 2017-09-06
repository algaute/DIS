package com.lab4tech.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.lab4tech.entities.DisplayData;

public interface DisplayDataRepository extends CrudRepository<DisplayData, Long>, QueryDslPredicateExecutor<DisplayData> 
{
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	List<DisplayData> findAll();
	
	/**
	 * Returns the data with the given subject .
	 * 
	 * @param subject the subject to search for.
	 * @return
	 */
	DisplayData findBySubject(String subject);
	
	/**
	 * Returns the data with the given subject .
	 * 
	 * @param subject the subject to search for.
	 * @return
	 */
	@Query("select d from DisplayData d " +
	         "where d.start_date_millisec <= ?1 and d.end_date_millisec > ?1 and d.valid=1")
	List<DisplayData> findByDatesValidFor(BigInteger date_millisecondes);
}
