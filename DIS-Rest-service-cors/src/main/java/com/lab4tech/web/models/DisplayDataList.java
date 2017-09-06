package com.lab4tech.web.models;

import java.util.ArrayList;
import java.util.List;

import com.lab4tech.entities.DisplayData;

public class DisplayDataList
{
	private Integer items;
	private List<DisplayData> displayDatas;

	protected DisplayDataList() {
		if (displayDatas==null)
		{
			displayDatas=new ArrayList<DisplayData>();
		}
	}
	
	public DisplayDataList(List<DisplayData> displayDatas)
	{
		this();
		this.items=displayDatas.size();
		this.displayDatas=displayDatas;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public List<DisplayData> getDisplayDatas() {
		return displayDatas;
	}

	public void setDisplayDatas(List<DisplayData> displayDatas) {
		this.displayDatas = displayDatas;
	}

	@Override
	public String toString() {
		String myString;
		
		myString= String.format("DisplayData items=%d\n",displayDatas.size());
		for(DisplayData displayData:displayDatas) 
		{
			myString= String.format("[id=%d, message='%s', start_date_millisec=%d, end_date_millisec=%d, time_interval_sec=%d, "
					+ "valid='%s', notes='%s', image='%s', created_by='%s', created_on=%d, subject='%s', the_order=%d]\n",displayData.getId(), 
					displayData.getMessage(),displayData.getStart_date_millisec(),displayData.getEnd_date_millisec(),displayData.getTime_interval_sec(),displayData.getValid(),displayData.getNotes(),displayData.getImage(),displayData.getCreated_by(),displayData.getCreated_on(),displayData.getSubject(),displayData.getThe_order());
		}
		
		return myString;
    }
}
