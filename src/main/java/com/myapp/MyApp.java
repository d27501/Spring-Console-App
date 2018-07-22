package com.myapp;

import com.myapp.domain.User;
import com.myapp.service.UserService;
import com.myapp.util.PasswordEncryptor;
import com.myapp.util.PasswordGenerator;
import com.myapp.util.UserValidator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyApp
{
    private static MyApp myApp;
    private static UserService userService;
    private static Scanner reader;
    private static User user;
    private static int option;


    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

        myApp = (MyApp)context.getBean("myApp");
        userService = (UserService) context.getBean("userServiceImpl");
        reader = new Scanner(System.in);

        while(true){
            if (user != null) {
                System.out.println("\n1 - Zmiana adresu email \n2 - Zmiana numeru telefonu \n3 - Wyloguj się");
                option = reader.nextInt();
                switch (option){
                    case 1: myApp.changeEmail();
                        break;
                    case 2: myApp.changePhoneNumber();
                        break;
                    case 3: user = null;
                        break;
                }
            } else {
                System.out.println("Witamy. \n1 - Rejestracja \n2 - Logowanie \n3 - Wyjście \n4 - Pobierz wszystkich użytkowników");
                option = reader.nextInt();
                switch (option){
                    case 1: myApp.register();
                        break;
                    case 2: myApp.login();
                        break;
                    case 3: context.close();
                            System.exit(0);
                    case 4: myApp.getAllUsers();
                        break;
                }
            }

        }

    }

    public static void getAllUsers() {

        for (User tmp : userService.getAllUsers()) {
            System.out.println(tmp.toString());
        }
    }

    public static void changeEmail() {

        System.out.println("Podaj nowy adres mailowy: ");
        String email = reader.next();
        userService.changeEmailAddress(email, user.getUserId());
        System.out.println("Zmieniono adres mailowy.");
    }

    public static void changePhoneNumber() {

        System.out.println("Podaj nowy numer telefonu: ");
        String phoneNumber = reader.next();
        userService.changePhoneNumber(phoneNumber, user.getUserId());
        System.out.println("Zmieniono numer telefonu.");
    }

    public static void login() {

        System.out.println("Podaj nazwę użytkownika: ");
        String username = reader.next();
        System.out.println("Podaj hasło: ");
        String password = reader.next();

        user = userService.getUserByUserName(username);
        if(user != null) {
            if(user.getPassword().equals(PasswordEncryptor.crypt(password))){
                System.out.println("Zalogowano użytkownika.");
            } else {
                System.out.println("Błędne hasło.");
                user = null;
            }
        } else {
            System.out.println("Nie ma takiego użytkownika.");
            user = null;
        }
    }

    public static void register() {

        System.out.println("Podaj nazwę użytkownika: ");
        String username = reader.next();

        System.out.println("Czy wygenerować losowe hasło? \n1 - Tak \n2 - Nie");
        String password;
        if(reader.nextInt() != 1) {
            System.out.println("Podaj hasło: ");
            password = reader.next();
        } else {
            password = PasswordGenerator.generatePassword();
            System.out.println("Wygenerowane hasło to:\n" + password);
        }

        System.out.println("Podaj email: ");
        String email = reader.next();
        System.out.println("Podaj nr telefonu: ");
        String phoneNumber = reader.next();

        if (UserValidator.validateUserName(username, userService)) {
            if (UserValidator.validatePassword(password)) {
                User user = new User();
                user.setUserName(username);
                user.setPassword(PasswordEncryptor.crypt(password));
                user.setUserEmail(email);
                user.setPhoneNumber(phoneNumber);
                userService.addUser(user);
                System.out.println("Użytkownik zarejestrowany.");
            } else {
                System.out.println("Hasło nie spełnia wymagań.");
            }
        } else {
            System.out.println("Nazwa użytkownika już zajęta bądź nie spełnia wymagań.");
        }
    }
}
