#makefile
APPLICATION_NAME := petshop-message-api
PORT := 5003
PROFILE := docker

maven-handler:
	mvn -version
	mvn clean
	mvn package

docker-compose-up: docker-compose-down maven-handler
	docker-compose up

docker-compose-down:
	docker-compose down -v

docker-compose-docker-up: # maven-handler # docker-compose-down
	docker-compose -f compose.yaml down -v
	docker-compose -f compose.yaml up

build-docker:
	docker build --build-arg SPRING_PROFILES_ACTIVE=$(PROFILE) -f Dockerfile -t $(APPLICATION_NAME):latest .
	#docker build --build-arg SPRING_PROFILES_ACTIVE=$(PROFILE) -f Dockerfile -t $(APPLICATION_NAME):$(shell echo $(shell mvn help:evaluate -Dexpression=project.version -q -DforceStdout) | perl -pe 's/-SNAPSHOT//') .

run-build-docker: build-docker
	docker run -e SPRING_PROFILE=$(PROFILE) -p $(PORT):$(PORT) -t $(APPLICATION_NAME):latest

run-docker: # maven-handler
	docker run -e SPRING_PROFILE=$(PROFILE) -p $(PORT):$(PORT) -t $(APPLICATION_NAME):latest