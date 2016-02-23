System Requirements:
-------------------
Java Version : 1.7
Maven : 3.2.3
MYSQL server : 5.6 
Tomcat Server Version : 7


Following are the configuration changes:
----------------------------------------
1. Create the database with following details on Mysql server.
Database Name ="OUA" (schema name)
User = "root"
password = "System@123" (Preferable - to run quickly, otherwise can have own db setup)

2. If Mysql database is running locally and on port '3306' with above details, no changes are required for properties files.

If any change in database, modify accordingly in below properties files:
a. oua-web\src\main\resources\application.properties 
b. oua-data\src\test\resources\db.properties
c. oua-service\src\test\resources\db.properties 

3. Go to command prompt where parent pom file exists. 

4. Run the below Maven commands where parent pom is exists.

-- run clean 
command> mvn clean

-- run install
command> mvn install 

5. Copy the war file into Tomcat/webapps server and start the tomcat.
(As time constraint, not added to the build file - pending)

6. open this url:http://localhost:8080/TODOManager in browser to see the application
 
