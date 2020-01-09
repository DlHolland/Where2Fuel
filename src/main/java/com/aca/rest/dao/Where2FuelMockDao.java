/*package com.aca.rest.dao;


import java.util.ArrayList;
import java.util.List;

import com.aca.rest.model.Station;

public class Where2FuelMockDao {

	private static List<Station> stations = new ArrayList<Station>();


	
	static {
		
	//	stations.add(new Station("Shell", 2.25, "1234 E street", "Conway", "Ar", 72032));
	//	stations.add(new Station("Conaco", 2.35, "1576 B Drive", "Cabot", "Ar", 72893));
	//	stations.add(new Station("Kum and Go", 2.27, "6789 G Avenue", "Fayetteville", "Ar", 72701));
	}
	
	public List<Station> getAllStations() {
		List<Station> myStations = new ArrayList<Station>();
		myStations.addAll(stations);
		
		return myStations;
		
		
	}

	public List<Station> getStationByZipCode(int zipCode) {
		List<Station> myStations = new ArrayList<Station>();
		
		for(Station station : Where2FuelMockDao.stations) {
			if (station.getZipCode() == (zipCode)) {
				myStations.add(station);
			}
		}
		
		return myStations;
	}
	
	public List<Station> getStationByCity(String city) {
		List<Station> myStations = new ArrayList<Station>();
		
		for(Station station : Where2FuelMockDao.stations) {
			if (station.getCity().equalsIgnoreCase(city)) {
				myStations.add(station);
			}
		}
		return myStations;
	}
	
	public List<Station> add(Station newStation) {

		stations.add(newStation);
		
		List<Station> myStations = new ArrayList<Station>();
		myStations.add(newStation);
		return myStations;
	}

	
			
			
}
*/
