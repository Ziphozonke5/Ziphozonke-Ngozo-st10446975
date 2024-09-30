/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author RC_Student_lab
 */
public class login {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}



public class login {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    // Constructor for setting user details during registration
    public login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if the username contains an underscore and is no more than 5 characters long
    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            this.storedUsername = username; // Save username for login
            return true;
        }
        return false;
    }

    // Method to check password complexity rules: at least 8 chars, 1 capital, 1 number, 1 special character
    public boolean checkPasswordComplexity(String password) {
        if (password.length() >= 8) {
            Pattern capitalLetterPattern = Pattern.compile("[A-Z]");
            Pattern numberPattern = Pattern.compile("[0-9]");
            Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

            Matcher hasCapitalLetter = capitalLetterPattern.matcher(password);
            Matcher hasNumber = numberPattern.matcher(password);
            Matcher hasSpecialCharacter = specialCharacterPattern.matcher(password);

            if (hasCapitalLetter.find() && hasNumber.find() && hasSpecialCharacter.find()) {
                this.storedPassword = password; // Save password for login
                return true;
            }
        }
        return false;
    }

    // Method to register user and return appropriate messages
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "User successfully registered";
    }

    // Method to verify login details
    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    // Method to return login status message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }

    // Main method with Scanner for user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for first name and last name
        System.out.println("Please enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();

        // Create a Login object with first name and last name
        Login login = new Login(firstName, lastName);

        // Registration process
        System.out.println("Registration:");
        System.out.println("Please enter a username (must contain an underscore and no more than 5 characters):");
        String username = scanner.nextLine();

        System.out.println("Please enter a password (must contain at least 8 characters, a capital letter, a number, and a special character):");
        String password = scanner.nextLine();

        // Display registration status
        System.out.println(login.registerUser(username, password));

        // Proceed to login only if registration is successful
        if (login.registerUser(username, password).equals("User successfully registered")) {
            // Login process
            System.out.println("\nLogin:");
            System.out.println("Please enter your username:");
            String loginUsername = scanner.nextLine();

            System.out.println("Please enter your password:");
            String loginPassword = scanner.nextLine();

            // Display login status
            System.out.println(login.returnLoginStatus(loginUsername, loginPassword));
        }

        scanner.close();
    }
}