package com.mitutor.viewEntities;

import java.util.Date;

import com.mitutor.entities.Subject;
import com.mitutor.entities.Tutor;
import com.mitutor.entities.TutoringSession;

public class tutoringSessionDetailView {
	
	private TutoringSession tutoringSession;
	private Integer studentId;
	private Boolean confirmed;
	private Integer confirmedStudents;
	
	public TutoringSession getTutoringSession() {
		return tutoringSession;
	}
	public void setTutoringSession(TutoringSession tutoringSession) {
		this.tutoringSession = tutoringSession;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	public Integer getConfirmedStudents() {
		return confirmedStudents;
	}
	public void setConfirmedStudents(Integer confirmedStudents) {
		this.confirmedStudents = confirmedStudents;
	}
	
	
	

}
