package entity;

import java.io.Serializable;

import javax.persistence.*;




@Entity
@Table(name= "COURSE")
public class Course implements Serializable{
	
private static final long serialVersionUID = 1L;

@Id
@Column (name =  "Code")
 private String CODE;
@Column (name = "title", unique = true , nullable = false)
 private String TITLE;
 

public Course() {
	super();
}


@Override
public String toString() {
	return "Course [CODE=" + CODE + ", TITLE=" + TITLE + "]";
}


public String getCODE() {
	return CODE;
}
public void setCODE(String cODE) {
	CODE = cODE;
}
public String getTITLE() {
	return TITLE;
}
public void setTITLE(String tITLE) {
	TITLE = tITLE;
}


public Course(String cODE, String tITLE) {
	super();
	CODE = cODE;
	TITLE = tITLE;
}
 
}
