# Spring Boot Web Application - Syndication/Participation
This repository has UI code in thymleaf to connect to local instance of blockchain
running on docker container


start docker which has exited :
docker start $(docker ps -a -q --filter "status=exited")

login to peer node :
docker exec -it dockercompose_vp_1 bash


