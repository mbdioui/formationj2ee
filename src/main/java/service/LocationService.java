package service;

import entity.Location;
import java.util.List;
import repository.LocationDAO;



/**
 *
 * @author jamal
 */
public class LocationService {
    
    LocationDAO locationDao = new LocationDAO();
    
    public void addLocation(Location location) {
        locationDao.addLocation(location);
    }
     public List<Location> getAllLocations() {
         return locationDao.getAllLocations();
     }
      public Location getLocationById(Long locationId) {
          return locationDao.getLocationById(locationId);
      }
      public Location getLocationByCity(String city) {
          return locationDao.getLocationByCity(city);
      }
}
