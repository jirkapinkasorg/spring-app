
# Build:

    mvn clean package
    docker build -t spring-app:latest .
    docker run --rm -it -p 8080:8080 spring-app:latest
    docker tag spring-app:latest localhost:30500/spring-app:latest
    docker push localhost:30500/spring-app:latest
    docker tag spring-app:latest localhost:30500/spring-app:1.0.1
    docker push localhost:30500/spring-app:1.0.1 
    docker run --rm -it -p 8080:8080 localhost:30500/spring-app:1.0.1

# Hazelcast specific startup config:

    --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED
