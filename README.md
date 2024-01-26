## Installing Elasticsearch and Kibana with Docker Compose - Spring Boot 3

Elasticsearch is a robust search and analytics engine with powerful capabilities for indexing, querying, and analyzing data. 

Kibana, an open-source tool, complements Elasticsearch by offering a platform to visualize and comprehend data stored within Elasticsearch.

👉 [For more information, you can check out my blog post.](https://ayseozcan.com/2024/01/17/elasticsearch-and-kibana-with-docker-compose-spring-boot-example/)

### Dependencies
```
dependencies {  
    implementation 'org.springframework.boot:spring-boot-starter-web'  
    testImplementation 'org.springframework.boot:spring-boot-starter-test'  
    implementation 'org.springframework.boot:spring-boot-starter-data-elasticsearch:3.2.1'  
    compileOnly 'org.projectlombok:lombok'  
    annotationProcessor 'org.projectlombok:lombok'  
}
```
### docker-compose.yaml

```yaml
version: '3'  
  
services:  
  elasticsearch:  
    container_name: elasticsearch  
    image: docker.elastic.co/elasticsearch/elasticsearch:8.10.4  
    environment:  
      - CLI_JAVA_OPTS=-Xms2g -Xmx2g  
      - bootstrap.memory_lock=true  
      - discovery.type=single-node  
      - xpack.security.enabled=false  
      - xpack.security.enrollment.enabled=false  
    ports:  
      - 9200:9200  
    networks:  
      - elastic  
    deploy:  
      resources:  
        limits:  
          cpus: '2.0'  
        reservations:  
          cpus: '1.0'  
  
  kibana:  
    image: docker.elastic.co/kibana/kibana:8.10.4  
    container_name: kibana  
    environment:  
      XPACK_ENCRYPTEDSAVEDOBJECTS_ENCRYPTIONKEY: ${ENCRYPTION_KEY}  
    ports:  
      - 5601:5601  
    networks:  
      - elastic  
    deploy:  
      resources:  
        limits:  
          cpus: '2.0'  
        reservations:  
          cpus: '1.0'  
  
networks:  
  elastic:  
    driver: bridge
```
`container_name:` The name of the Elasticsearch and Kibana container.

`image:` The Docker image to be used for Elasticsearch and Kibana with version 8.10.4.

`environment:` Sets environment variables for Elasticsearch and Kibana

`ports:` Maps the Elasticsearch service’s port 9200 , Kibana service’s port 5601 from the container to the host.

`networks:` Connects the container to the custom network named elastic.

`deploy:` Specifies deployment-related configurations, such as CPU limits(maximum) and reservations(minimum).

### Getting started
Clone the project.
```
https://github.com/ayse-ozcan/elasticsearch-kibana-docker-compose.git
```
This command below reads the docker-compose.yaml file, creates and starts Docker containers based on the defined services and configurations.
```
docker-compose up
```
Run project.


