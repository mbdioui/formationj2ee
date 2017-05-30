package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CourseSession implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer sessionId;
	private Date startdate;
	private Date enddate;
	private String coursecode;
	private Integer locationId;
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "CourseSession [sessionId=" + sessionId + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", coursecode=" + coursecode + ", locationId=" + locationId + "]";
	}
	public CourseSession(Integer sessionId, Date startdate, Date enddate, String coursecode, Integer locationId) {
		super();
		this.sessionId = sessionId;
		this.startdate = startdate;
		this.enddate = enddate;
		this.coursecode = coursecode;
		this.locationId = locationId;
	}
	public CourseSession() {
		super();
	}
	

}
