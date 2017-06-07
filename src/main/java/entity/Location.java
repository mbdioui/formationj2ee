package entity;

import javax.persistence.*;

@Entity
@Table(name= "LOCATION")
public class Location {
	
	private static final long serialVersionUID = 1L;
    
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "LOCATION_ID")
	private Long locationID;
	
	@Column (name = "City", nullable = false)
	private String city;

	public Location() {
		super();	
	}

	public Location(Long locationID, String city) {
		super();
		this.locationID = locationID;
		this.city = city;
	}

	public Long getLocationID() {
		return locationID;
	}

	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", city=" + city + "]";
	}
	
	

}
