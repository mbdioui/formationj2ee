package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer locationID;
	private String city;
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", city=" + city + "]";
	}
	public Location(Integer locationID, String city) {
		super();
		this.locationID = locationID;
		this.city = city;
	}
	

}
