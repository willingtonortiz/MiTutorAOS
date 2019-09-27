package com.mitutor.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qualification")
public class Qualification implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "rate")
	private Integer rate;

	@Column(name = "comment")
	private String comment;

	@Column(name = "adresserRole")
	private RoleType adresserRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresser_id")
	private Person adresser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adressee_id")
	private Person adressee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tutoring_session_id")
	private TutoringSession tutoringSession;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RoleType getAdresserRole() {
		return adresserRole;
	}

	public void setAdresserRole(RoleType adresserRole) {
		this.adresserRole = adresserRole;
	}

	public Person getAdresser() {
		return adresser;
	}

	public void setAdresser(Person adresser) {
		this.adresser = adresser;
	}

	public Person getAdressee() {
		return adressee;
	}

	public void setAdressee(Person adressee) {
		this.adressee = adressee;
	}

	public TutoringSession getTutoringSession() {
		return tutoringSession;
	}

	public void setTutoringSession(TutoringSession tutoringSession) {
		this.tutoringSession = tutoringSession;
	}

}
