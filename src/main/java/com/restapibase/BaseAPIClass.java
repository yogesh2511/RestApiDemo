package com.restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestLogger;

public class BaseAPIClass {

	// Basic Function of Framework

	public static Response getRequest(String requestURI) {
		RestLogger.info("Request URI is:"+ requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}

	public static Response getRequest(String requestURI, String token, String key) {
		RestLogger.info("Request URI is:"+ requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", token);
		requestSpecification.param("key", key);
		Response response = requestSpecification.get(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayLoad) {
		RestLogger.info("Request URI is:"+ requestURI);
		RestLogger.info("Request Payload is:"+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad, String bearer_token) {
		RestLogger.info("Request URI is:"+ requestURI);
		RestLogger.info("Request Payload is:"+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", bearer_token);
		Response response = requestSpecification.post(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayLoad, String token, String key) {
		RestLogger.info("Request URI is:"+ requestURI);
		RestLogger.info("Request Payload is:"+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", token);
		requestSpecification.param("key", key);
		Response response = requestSpecification.post(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}
	public static Response putRequest(String requestURI, String requestPayLoad) {
		RestLogger.info("Request URI is:"+ requestURI);
		RestLogger.info("Request Payload is:"+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		RestLogger.info("Response is:"+response.getBody().asString());
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		RestLogger.info("Request URI is:"+ requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestLogger.info("Response Status code is:"+response.getStatusCode());
		return response;
	}

	public static Response deleteRequestWithPayload(String requestURI, String requestPayLoad) {
		RestLogger.info("Request URI is:"+ requestURI);
		RestLogger.info("Request Payload is:"+ requestPayLoad);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestLogger.info("Response Status code is:"+response.getStatusCode());
		return response;
	}
}
