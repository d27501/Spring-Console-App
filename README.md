# Spring-Console-App

It's a simple Spring console app in which you can register new user or log into existing account. 

Users' data are stored in the H2 database. Passwords are encrypted using MD5 algrithm.
All database operations are carried out with use of Spring Data JPA.

Non-logged user can be registered by typing in username, password, email and phone number. Password can be autogenerated.
Logged user can change their email or phone number.
Username should contain at least 3 characters and be unique.
Password should contain at least 8 characters including 1 capital letter, 1 number and 1 special character. List of supported special characters: @#$%^&+=
There is also an option to show all users currently stored in the database.

In this project you can find also some unit tests. Domain class User.java and utilities like password generator, encryptor and users' data validator were tested.

You can easily run this project by running main() method from MyApp.java class.
