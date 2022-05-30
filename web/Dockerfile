FROM tomcat:8.0-alpine
RUN apt-get -y install maven

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml

CMD ["catalina.sh", "run"]