# Data Health As Service Using Graph DB

In this blog I will explore design/implementation of "**Health Of The Data**" and let's call it, "**_Data Health As Service_**".

## Modern Data Platform Architecture
The below picture shows Modern Data Platform architecture:

![alt text](DataArchitecture.png)

## Context
The prime goal of data in data platform is to enable data driven decision using reports. The quality of the reports build using data, at broad level dependent on:
- Quality of data
- Timeliness of data
- Data lineage
- ...

Since quality of the data depends on various factors, I would like to propose a service/component in the design called _**"Data Health As Service"**_. This service will derive the health of the data from following key components:
- Data Quality as service
- ETL pipeline metadata service (pipeline context metadata)
- ...
Hence in nut shell, "Data Health As Service" will provide "Index Of Readiness" of data.

But a million dollar question, how can derive "data health sense", from the metadata.

## Data Health Using Graph DB

Graph databases are power in deducing connection between data (no matter what type data). Hence, I would like to propose the usage of graph database to derive health of the data. _How would the graph model look like, to develop such a service?_

## Data Health Graph Model

The following diagram shows the design of graph model for data health deduciton:

![alt text](data-health-graph-model.png)

## Data Health Output
The graph db output looks like below:

![alt text](datahealth-graph-output.png)

## How to Run?
Data As Service is build using:
- Java 14
- Spring Boot 2.3.3
- Neo4j
- Spring data neo4j

Below are steps to run this service:
- Run neo4j docker
- Run the DataHealthServiceApplicaiton

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data Neo4j](https://spring.io/projects/spring-data-neo4j)


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

