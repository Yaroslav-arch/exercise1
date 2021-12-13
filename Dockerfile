FROM openjdk:11.0.13-slim
COPY build/libs/exercise1-0.0.1-SNAPSHOT.jar exc1.jar
ENTRYPOINT ["echo", "excercise1"]