FROM       tomcat
MAINTAINER yb.choi@myatman.com

ENV        SPRING_PROFILES_ACTIVE="test"

WORKDIR    /usr/local/tomcat

RUN        apt-get -yqq update && \
           rm -rf ./webapps/* && \
		   ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

COPY       ROOT.war ./webapps

EXPOSE     8080
CMD        ["catalina.sh", "run"]