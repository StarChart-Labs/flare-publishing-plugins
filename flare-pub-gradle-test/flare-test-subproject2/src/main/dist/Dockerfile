FROM java:openjdk-8-jre-alpine
MAINTAINER Ryan OMeara <romeara@live.com>

RUN apk update
RUN apk add --no-cache bash

RUN mkdir -p /opt/test

COPY start.sh /opt/test/bin/start.sh
COPY libs/ /opt/test/libs

WORKDIR /opt/test
ENTRYPOINT [ "/bin/sh", "/opt/test/bin/start.sh"]
