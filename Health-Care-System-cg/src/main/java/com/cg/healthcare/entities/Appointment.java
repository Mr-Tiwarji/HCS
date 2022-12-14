package com.cg.healthcare.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;





@Entity
@JsonSerialize
public class Appointment{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentid;

	private LocalDate appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus approvalStatus;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToMany
	private Set<DiagnosticTest> diagnosticTests;
	
	@JsonIgnore
	@ManyToOne
	private Patient patient;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToOne
	private DiagnosticCenter diagnosticCenter;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@OneToMany(mappedBy = "appointment",cascade = CascadeType.REMOVE)
	private Set<TestResult> testResult;
	

/** 
 *
 * It is a constructor. 
 *
 */
	public Appointment() { 

		super();
		}
		



		public Appointment(LocalDate appointmentDate, AppointmentStatus approvalStatus, Set<DiagnosticTest> diagnosticTests, 
				Patient patient, DiagnosticCenter diagnosticCenter, Set<TestResult> testResult) {

			super();
			this.appointmentDate = appointmentDate;
			this.approvalStatus = approvalStatus;
			this.diagnosticTests = diagnosticTests;
			this.patient = patient;
			this.diagnosticCenter = diagnosticCenter;
			this.testResult = testResult;
		}
	


/** 
 *
 * Gets the appointmentid
 *
 * @return the appointmentid
 */
	public int getAppointmentid() { 

		return appointmentid;
	}

/** 
 *
 * Sets the appointmentid
 *
 * @param appointmentid  the appointmentid
 */
	public void setAppointmentid(int appointmentid) { 

		this.appointmentid = appointmentid;
	}

/** 
 *
 * Gets the appointment date
 *
 * @return the appointment date
 */
	public LocalDate getAppointmentDate() { 

		return appointmentDate;
	}

/** 
 *
 * Sets the appointment date
 *
 * @param appointmentDate  the appointment date
 */
	public void setAppointmentDate(LocalDate appointmentDate) { 

		this.appointmentDate = appointmentDate;
	}

/** 
 *
 * It is a constructor. 
 *
 */
	public AppointmentStatus getApprovalStatus() { 

		return approvalStatus;
	}

/** 
 *
 * Sets the approval status
 *
 * @param approvalStatus  the approval status
 */
	public void setApprovalStatus(AppointmentStatus approvalStatus) { 

		this.approvalStatus = approvalStatus;
	}

/** 
 *
 * Gets the diagnostic tests
 *
 * @return the diagnostic tests
 */
	public Set<DiagnosticTest> getDiagnosticTests() { 

		return diagnosticTests;
	}

/** 
 *
 * Sets the diagnostic tests
 *
 * @param diagnosticTests  the diagnostic tests
 */
	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) { 

		this.diagnosticTests = diagnosticTests;
	}

/** 
 *
 * Gets the patient
 *
 * @return the patient
 */
	public Patient getPatient() { 

		return patient;
	}

/** 
 *
 * Sets the patient
 *
 * @param patient  the patient
 */
	public void setPatient(Patient patient) { 

		this.patient = patient;
	}

/** 
 *
 * Gets the diagnostic center
 *
 * @return the diagnostic center
 */
	public DiagnosticCenter getDiagnosticCenter() { 

		return diagnosticCenter;
	}

/** 
 *
 * Sets the diagnostic center
 *
 * @param diagnosticCenter  the diagnostic center
 */
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) { 

		this.diagnosticCenter = diagnosticCenter;
	}

/** 
 *
 * Gets the test result
 *
 * @return the test result
 */
	public Set<TestResult> getTestResult() { 

		return testResult;
	}

/** 
 *
 * Sets the test result
 *
 * @param testResult  the test result
 */
	public void setTestResult(Set<TestResult> testResult) { 

		this.testResult = testResult;
	}
	
	
}
