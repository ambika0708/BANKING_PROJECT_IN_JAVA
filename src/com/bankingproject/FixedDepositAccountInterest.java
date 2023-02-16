package com.bankingproject;

import java.sql.*;
import java.util.Scanner;

public class FixedDepositAccountInterest {
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

    public void fixedDepositInterest() throws SQLException {
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
                System.out.println("Please Enter your age ");
                int age = in.nextInt();
                System.out.println("Enter the Number of Days ");
                int noOfDays = in.nextInt();
                if (AccountBalance < 1000000) {
                    if (noOfDays >= 7 && noOfDays <= 14) {
                        if (age <= 60) {
                            interestRate = 4.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 5.0;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        }
                    } else if (noOfDays >= 15 && noOfDays <= 29) {
                        if (age <= 60) {
                            interestRate = 4.75;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 5.25;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);

                        }
                    } else if (noOfDays >= 30 && noOfDays <= 45) {
                        if (age <= 60) {
                            interestRate = 5.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 6.00;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        }
                    } else if (noOfDays >= 46 && noOfDays <= 60) {
                        if (age <= 60) {
                            interestRate = 6.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 7.00;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        }
                    } else if (noOfDays >= 61 && noOfDays <= 184) {
                        if (age <= 60) {
                            interestRate = 7.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 8.00;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        }
                    } else if (noOfDays >= 185 && noOfDays <= 365) {
                        if (age <= 60) {
                            interestRate = 8.00;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        } else {
                            interestRate = 8.50;
                            interestAmount = (AccountBalance * interestRate) / 100;
                            System.out.println("Interest Gained is " + interestAmount);
                        }
                    } else {
                        System.out.println("Please Provide Valid days ( FROM 1 - 365 DAYS )");
                }}
                else{
                    if(noOfDays>=7 && noOfDays<=14){
                        interestRate=6.75;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }
                    else if(noOfDays>=15 && noOfDays<=29){
                        interestRate=7.00;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }
                    else if(noOfDays>=30 && noOfDays<=45){
                        interestRate=7.50;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }
                    else if(noOfDays>=46 && noOfDays<=60){
                        interestRate=8.00;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }
                    else if(noOfDays>=61 && noOfDays<=184){
                        interestRate=8.50;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }
                    else if(noOfDays>=185 && noOfDays<=365){
                        interestRate=10.00;
                        interestAmount= (AccountBalance * interestRate) / 100;
                        System.out.println("Interest Gained is " + interestAmount);
                    }else{
                        System.out.println("Please Provide Valid days ( FROM 1 - 365 DAYS )");
                    }
            }

        } else{
            System.out.println("Account Number " + accountNumber + " is Not Found ... !! Please Register your Account ");
        }
        System.out.println();
        statement.close();
    } catch(
    SQLException throwables)

    {
        throwables.printStackTrace();
    }
}
}
