package com.mitutor.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "subject")
	private List<Topic> topics = new ArrayList<Topic>();

	@ManyToMany(mappedBy = "subjects")
	private List<Student> students = new ArrayList<>();

	@ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
	private List<Tutor> tutors = new ArrayList<>();

	@OneToMany(mappedBy = "subject")
	private List<TutoringOffer> tutoringOffers = new ArrayList<>();

	@OneToMany(mappedBy = "subject")
	private List<TutoringOffer> tutoringSessions = new ArrayList<>();

	public Subject() {

	}

	public Subject(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	public List<TutoringOffer> getTutoringOffers() {
		return tutoringOffers;
	}

	public void setTutoringOffers(List<TutoringOffer> tutoringOffers) {
		this.tutoringOffers = tutoringOffers;
	}

//	public TutoringSession getTutoringSessions() {
//		return tutoringSessions;
//	}
//
//	public void setTutoringSessions(TutoringSession tutoringSessions) {
//		this.tutoringSessions = tutoringSessions;
//	}

}
