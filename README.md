# TX Services Code Challenge

### Added features:
- [x] Created Spring Boot application
- [x] Created database model based on polls provides in assets
- [x] Created REST api for necessary features
- [x] Created services, implementation and repository for getting necessary data from database
- [x] Using MongoDB because it is fastest for POC type of applications because it can be used without fixed schema
- [x] Use Swagger 2 for api documentation
- [x] Added example for Unit Tests
- [x] Added example for Integration Tests
- [x] Starting application on local environment via docker-compose
- [x] Using mongoimport for initialisation of database on docker env ( polls.json)
- [x] Using embedded database for Integration testing
- [x] Added indexes on database level for used fields
- [x] Use logging setup from log4j2
- [x] Setup .gitignore file

### Nice to have features:
- [ ] Add more tests on all levels
- [ ] Add more validations 
- [ ] Improve exception handling
- [ ] Better understanding of business logic and rewrite database scheme
- [ ] Use hexagonal architecture ( ports and adapters )
- [ ] Add acceptance testing ( used to verify is service started with proper setup on some real env)
- [ ] Create multiple services/ database schemas to achieve better isolation if using microservices 
- [ ] Add static code checks ( find bugs, check style...)
- [ ] Setup some CI/CD 
- [ ] Microservices env should have: api gateway, eureka, cloud config, vault...
- [ ] Add Liquibase for database or some alternative
- [ ] Integrate with Splunk or some alternative
- [ ] Integrate with NewRelic or some alternative
- [ ] Create some performances tests for most important cases and add them into CI/ CD process ( jmeter or some alternative ) 

## API documentation 
Access http://localhost:8080/swagger-ui.html to check the documentation.

## Build and run application
```
cd tx-services-challenge

mvn clean install

docker-compose up --build
```
