package entity;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "CLIENT_ID")
	private Long ID_Client;
	@Column(name = "Last_name", unique = true, nullable = false)
	private String LASTNAME;
	@Column(name = "First_name", nullable = false)
	private String FIRSTNAME;
	@Column(name = "Address",nullable = false)
	private String ADDRESS;
	@Column(name = "Phone", unique = true, nullable = false)
	private String PHONE;
	@Column (name = "Email", unique = true)
	private String EMAIL;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COURSE_SESSION_ID")
	private CourseSession coursession;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(Long iD_Client, String lASTNAME, String fIRSTNAME, String aDDRESS, String pHONE, String eMAIL,
			CourseSession coursession) {
		super();
		ID_Client = iD_Client;
		LASTNAME = lASTNAME;
		FIRSTNAME = fIRSTNAME;
		ADDRESS = aDDRESS;
		PHONE = pHONE;
		EMAIL = eMAIL;
		this.coursession = coursession;
	}


	public Long getID_Client() {
		return ID_Client;
	}


	public void setID_Client(Long iD_Client) {
		ID_Client = iD_Client;
	}


	public String getLASTNAME() {
		return LASTNAME;
	}


	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}


	public String getFIRSTNAME() {
		return FIRSTNAME;
	}


	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}


	public String getADDRESS() {
		return ADDRESS;
	}


	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}


	public String getPHONE() {
		return PHONE;
	}


	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}


	public String getEMAIL() {
		return EMAIL;
	}


	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}


	public CourseSession getCoursession() {
		return coursession;
	}


	public void setCoursession(CourseSession coursession) {
		this.coursession = coursession;
	}


	@Override
	public String toString() {
		return "Client [ID_Client=" + ID_Client + ", LASTNAME=" + LASTNAME + ", FIRSTNAME=" + FIRSTNAME + ", ADDRESS="
				+ ADDRESS + ", PHONE=" + PHONE + ", EMAIL=" + EMAIL + ", coursession=" + coursession + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
