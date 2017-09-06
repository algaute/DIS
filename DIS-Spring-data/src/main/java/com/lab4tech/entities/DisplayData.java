package com.lab4tech.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="displaydata")
public class DisplayData extends AbstractEntity {

	@Column(columnDefinition = "VARCHAR(10000)", nullable=false )
    private String message;

	@Column(columnDefinition = "BIGINT(20)", nullable=false)
    private BigInteger start_date_millisec;

	@Column(columnDefinition = "BIGINT(20)", nullable=false)
    private BigInteger end_date_millisec;

	@Column(nullable=false)
    private Integer time_interval_sec;
 
	@Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(columnDefinition = "TINYINT(1) default 0", nullable=false )
    private Boolean valid;
  
	@Column(columnDefinition = "VARCHAR(100)", nullable=true )
	private String notes;
  
	@Lob 
	@Column( nullable=true )
    private byte[] image;

	@Column(columnDefinition = "VARCHAR(45)", nullable=false)
    private String created_by;
	
	@Column(columnDefinition = "BIGINT(20)", nullable=false)
    private BigInteger created_on;
	
	@Column(columnDefinition = "VARCHAR(45)", nullable=false)
    private String subject;
	
	@Column(nullable=true )
	private Integer the_order;
    
	protected DisplayData() {}
	
	public DisplayData(String message,BigInteger start_date_millisec,BigInteger end_date_millisec,Integer time_interval_sec, Boolean valid,
			String notes,byte[] image,String created_by,BigInteger created_on, String subject,Integer the_order)
	{
	    this.message=message;
	    this.start_date_millisec=start_date_millisec;
	    this.end_date_millisec=end_date_millisec;
	    this.time_interval_sec=time_interval_sec;
	    this.valid=valid;
	    this.notes=notes;
	    this.image=image;
	    this.created_by=created_by;
	    this.created_on=created_on;
	    this.subject=subject;
	    this.the_order=the_order;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigInteger getStart_date_millisec() {
		return start_date_millisec;
	}

	public void setStart_date_millisec(BigInteger start_date_millisec) {
		this.start_date_millisec = start_date_millisec;
	}

	public BigInteger getEnd_date_millisec() {
		return end_date_millisec;
	}

	public void setEnd_date_millisec(BigInteger end_date_millisec) {
		this.end_date_millisec = end_date_millisec;
	}

	public Integer getTime_interval_sec() {
		return time_interval_sec;
	}

	public void setTime_interval_sec(Integer time_interval_sec) {
		this.time_interval_sec = time_interval_sec;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public BigInteger getCreated_on() {
		return created_on;
	}

	public void setCreated_on(BigInteger created_on) {
		this.created_on = created_on;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getThe_order() {
		return the_order;
	}

	public void setThe_order(Integer the_order) {
		this.the_order = the_order;
	}
	
	
    @Override
	public String toString() {
	    return String.format("DisplayData[id=%d, message='%s', start_date_millisec=%d, end_date_millisec=%d, time_interval_sec=%d, "
	    		+ "valid='%s', notes='%s', image='%s', created_by='%s', created_on=%d, subject='%s', the_order=%d]",getId(), 
	    		message,start_date_millisec,end_date_millisec,time_interval_sec,valid,notes,image,created_by,created_on,subject,the_order);
    }
}
