#!/bin/sh
mvn clean package && docker build -t vs/jpa .
docker rm -f jpa || true && docker run -d -p 8080:8080 -p 4848:4848 --name jpa vs/jpa 
