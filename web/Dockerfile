FROM tomcat:9.0-alpine

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml
EXPOSE 8080

CMD ["catalina.sh", "run"]