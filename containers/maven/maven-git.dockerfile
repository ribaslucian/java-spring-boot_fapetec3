FROM openjdk:11

# Remove Nginx from base image.
# RUN kill -9 $(sudo lsof -t -i:8080)
# RUN apt install systemd
# RUN /etc/init.d/nginx stop
# RUN apt purge nginx
# RUN apt remove nginx

# Install the Maven.
ARG MAVEN_VERSION=3.8.6
ARG USER_HOME_DIR="/root"
ARG SHA=f790857f3b1f90ae8d16281f902c689e4f136ebe584aba45e4b1fa66c80cba826d3e0e52fdd04ed44b4c66f6d3fe3584a057c26dfcac544a60b301e6d0f91c26
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA} /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# # Install the Git.
# RUN apt-get update
# RUN apt-get -y install git

# # Get the application from GitHub.
# WORKDIR /usr/src/
# RUN git clone https://github.com/ribaslucian/spring-boot-fapetec3.git
# WORKDIR /usr/src/spring-boot-fapetec3

# # Update and run application.
# RUN mvn clean install
# RUN mvn spring-boot:run