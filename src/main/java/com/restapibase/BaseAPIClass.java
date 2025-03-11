package com.restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPIClass {

	// Basic Function of Framework

	public static Response getRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		return response;
	}

	public static Response getRequest(String requestURI, String token, String key) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", token);
		requestSpecification.param("key", key);
		Response response = requestSpecification.get(requestURI);
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", bearer_token);
		Response response = requestSpecification.post(requestURI);
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayLoad, String token, String key) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.param("token", token);
		requestSpecification.param("key", key);
		Response response = requestSpecification.post(requestURI);
		return response;
	}
	public static Response putRequest(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public static Response deleteRequestWithPayload(String requestURI, String requestPayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}
}
