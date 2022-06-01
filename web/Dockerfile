FROM tomcat:8.5.79-jdk8

RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml
RUN ln -s /usr/local/tomcat/webapps.dist/manager webapps/manager
RUN ln -s /usr/local/tomcat/webapps.dist/host-manager webapps/host-manager
RUN ln -s /usr/local/tomcat/webapps.dist/ROOT webapps/ROOT
CMD ["catalina.sh", "run"]
