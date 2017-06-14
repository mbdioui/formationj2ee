package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table (name="Cours_session")
public class CourseSession implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "COURSE_SESSION_ID")
	private Long sessionId;
	
	@Column (name = "START_DATE", nullable = false)
        @Temporal(TemporalType.DATE)
	private Date startdate;
	
	@Column (name = "END_DATE", nullable = false)
        @Temporal(TemporalType.DATE)
	private Date enddate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;

	public CourseSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseSession(Date startdate, Date enddate, Course course, Location location) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.course = course;
		this.location = location;
	}

    

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CourseSession [sessionId=" + sessionId + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", course=" + course + ", location=" + location + "]";
	}
	
	
	

}
