package com.mitutor.viewEntities;

import java.util.ArrayList;
import java.util.Date;

public class publishTutoringView {
	
	private String place;
	private String dayString;
	private Date endTime;
	private Date startTime;
	private Integer capacity;
	private String description;
	private ArrayList<Integer> topicId;
	private Integer subjectId;

	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDayString() {
		return dayString;
	}



	public void setDayString(String dayString) {
		this.dayString = dayString;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<Integer> getTopicId() {
		return topicId;
	}


	public void setTopicId(ArrayList<Integer> topicId) {
		this.topicId = topicId;
	}


	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}


	public publishTutoringView() {}
}
