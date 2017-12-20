# EasyRestfulClient
It is java library developed on top of Apache HTTP library and JDK executor framework. It has capability to execute multiple restful requests concurrently in very easy way. 

## Features

1. Supports HTTP GET and POST methods.
2. Concurrent execution of requests.
3. Auto conversion request and response to JSON and XML formats.
4. Easy Request creation.

## How to use 

### Add Repository to project POM.xml

```xml
	
	<repositories>
		<repository>
          <id>EasyRestFulclientRepository</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases>
            <enabled>true</enabled>
          </releases>
     </repository>
     ...
  </repositories>
    
```
  
### Add Dependency in POM.xml
  
``` xml

	<dependency>
		<groupId>com.gsssoftwaresolution.java.utility.restfulservices</groupId>
		<artifactId>easyrestfulclient</artifactId>
		<version>1.0.0</version>
	</dependency>
	
```

### Create RestClientManager Object

```java

	RestClientManager restClient=new RestClientManager(3);

```

### Create Request 

Depending upon Content_type header value, library converts request java object to either json or xml.
Likewise upon Accept header value, library build response either from json or xml response.

#### GET  

```java
      
     Map<String,String> headers=new HashMap<>();
     String requestUrl="http://localhost:8080/getTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Response.class;
	  requestBody=null;
	  String httpMethod=Constant.GET_METHOD;
	  Request request=new GetRequest(requestUrl,headers, responseClass);

```

#### POST 

```java
      
     Map<String,String> headers=new HashMap<>();
     String requestUrl="http://localhost:8080/getTestPage";
	  headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	  headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	  responseClass=Response.class;
	  requestBody=new RequestBody();
	  String httpMethod=Constant.GET_METHOD;
	  Request request=new PostRequest(requestUrl,headers, responseClass);

```

### Make Request and Collect Response

```java

	Response response=(Response)restClient.getData(request);


```



