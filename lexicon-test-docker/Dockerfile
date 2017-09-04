FROM cgoncas/slim-liferay-portal-image:20170904134548
MAINTAINER Ruben Pulido <ruben.pulido@liferay.com>

COPY *.?ar $LIFERAY_HOME/osgi/modules/

USER root

RUN chown -R liferay:liferay $LIFERAY_HOME
