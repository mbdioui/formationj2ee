package entity;

public class Client {

	private Integer ID_Client;
	private String LASTNAME;
	private String FIRSTNAME;
	private String ADDRESS;
	private Integer PHONE;
	private String EMAIL;
	private Integer COURSE_SESSION_ID;
	public Integer getID_Client() {
		return ID_Client;
	}
	public void setID_Client(Integer iD_Client) {
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
	public Integer getPHONE() {
		return PHONE;
	}
	public void setPHONE(Integer pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Integer getCOURSE_SESSION_ID() {
		return COURSE_SESSION_ID;
	}
	public void setCOURSE_SESSION_ID(Integer cOURSE_SESSION_ID) {
		COURSE_SESSION_ID = cOURSE_SESSION_ID;
	}
	@Override
	public String toString() {
		return "Client [ID_Client=" + ID_Client + ", LASTNAME=" + LASTNAME + ", FIRSTNAME=" + FIRSTNAME + ", ADDRESS="
				+ ADDRESS + ", PHONE=" + PHONE + ", EMAIL=" + EMAIL + ", COURSE_SESSION_ID=" + COURSE_SESSION_ID + "]";
	}
	public Client(Integer iD_Client, String lASTNAME, String fIRSTNAME, String aDDRESS, Integer pHONE, String eMAIL,
			Integer cOURSE_SESSION_ID) {
		super();
		ID_Client = iD_Client;
		LASTNAME = lASTNAME;
		FIRSTNAME = fIRSTNAME;
		ADDRESS = aDDRESS;
		PHONE = pHONE;
		EMAIL = eMAIL;
		COURSE_SESSION_ID = cOURSE_SESSION_ID;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
