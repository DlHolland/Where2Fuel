package com.aca.rest.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aca.rest.dao.Where2FuelDbDao;
import com.aca.rest.model.EmailMessage;
import com.aca.rest.model.Station;
import com.aca.rest.model.TextSns;
public class Where2FuelService {

	
	private Where2FuelDbDao dao = new Where2FuelDbDao();
	private AwsSnsSubscription aws = new AwsSnsSubscription();
	

	public List<Station> getStationByValue(String value) {
		Station stationa = new Station();
		Station stationb = new Station();
		int result = 0;
		
		if (value.equalsIgnoreCase("all")) {
			
			List<Station> stations = dao.getAllStations();
			
			for (int i = 0; i < stations.size() -1; i++) {
				
				for(int j = 0; j < stations.size() - i - 1; j++) {
					stationa = stations.get(j);
					stationb = stations.get(j + 1);
					
					if (stationa.getAddress().equals(stationb.getAddress())) {
						 result = compareStations(stationa, stationb);
						 
						 System.out.println(stationa.getAddress() + "\t" + stationb.getAddress());
						 if (result <= 0) {
								stations.remove(stationa);
									
							} else {
								stations.remove(stationb);
							}		 
						}			
					}		
				}
			Collections.sort(stations);
			return stations;
		
		} else {
			
			List<Station> stations = dao.getStationByCity(value);
				
			for (int i = 0; i < stations.size() -1; i++) {
				
				for(int j = 0; j < stations.size() - i - 1; j++) {
					stationa = stations.get(j);
					stationb = stations.get(j + 1);
					
					if (stationa.getAddress().equals(stationb.getAddress())) {
						 result = compareStations(stationa, stationb);
						 
						 if (result <= 0) {
								stations.remove(stationa);
									
							} else {
								stations.remove(stationb);
							}		 
						}			
					}		
				}
			Collections.sort(stations);
			return stations;
		}
		
	}
	
	public String sendEmail(EmailMessage emailMessage) {
		String messageId = SnsPublish.sendEmail(emailMessage);		
		return messageId;
	}
	
	public String sendText(TextSns textSns) {
		String messageId = SnsPublish.sendText(textSns);
		return messageId;
	}


	public List<Station> getStationByAddress(String address) {

		return dao.getStationByAddress(address);
	}



	public void emailSubscribe(String email, String address) {

		switch(address) {
		
		case "12600 Chenal Pkwy Little Rock, AR":
			aws.emailSubMurphyExpressLittleRock(email);
			break;
		case "1905 Old Morrilton Hwy Conway, AR":
			aws.emailSubAlonConway(email);
			break;
		case "1250 S Amity Rd Conway, AR":
			aws.emailSubSamsClubConway(email);
			break;
		case "3069 N AR-112 Fayetteville, AR":
			aws.emailSubSamsClubFayetteville(email);
			break;
		case "6421 S University Ave Little Rock, AR":
			aws.emailSubValeroLittleRock(email);
			break;
		} 
		
	}
	



	public void textSubscribe(String phone) {

		aws.textSubAlonConway(phone);
	}
	
	public int compareStations(Station a, Station b) {
		int result = 0;
		
		
			result = a.getUpdateDate().compareTo(b.getUpdateDate());
		
		return result;	
	}
		
	public List<Station> orderByPrice(List<Station> stations) {
		
		
		
		return stations;
		
	}
	
}
