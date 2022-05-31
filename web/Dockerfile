#FROM tomcat:8.5.50
#
#
#RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml
#
#CMD ["catalina.sh", "run"]

FROM ubuntu: latest
RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml
RUN mkdir /opt/tomcat/
WORKDIR /opt/tomcat/
RUN apt-get update && apt-get install -y curl
RUN curl -O https://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.50/bin/apache-tomcat-8.5.50.tar.gz
RUN tar -xvzf apache-tomcat-8.5.50.tar.gz
RUN mv apache-tomcat-8.5.50/* /opt/tomcat/.
WORKDIR /opt/docker-tomcat/tomcat/webapps
CMD ["/opt/tomcat/bin/catalina.sh", "run"]