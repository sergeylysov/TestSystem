FROM openjdk:18.0.2.1-jdk-oraclelinux7
RUN yum install unzip -y
RUN yum install wget -y
RUN wget -O glassfish.zip  https://www.eclipse.org/downloads/download.php?file=/ee4j/glassfish/glassfish-6.2.5.zip&&unzip glassfish.zip

ENV WILDFLY_PASSWORD=12345678
ADD ./target/TestSystem-1.1.war /glassfish6/glassfish/domains/domain1/autodeploy/
ENTRYPOINT ["sh","./glassfish6/glassfish/bin/startserv"]
