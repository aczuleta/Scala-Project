# Scala-Project Functional Programming
This is the repository to store the project for the Functional programming course.

# Prerequisites
-Scala
-Java
-Git
-NPM
-SBT

# How To Run
Download the repository with git clone https://github.com/aczuleta/Scala-Project.git

## Task 1
Go to task1/src firectory
Just open the .sc file on IntelliJ and run it as a usual Scala Worksheet file

## Task 2

### Server
Go to back/world-cup-system directory and run sbt run
The serve is going to run at localhost port 5100

### Front
Go to front/players-app and run NPM install
After that run ng serve --open
the frontend is going to run at port 4200 on the localhost


## Testing
For testing purposes you can run the following paths in the api:
GET - http:localhost:5100/teams
returns all the teams with their average score

PUT - http:localhost:5100/teams
Parameters example:
{
        "id": 121,
        "score": 90
}
Requires a player id and a new score to be updated.

GET - GET - http:localhost:5100/teams/{{team_name}}
Given the name of a team it returns all its players

A postman's file containing all the url's for testing can be found here:
Postman's File: https://www.getpostman.com/collections/d6713e559eda0e85d850

## Deployment
An we deployment of this project can be found at the following url:
Web Deployment: http://scala-project-bucket.s3-website-us-west-2.amazonaws.com/
