package com.bankingproject;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainBankOperations  {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {

            /*Scanner in =new Scanner(System.in);
            System.out.println("Enter the Customer Id: ");
            int input=in.nextInt();*/
            CrudSqlOperations.loadDriver();
            Connection connection=CrudSqlOperations.getConnection();
            //System.out.println(connection);
            BankCustomerDetails obj=new BankCustomerDetails(2,"Kishore","7094865480","78925635");
            BankCustomerDetails obj1=new BankCustomerDetails(2,"Tamilnadu","Bihar");
            BankCustomerDetails obj2=new BankCustomerDetails(2,"2022-12-31 03:23:12","456258214","Savings",35000);

            CrudSqlOperations.createCustomerDetails(obj);
            CrudSqlOperations.createAddressDetails(obj1);
            CrudSqlOperations.createAccountDetails(obj2);
            System.out.println();
            CrudSqlOperations.showRecordsOfCustomerDetails(connection);
            CrudSqlOperations.showRecordsOfAddressDetails(connection);
            CrudSqlOperations.showRecordsOfaccounutDetails(connection);
           /* int result = obj.setcustomerId(2);
            CrudSqlOperations.deleteAccount(obj);
            System.out.println("Customer Id "+ result+" is Deleted Successfully ");
*/
            obj.setphoneNumber("7094893588");
            CrudSqlOperations.updatePhoneNumber(obj);

        }
    }
