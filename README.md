# Tabeo QA UI automation project #

## Versions

Maven version: Apache Maven 3.6.3

Java version: 1.11

## Get the code

Git:

    git clone 
    cd 

## Use Maven to run tests
<!--Gradle will be added a bit later-->

To run all automated features locally in desktop web:

    mvn clean verify -Dcucumber.options="--tags @automated"

To run single feature (as example Search feature):

    mvn clean verify -Dtest.include=SignInFeature
or 

    mvn clean verify -Dcucumber.options="--tags @sign_in"

## Viewing the reports

This will produce a Serenity test report in the `target/site/serenity` directory (open `index.html`)

## Test cases placed in the :

src/test/resources/features

## Start Selenoid Grid (if you want to use it)
docker pull aerokube/selenoid:latest-release  
docker pull selenoid/chrome
docker pull aerokube/selenoid-ui

docker run -d --name selenoid -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v {ENTER_HERE_PATH_TO_PROJECT}/src/main/resources/selenoid/config/:/etc/selenoid/:ro aerokube/selenoid:latest-release
docker run --name selenoid-ui --link selenoid -p 8080:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444

open Selenoid ui
http://localhost:8080/#/

for run test you need to override property in maven command
mvn clean verify -Dcucumber.options="--tags @automated" -Dwebdriver.provided.type=selenoid_chrome