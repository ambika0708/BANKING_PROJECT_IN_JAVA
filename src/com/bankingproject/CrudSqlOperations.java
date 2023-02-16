package com.bankingproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudSqlOperations {

    public static void loadDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

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

    public static void createCustomerDetails(BankCustomerDetails details) throws SQLException {
        Connection connection = getConnection();
        Statement state = connection.createStatement();
        state.executeUpdate("insert into customerDetails(customerId,customerName,phoneNumber,aadharId) " +
                "values (" + details.getcustomerId() + ",'" + details.getcustomerName() + "','" + details.getphoneNumber() + "','" + details.getaadharId() + "')");
        System.out.println("Successfully Inserted Customer Details : " +"Id: "+ details.getcustomerId() + " | " +"Name: "+ details.getcustomerName() + " | " +"Ph.No: "+ details.getphoneNumber() + " | " +"Aadhar Id: "+ details.getaadharId());
    }

    public static void createAddressDetails(BankCustomerDetails details) throws SQLException {
        Connection connection = getConnection();
        Statement state = connection.createStatement();
        state.executeUpdate("insert into addressDetails(customerId,permanentAdd,currentAdd) " +
                "values (" + details.getcustomerId() + ",'" + details.getpermanentAdd() + "','" + details.getcurrentAdd() + "')");
        System.out.println("Successfully Inserted Address Details : " +"Id: "+ details.getcustomerId() + " | " +"Permanent Address: "+details.getpermanentAdd() + " | " +"Current Address: "+ details.getcurrentAdd());
    }

    public static void createAccountDetails(BankCustomerDetails details) throws SQLException {
        Connection connection = getConnection();
        Statement state = connection.createStatement();
        state.executeUpdate("insert into accountDetails(customerId,openingDate,accNumber,accType,accBalance) " +
                "values (" + details.getcustomerId() + ",'" + details.getopeningDate() + "','" + details.getaccNumber() + "','" + details.getaccType() + "','" + details.getaccBalance() + "')");
        System.out.println("Successfully Inserted Account Details : " +"Id: "+ details.getcustomerId() + " | " +"Opening Date: "+ details.getopeningDate() + " | " +"Account Number: "+ details.getaccNumber() + " | " +"Account Type: "+ details.getaccType() + " | " +"Account Balance: "+ details.getaccBalance());
    }


    public static void showRecordsOfCustomerDetails(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customerdetails");
            List<BankCustomerDetails> detailsList = new ArrayList<>();
            while (resultSet.next()) {
                BankCustomerDetails details = new BankCustomerDetails(resultSet.getInt("customerId"), resultSet.getString("customerName"), resultSet.getString("phoneNumber"), resultSet.getString("aadharId"));
                detailsList.add(details);

                System.out.println("CUSTOMER ID: " + resultSet.getInt("customerId"));
                System.out.println("NAME: " + resultSet.getString("customerName"));
                System.out.println("PHONE NUMBER: " + resultSet.getString("phoneNumber"));
                System.out.println("AADHAR ID: " + resultSet.getString("aadharId"));
                System.out.println();
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showRecordsOfAddressDetails(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM addressdetails");
            List<BankCustomerDetails> detailsList = new ArrayList<>();
            while (resultSet.next()) {
                BankCustomerDetails details = new BankCustomerDetails(resultSet.getInt("customerId"), resultSet.getString("permanentAdd"), resultSet.getString("currentAdd"));
                detailsList.add(details);

                System.out.println("CUSTOMER ID: " + resultSet.getInt("customerId"));
                System.out.println("PERMANENT ADDRESS: " + resultSet.getString("permanentAdd"));
                System.out.println("CURRENT ADDRESS: " + resultSet.getString("currentAdd"));
                System.out.println();
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showRecordsOfaccounutDetails(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accountdetails");
            List<BankCustomerDetails> detailsList = new ArrayList<>();
            while (resultSet.next()) {
                BankCustomerDetails details = new BankCustomerDetails(resultSet.getInt("customerId"), resultSet.getString("openingDate"),
                        resultSet.getString("accNumber"), resultSet.getString("accType"), resultSet.getLong("accBalance"));
                detailsList.add(details);

                System.out.println("CUSTOMER_ID: " + resultSet.getInt("customerId"));
                System.out.println("ACCOUNT OPENING DATE: " + resultSet.getString("openingDate"));
                System.out.println("ACCOUNT NUMBER: " + resultSet.getString("accNumber"));
                System.out.println("ACCOUNT TYPE: " + resultSet.getString("accType"));
                System.out.println("ACCOUNT BALANCE: " + resultSet.getLong("accBalance"));
                System.out.println();
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteAccount(BankCustomerDetails details) {
        try {
            Connection connection = getConnection();
            Statement state = connection.createStatement();
            state.execute("delete from customerDetails where customerId=" + details.getcustomerId());
            state.execute("delete from addressDetails where customerId=" + details.getcustomerId());
            state.execute("delete from accountDetails where customerId=" + details.getcustomerId());
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updatePhoneNumber(BankCustomerDetails details) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("update customerDetails set phoneNumber =" + details.getphoneNumber() + " where customerId=" + 1);
            System.out.println("Phone Number Updated Successfully !!");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   /* public static void main(String[] args) throws ClassNotFoundException, SQLException {
        loadDriver();
        Connection connection = getConnection();
        showRecordsOfCustomerDetails(connection);
        showRecordsOfAddressDetails(connection);
        showRecordsOfaccounutDetails(connection);
        connection.close();
    }*/

}
