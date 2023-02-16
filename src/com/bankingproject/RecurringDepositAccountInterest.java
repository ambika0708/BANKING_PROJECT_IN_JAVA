package com.bankingproject;

import java.sql.*;
import java.util.Scanner;

public class RecurringDepositAccountInterest {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/javabankwork";
        String username = "root";
        String password = "@ambikasurya07";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            sqlException.getMessage();
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static void recurringDepositAccount() throws SQLException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your account number");
            int accountNumber = in.nextInt();
            String sql = "select * from accountDetails where accNumber='" + accountNumber + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                double interestRate;
                double interestAmount;
                double AccountBalance = rs.getLong("accBalance");
                System.out.println("Enter the Number of Months ( 6 or 9 or 12 or 15 or 18 or 21 )");
                int noOfMonths = in.nextInt();
                System.out.println("Please Enter your age ");
                int age = in.nextInt();
                if (AccountBalance <= 0.0) {
                    System.out.println("Invalid Recurring Deposit amount ...");
                } else {
                    if (noOfMonths == 6) {
                        if (age <= 55) {
                            interestRate = 7.0;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 7.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }else if(noOfMonths==9){
                        if (age <= 55) {
                            interestRate = 7.75;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 8.25;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }else if(noOfMonths==12){
                        if (age <= 55) {
                            interestRate = 8.0;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 8.5;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }
                    else if(noOfMonths==15){
                        if (age <= 55) {
                            interestRate = 8.25;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 8.75;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }
                    else if(noOfMonths==18){
                        if (age <= 55) {
                            interestRate = 8.5;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 9.0;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }
                    else if(noOfMonths==21){
                        if (age <= 55) {
                            interestRate = 8.75;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        } else {
                            interestRate = 9.00;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is : " + interestAmount);
                        }
                    }
                    else{
                        System.out.println("Please Provide Valid Months ");
                    }
                }
            } else {
                System.out.println("Account Number " + accountNumber + " is Not Found ... !! Please Register your Account ");
            }
            System.out.println();
            statement.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
