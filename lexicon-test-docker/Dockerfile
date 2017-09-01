FROM liferay/portal:7.0.3-ga4-tomcat
MAINTAINER Ruben Pulido <ruben.pulido@liferay.com>

COPY *.?ar $LIFERAY_HOME/osgi/modules/

USER root

RUN chown -R liferay:liferay $LIFERAY_HOME
