FROM eclipse-temurin:17-alpine

RUN /mkdir "miu"

COPY build/libs/Miu-*.jar /usr/local/lib/Miu.jar

WORKDIR /miu

ENTRYPOINT ["java", "-Xms2G", "-Xmx2G", "-XX:+DisableExplicitGC", "-jar", "/usr/local/lib/Miu.jar"]