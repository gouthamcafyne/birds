# birds - Respository setup and project run

A. Git Hub Link:

	https://github.com/gouthamcafyne/birds

B. Tools Required

	1. Maven
	2. Tomcat
	3. Git CUI/GUI interface
	4. MongoDB
	5. Eclipse (Optional)

B.1
	1. clone this project from the github link - https://github.com/gouthamcafyne/birds.git
	
C.1 Setup - Without Using Eclipse

	1. Go to codebase-parent folder in the clone create in #B.1 - Step #1
	2. Give MongoDB credentials in codebase-parent\webapp\src\main\resources\mongodb.properties and  			   E:\Project\codebase\saltside\birds\codebase-parent\webapp\src\test\resources

		Example:
			app.mongodb.host=127.0.0.1
			app.mongodb.database=saltside
			app.mongodb.username=test
			app.mongodb.password=s@lt

	3. mvn clean install
		a. This will create the jars as well as war
		b. Check if all the test cases are passed
	4. If passed go to webapp/target folder - you'll find birds-webapp.war
	5. Deploy it in tomcat

C.2 Setup - With Eclipse and Maven

	1. Import codebase-parent project into eclipse as Import -> Maven Project
	2. Right click codebase-parent Maven Build -> Goals are clean install
	3. You'll see the project gets build
	4. Deploy webapp in tomcat

D. Accessing the APIs

	Get Birds - http://localhost:8080/birds-webapp/rest/bird/birds
	Get Bird - http://localhost:8080/birds-webapp/rest/bird/birds/57d69a43e1e416ced2e44b37
	Post Bird - http://localhost:8080/birds-webapp/rest/bird/birds
				Body: {
						"id":"sadfd1212",
						"name":"parrot",
						"family":"cute",
						"continent":["india"]
					  }
	Delete Bird - http://localhost:8080/birds-webapp/rest/bird/birds/57d69cf2e1e419c330bb9862

	For all these include content-type as application/json in the Header for API request

