package com.bankingproject;

import java.sql.*;
import java.util.Scanner;

public class BankingMenu {
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

    public static int menu(Scanner in) {
        System.out.println("Banking Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. View Balance");
        System.out.println("5. Apply Interest");
        System.out.println("6. Exit");
        System.out.println();
        int option;
        do {
            System.out.println("Enter Your Option ");
            option = in.nextInt();
        } while (option < 1 || option > 6);
        return option;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numAccounts = 0;
        int option;
        do {
            option = menu(in);
            if (option == 1) {
                try {
                    createAccount();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (option == 2) {
                try {
                    doDeposit();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (option == 3) {
                try {
                    doWithdraw();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if (option == 4) {
                viewBalance();
            } else if (option == 5) {
                try {
                    putInterest(in);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Thank You");
            }
            System.out.println();
        } while (option != 6);
    }

    private static void viewBalance() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your account number");
            int accountNumber = in.nextInt();
            String sql = "select * from accountDetails where accNumber='" + accountNumber + "'";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                double AccountBalance = rs.getLong("accBalance");
                System.out.println("Your Account Balance is :" + AccountBalance);
            } else {
                System.out.println("Account Number " + accountNumber + " is not Found");
            }
            System.out.println();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static int accountTypeMenu(Scanner in) {
        System.out.println("Select Account Type ");
        System.out.println("1. Savings Account");
        System.out.println("2. Fixed Deposit Account");
        System.out.println("3. Recurring Deposit Account");
        System.out.println();
        int option;
        do {
            System.out.println("Enter your option ");
            option = in.nextInt();
        } while (option < 1 || option > 3);
        return option;
    }

    public static void putInterest(Scanner in) throws SQLException {
        int option = accountTypeMenu(in);
        if (option == 1) {
            SavingsAccountInterest sa = new SavingsAccountInterest();
            sa.savingsInterest();
        } else if (option == 2) {
            FixedDepositAccountInterest fda = new FixedDepositAccountInterest();
            fda.fixedDepositInterest();
        } else {
            RecurringDepositAccountInterest rda = new RecurringDepositAccountInterest();
            rda.recurringDepositAccount();
        }

    }

    public static void doWithdraw() throws SQLException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your account number");
            int accountNumber = in.nextInt();
            String sql = "select * from accountDetails where accNumber='" + accountNumber + "'";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Enter the amount you want to withdraw: ");
                double amount = in.nextDouble();
                if (amount > 200) {
                    double AccountBalance = rs.getLong("accBalance");
                    if (AccountBalance >= 200) {
                        System.out.println("Before withdraw Your Balance is: " + AccountBalance);
                        AccountBalance = AccountBalance - amount;
                        System.out.println();
                        System.out.println("Amount " + amount + " Withdrawn successfully ");
                        System.out.println("After withdraw Your Balance is: " + AccountBalance);
                        statement.execute("update accountDetails set accBalance =" + AccountBalance + "" +
                                " where accNumber=" + accountNumber);
                    } else {
                        System.out.println("Your balance is less than " + amount + " ... Transaction failed");
                    }
                } else {
                    System.out.println("Withdrawal starts from Rupees 200");
                }
            } else {
                System.out.println("Account Number " + accountNumber + " is Not Found ... Please Register Your Account");
            }
            System.out.println();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void doDeposit() throws SQLException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your account number");
            int accountNumber = in.nextInt();
            String sql = "select * from accountDetails where accNumber='" + accountNumber + "'";
            ResultSet rs = statement.executeQuery(sql);
            //int databaseAccountNumber= Integer.parseInt(resultSet.getString("accNumber"));
            if (rs.next()) {
                System.out.println("Enter the amount you want to deposit: ");
                double amount = in.nextDouble();
                if (amount > 100) {
                    double AccountBalance = rs.getLong("accBalance");
                    System.out.println("Before deposition Your Balance is: " + AccountBalance);
                    AccountBalance = AccountBalance + amount;
                    System.out.println();
                    System.out.println("Amount " + amount + " deposited successfully ");
                    System.out.println("After deposition Your Balance is: " + AccountBalance);
                    statement.execute("update accountDetails set accBalance =" + AccountBalance + " where accNumber=" + accountNumber);
                } else {
                    System.out.println("Deposit starts from Rupess 100");
                }
            } else {
                System.out.println("Account Number " + accountNumber + " is Not Found ... Please Register Your Account");
            }
            System.out.println();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createAccount() throws ClassNotFoundException, SQLException {
        CrudSqlOperations.loadDriver();
        Connection connection = CrudSqlOperations.getConnection();
        //System.out.println(connection);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Customer Id");
        int customerId = in.nextInt();
        System.out.println("Enter Customer Name");
        in.nextLine();
        String customerName = in.nextLine();
        System.out.println("Enter Customer Phone Number ");
        String phoneNumber = in.next();
        System.out.println("Enter Customer Aadhar Id");
        in.nextLine();
        String aadharId = in.nextLine();
        BankCustomerDetails obj = new BankCustomerDetails(customerId, customerName, phoneNumber, aadharId);
        System.out.println();

        System.out.println("Enter Permanent Address of account holder");
        String permanentAdd = in.nextLine();
        System.out.println("Enter Current Address of account holder");
        String currentAdd = in.nextLine();
        BankCustomerDetails obj1 = new BankCustomerDetails(customerId, permanentAdd, currentAdd);
        System.out.println();

        System.out.println("Enter Account Opening Date (FORMAT: YYYY-MM-DD HH:MM:SS)");
        String openingDate = in.nextLine();
        System.out.println("Enter account Number ");
        String accNumber = in.nextLine();
        System.out.println("Enter account Type");
        String accType = in.nextLine();
        System.out.println("Current Account Balance");
        Long accBalance = in.nextLong();
        BankCustomerDetails obj2 = new BankCustomerDetails(customerId, openingDate, accNumber, accType, accBalance);
        System.out.println();

        CrudSqlOperations.createCustomerDetails(obj);
        CrudSqlOperations.createAddressDetails(obj1);
        CrudSqlOperations.createAccountDetails(obj2);
        System.out.println();
        System.out.println("================== Account Created Successfully ===================");
        System.out.println();
    }


}
