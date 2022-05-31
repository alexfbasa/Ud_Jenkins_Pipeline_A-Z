FROM tomcat:8.5.79-jdk8

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml

EXPOSE 8080

CMD ["catalina.sh", "run"]
