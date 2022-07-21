FROM alpine
RUN apk add openjdk8 
#ENV PATH=$PATH:/usr/lib/jvm/java-1.8-openjdk/bin

RUN apk add curl jq

WORKDIR /tests

ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD src/test/resources/testng-tour.xml testng-tour.xml
ADD src/test/resources/testng-duck.xml testng-duck.xml

ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh