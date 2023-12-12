FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="dormitory_room"
LABEL org.opencontainers.image.authors="Artur Śpiewak"
LABEL org.opencontainers.image.source="https://github.com/ArturLog/JavaCourse/tree/docker"
LABEL org.opencontainers.image.url="https://github.com/ArturLog/JavaCourse"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.description="Student's dormitory"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-profession
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV DORMITORY_ROOM_URL=http://localhost:8082

EXPOSE 8080

COPY target/dormitory_room-${VERSION}.jar /opt/dormitory_room/dormitory_room.jar

CMD ["java", "-jar", "/opt/dormitory_room/dormitory_room.jar"]
