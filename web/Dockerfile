FROM tomcat:8.0-alpine

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml

COPY tomcat-user.xml /usr/local/tomcat/conf/

CMD ["catalina.sh", "run"]