package entity;

import javax.persistence.*;

@Entity
@Table(name= "Location")
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

	public Location( String city) {
		
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
