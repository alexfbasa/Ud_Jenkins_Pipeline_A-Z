FROM 8.5.50-jdk11-openjdk

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml

CMD ["catalina.sh", "run"]