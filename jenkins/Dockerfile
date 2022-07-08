FROM jenkins/jenkins
USER root
RUN mkdir -p /tmp/download && \
    curl -L https://download.docker.com/linux/static/stable/x86_64/docker-18.03.1-ce.tgz --output docker-18.03.1-ce.tgz | tar -xz docker-18.03.1-ce.tgz -C /tmp/download
#    && \
#    rm -rf /tmp/download/docker/dockerd && \
#    mv /tmp/download/docker/docker* /usr/local/bin/ && \
#    rm -rf /tmp/download && \
#    groupadd -g 995 docker && \
#    usermod -aG staff,docker jenkins


#RUN apt-get update
#RUN apt-get install -y maven
#RUN apt-get install -y net-tools
#
#RUN apt-get install -y python3-pip
## Install app dependencies
#RUN pip install --upgrade pip
##RUN pip install ansible --upgrade
#USER jenkins