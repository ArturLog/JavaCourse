FROM nginx:1.23.3


LABEL org.opencontainers.image.title="dormitory_angular"
LABEL org.opencontainers.image.authors="Artur Śpiewak"
LABEL org.opencontainers.image.source="https://github.com/ArturLog/JavaCourse/tree/docker"
LABEL org.opencontainers.image.url="https://github.com/ArturLog/JavaCourse"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.description="Student's dormitory"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/simple-rpg-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
