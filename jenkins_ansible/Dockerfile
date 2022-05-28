FROM jenkins/jenkins
USER root
RUN apt-get update
RUN apt-get install -y python3-pip
# Install app dependencies
RUN pip install --upgrade pip
RUN apt-get -y install maven
#RUN pip install ansible --upgrade
USER jenkins