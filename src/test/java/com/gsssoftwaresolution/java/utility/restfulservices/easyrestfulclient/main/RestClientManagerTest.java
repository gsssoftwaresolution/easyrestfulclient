package com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.main;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.gsssoftwaresolution.java.utility.filehandling.ContenttLoader;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.common.Constant;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model.GetRequest;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model.Person;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model.PostRequest;
import com.gsssoftwaresolution.java.utility.restfulservices.easyrestfulclient.model.Request;

import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;



public class RestClientManagerTest {
	
	static WireMockServer mockServer;
	Map<String,String> headers;
	Class responseClass;
	Object requestBody;
	String requestUrl;
	static RestClientManager restClient;
	
	@BeforeClass
	public static void oneTimeSetup(){
		mockServer=new WireMockServer();
		mockServer.start();
		restClient=new RestClientManager(3);
	}
	
	@Before
	public void setUp(){
		headers=new HashMap<>();
		
	}
	
	@Test
	public void whenJsonGetRequestIsMadeToMockServerShouldReturnCorrectResponseObject() throws IOException, InterruptedException, ExecutionException{
	  configureFor("localhost",8080);
	  stubFor(get(urlEqualTo("/getTestPage")).willReturn(aResponse().withBody(ContenttLoader.readFile("person.txt").getBytes())));
	  requestUrl="http://localhost:8080/getTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Person.class;
	  requestBody=null;
	  String httpMethod=Constant.GET_METHOD;
	  Request request=new GetRequest(requestUrl,headers, responseClass);
	  Person response=(Person)restClient.getData(request);
	  assertEquals(response.getId(), 1);
	}
	
	@Test
	public void whenXmlGetRequestIsMadeToMockServerShouldReturnCorrectResponseObject() throws IOException, InterruptedException, ExecutionException{
	  configureFor("localhost",8080);
	  stubFor(get(urlEqualTo("/getXmlTestPage")).willReturn(aResponse().withBody(ContenttLoader.readFile("Person.xml").getBytes())));
	  requestUrl="http://localhost:8080/getXmlTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_XML);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_XML);
	  responseClass=Person.class;
	  requestBody=null;
	  String httpMethod=Constant.GET_METHOD;
	  Request request=new GetRequest(requestUrl, headers,responseClass);
	  Person response=(Person)restClient.getData(request);
	  assertEquals(response.getId(), 123);
	}
	
	@Test
	public void whenXmlPostRequestWithParticularXmlBodyIsMadeToMockServerShouldReturnCorrectResponseObject() throws IOException, InterruptedException, ExecutionException{
	  Person person=new Person();
	  person.setAddress("dummyAddressRqst");
	  person.setId(234);
	  person.setName("dummyNameRqst");
	  configureFor("localhost",8080);
	  stubFor(post(urlEqualTo("/gePostWithParticularBodytXmlTestPage"))
			  .withRequestBody(equalToXml("<Person><name>dummyNameRqst</name><id>234</id><address>dummyAddressRqst</address></Person>"))
			  .willReturn(aResponse().withBody(ContenttLoader.readFile("Person.xml").getBytes())));
	  requestUrl="http://localhost:8080/gePostWithParticularBodytXmlTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_XML);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_XML);
	  responseClass=Person.class;
	  requestBody=person;
	  Request request=new PostRequest(requestUrl, headers, requestBody, responseClass);
	  Person response=(Person)restClient.getData(request);
	  assertEquals(response.getId(), 123);
	}

			
	@Test
	public void whenJsonPostRequestIsMadeToMockServerShouldReturnCorrectResponseObject() throws IOException, InterruptedException, ExecutionException{
	  configureFor("localhost",8080);
	  stubFor(post(urlEqualTo("/getPostTestPage")).willReturn(aResponse().withBody(ContenttLoader.readFile("person.txt").getBytes())));
	  requestUrl="http://localhost:8080/getPostTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Person.class;
	  requestBody=new Person();
	  ((Person)requestBody).setName("postDummyName");
	  Request request=new PostRequest(requestUrl, headers, requestBody, responseClass);
	  Person response=(Person)restClient.getData(request);
	  assertEquals(response.getId(), 1);
	}
	
	@Test
	public void whenMultipleJsonMixRequestIsMadeToMockServerShouldReturnCorrectResponseObjects() throws IOException, InterruptedException, ExecutionException{
	  configureFor("localhost",8080);
	  stubFor(post(urlEqualTo("/getPerson1")).willReturn(aResponse().withBody(ContenttLoader.readFile("person1.txt").getBytes())));
	  configureFor("localhost",8080);
	  stubFor(get(urlEqualTo("/getPerson2")).willReturn(aResponse().withBody(ContenttLoader.readFile("person2.txt").getBytes())));
	  configureFor("localhost",8080);
	  stubFor(post(urlEqualTo("/getPerson3")).willReturn(aResponse().withBody(ContenttLoader.readFile("person3.txt").getBytes())));
	 
	  //  First request	  
	  requestUrl="http://localhost:8080/getPerson1";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Person.class;
	  requestBody=new Person();
	  ((Person)requestBody).setName("postDummyName1");
	  Request request1=new PostRequest(requestUrl,headers, requestBody, responseClass);
	  
	  // Second request
	  requestUrl="http://localhost:8080/getPerson2";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Person.class;
	  requestBody=new Person();
	  ((Person)requestBody).setName("postDummyName2");
	  Request request2=new GetRequest(requestUrl,headers, responseClass);
	  
	  // Third request 
	  requestUrl="http://localhost:8080/getPerson3";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Person.class;
	  requestBody=new Person();
	  ((Person)requestBody).setName("postDummyName3");
	  Request request3=new PostRequest(requestUrl, headers, requestBody, responseClass);
	  
	  
	  List<Request> requests=new ArrayList<Request>();
	  requests.add(request1);
	  requests.add(request2);
	  requests.add(request3);
	  
	  
	  List<Object> responses=(List<Object>)restClient.getData(requests);
	  assertEquals(responses.size(), 3);
	  assertEquals(((Person)responses.get(0)).getId(), 1);
	  assertEquals(((Person)responses.get(1)).getId(), 2);
	  assertEquals(((Person)responses.get(2)).getId(), 3);
	}
	
	
	@AfterClass
	public static void finalization(){
		mockServer.stop();
		restClient.close();
	}
	

}
