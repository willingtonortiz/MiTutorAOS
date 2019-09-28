package com.mitutor.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutor")
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "points")
	private Integer points;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "tutor")
	private List<TutoringOffer> tutoringOffers = new ArrayList<>();

	@OneToMany(mappedBy = "tutor")
	private List<TutoringSession> tutoringSessions = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tutor_subject", joinColumns = @JoinColumn(name = "tutor_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<Subject> subjects = new ArrayList<Subject>();

	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private Person person;

	@OneToOne(mappedBy = "tutor", cascade = CascadeType.ALL)
	private Availability availability;

	public Tutor() {

	}

	public Tutor(Integer points, String description) {
		this.points = points;
		this.description = description;
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TutoringSession> getTutoringSessions() {
		return tutoringSessions;
	}

	public void setTutoringSessions(List<TutoringSession> tutoringSessions) {
		this.tutoringSessions = tutoringSessions;
	}

	public List<TutoringOffer> getTutoringOffers() {
		return tutoringOffers;
	}

	public void setTutoringOffers(List<TutoringOffer> tutoringOffers) {
		this.tutoringOffers = tutoringOffers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
