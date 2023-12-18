Java Final Project: Online Web Chat Room

How to run:
	1. Open the project in a Java IDE 
 	2. Run the Spring Boot application
	3. A Java Swing page will pop out, then select the button you need
	4. Follow the GUI to sign up and login
	5. Aftering logging in, you can start chatting in the chat room
	6. You can open multiple web pages to let multiple users chat simultaneously

Advanced concepts included:
	1. Spring Boot: This project is based on the Spring Boot framework
	2. Java GUI: An web app starter is built by Java Swing
	3. Database/JDBC: Directly use JDBC to create table and query. Use the H2 database for storing the user's login information. Database is set to in memory mode, can also switch to local mode by setting the "application.properties" file.
	4. Network: Use WebSocket for the communication between the front-end users and backend server, supporting multi-user chat.
	5. JPA/Entity: Coded 'User' and "ChatMessage"as entity, using JPA to interact with database.

Update:
	1. Added the "Show history" function
	2. Added Java Swing starter
	3. Rewrite the database logic by using JDBC directly
	
References:
	https://www.youtube.com/watch?v=msj3kLOLC4Q
	https://github.com/Java-Techie-jt/Spring-Boot-WebSocket
