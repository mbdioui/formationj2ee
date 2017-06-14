/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author mohamed salah
 */
@Entity
@Table (name="course_session_join")
public class Course_session_join implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    private Long ID;
    @Column (name = "Client_ID")
    private Long Client_ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    @Column (name = "Course_session_ID", nullable = false)
    private Long Course_session_ID;

    public Course_session_join()
    {
            super();
    }

    public static long getSerialversionuid() {
            return serialVersionUID;
    }

    @Override
    public String toString() {
            return "CourseSession_join [sessionId=" + Course_session_ID + ", Client=" + Client_ID + "]";
    }

    public Long getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(Long Client_ID) {
        this.Client_ID = Client_ID;
    }

    public Long getCourse_session_ID() {
        return Course_session_ID;
    }

    public void setCourse_session_ID(Long Course_session_ID) {
        this.Course_session_ID = Course_session_ID;
    }

    public Course_session_join(Long Client_ID, Long Course_session_ID) {
        this.Client_ID = Client_ID;
        this.Course_session_ID = Course_session_ID;
    }
    
}
