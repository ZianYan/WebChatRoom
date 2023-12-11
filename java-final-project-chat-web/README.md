Java Final Project: Online Web Chat Room

How to run:
	1. Open the project in a Java IDE
	2. Run the Spring Boot application
	3. Go to the brower and use URL: http://localhost:8080/
	4. Follow the GUI to sign up and login
	5. Aftering logging in, you can start chatting in the chat room
	6. You can open multiple web pages to let multiple users chat simultaneously

Advanced concepts included:
	1. Spring Boot: This project is based on the Spring Boot framework
	2. GUI: Create web pages using html, css, and JavaScript
	3. Database: Use the H2 database for storing the user's login information. Database is set to in memory mode, can also switch to local mode by setting the "application.properties" file
	4. Network: Use WebSocket for the communication between the front-end users and backend server, supporting multi-user chat.
	5. JPA/Entity: Coded 'User' as entity, using JPA to interact with database.


References:
	https://www.youtube.com/watch?v=msj3kLOLC4Q
	https://github.com/Java-Techie-jt/Spring-Boot-WebSocket