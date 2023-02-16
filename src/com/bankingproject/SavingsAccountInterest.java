package com.bankingproject;

import java.sql.*;
import java.util.Scanner;

public class SavingsAccountInterest {
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

    public static void main(String[] args) {

    }
    public static void savingsInterest() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Interest Rate");
        double interestRate = in.nextDouble();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            Scanner inTwo = new Scanner(System.in);
            System.out.println("Enter your account number");
            int accountNumber = in.nextInt();
            String sql = "select * from accountDetails where accNumber='" + accountNumber + "'";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                double AccountBalance = rs.getLong("accBalance");
                double interestAmount = (interestRate / 100) * AccountBalance;
                double totalAmount =(AccountBalance + interestAmount);
                System.out.println("Interest amount " + interestAmount + " is added Successfully to your Bank, Your Current Balance is = " + totalAmount);
                statement.execute("update accountDetails set accBalance =" + totalAmount + "" +
                        " where accNumber=" + accountNumber);
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
