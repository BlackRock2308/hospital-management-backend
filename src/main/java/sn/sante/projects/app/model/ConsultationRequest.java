package sn.sante.projects.app.model;

import java.sql.Date;

public class ConsultationRequest {

	private Date date;
	
	private Long medecin;
	
	private Long patient;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getMedecin() {
		return medecin;
	}

	public void setMedecin(Long medecin) {
		this.medecin = medecin;
	}

	public Long getPatient() {
		return patient;
	}

	public void setPatient(Long patient) {
		this.patient = patient;
	}
	
	
	
}
