package com.aca.rest.services;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;

public class AwsSnsSubscription {

public void emailSubAlonConway(String email) {
		
		SubscribeRequest request = new SubscribeRequest();
		request.setTopicArn(SnsPublish.alonConwayTopic);
		request.setProtocol("email");
		request.setEndpoint(email);
		
		AmazonSNSClient client = SnsPublish.getAwsClient();
		SubscribeResult result = client.subscribe(request);
		System.out.println("sub arn: " + result.getSubscriptionArn());
		
	}
	
public void emailSubMurphyExpressLittleRock(String email) {
	
	SubscribeRequest request = new SubscribeRequest();
	request.setTopicArn(SnsPublish.murphyExpressLittleRockTopic);
	request.setProtocol("email");
	request.setEndpoint(email);
	
	AmazonSNSClient client = SnsPublish.getAwsClient();
	SubscribeResult result = client.subscribe(request);
	System.out.println("sub arn: " + result.getSubscriptionArn());
	
}

public void emailSubSamsClubConway(String email) {
	
	SubscribeRequest request = new SubscribeRequest();
	request.setTopicArn(SnsPublish.samsClubConwayTopic);
	request.setProtocol("email");
	request.setEndpoint(email);
	
	AmazonSNSClient client = SnsPublish.getAwsClient();
	SubscribeResult result = client.subscribe(request);
	System.out.println("sub arn: " + result.getSubscriptionArn());
	
}

public void emailSubSamsClubFayetteville(String email) {
	
	SubscribeRequest request = new SubscribeRequest();
	request.setTopicArn(SnsPublish.samsClubFayettevilleTopic);
	request.setProtocol("email");
	request.setEndpoint(email);
	
	AmazonSNSClient client = SnsPublish.getAwsClient();
	SubscribeResult result = client.subscribe(request);
	System.out.println("sub arn: " + result.getSubscriptionArn());
	
}

public void emailSubValeroLittleRock(String email) {
	
	SubscribeRequest request = new SubscribeRequest();
	request.setTopicArn(SnsPublish.valeroLittleRockTopic);
	request.setProtocol("email");
	request.setEndpoint(email);
	
	AmazonSNSClient client = SnsPublish.getAwsClient();
	SubscribeResult result = client.subscribe(request);
	System.out.println("sub arn: " + result.getSubscriptionArn());
	
}






	public void textSubAlonConway(String phone) {
		String number = "+1" + phone;
		SubscribeRequest request = new SubscribeRequest();
		request.setTopicArn(SnsPublish.alonConwayTopic);
		request.setProtocol("sms");
		request.setEndpoint(number);

		
		
		AmazonSNSClient client = SnsPublish.getAwsClient();
		SubscribeResult result = client.subscribe(request);
		System.out.println("sub arn: " + result.getSubscriptionArn());
	}
	
}
