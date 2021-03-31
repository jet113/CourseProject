FROM openjdk:7
COPY . /root/course-project
WORKDIR /root/course-project
RUN javac gui.java
CMD ["java", "gui"]