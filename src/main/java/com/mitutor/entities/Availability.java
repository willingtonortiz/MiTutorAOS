package com.mitutor.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "availability")
public class Availability implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private Tutor tutor;

	@OneToMany(mappedBy = "availability")
	private List<AvailabilityDay> availabilityDays = new ArrayList<AvailabilityDay>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public List<AvailabilityDay> getAvailabilityDays() {
		return availabilityDays;
	}

	public void setAvailabilityDays(List<AvailabilityDay> availabilityDays) {
		this.availabilityDays = availabilityDays;
	}
}
