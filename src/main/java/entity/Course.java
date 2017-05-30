package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;



@Entity
public class Course implements Serializable{
	
private static final long serialVersionUID = 322625514552L;
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
 private Integer CODE;
 private String TITLE;
 
public Integer getCODE() {
	return CODE;
}
public void setCODE(Integer cODE) {
	CODE = cODE;
}
public String getTITLE() {
	return TITLE;
}
public void setTITLE(String tITLE) {
	TITLE = tITLE;
}
@Override
public String toString() {
	return "Course [CODE=" + CODE + ", TITLE=" + TITLE + "]";
}

public Course() {
	super();
	// TODO Auto-generated constructor stub
}

public Course(Integer cODE, String tITLE) {
	super();
	CODE = cODE;
	TITLE = tITLE;
}
 
 
}
