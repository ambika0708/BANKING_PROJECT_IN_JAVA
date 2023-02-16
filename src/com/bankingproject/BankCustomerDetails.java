package com.bankingproject;

public class BankCustomerDetails {
    String customerName,phoneNumber,aadharId;
    String permanentAdd, currentAdd;
    String openingDate,accNumber,accType;
    long accBalance;
    int customerId;
    public BankCustomerDetails(int customerId, String customerName, String phoneNumber,String aadharId){
        this.customerId=customerId;
        this.customerName=customerName;
        this.phoneNumber=phoneNumber;
        this.aadharId=aadharId;
    }
    public BankCustomerDetails(int customerId, String permanentAdd,String currentAdd){
        this.customerId=customerId;
        this.permanentAdd=permanentAdd;
        this.currentAdd=currentAdd;
    }
    public BankCustomerDetails(int customerId,String openingDate, String accNumber, String accType, long accBalance){
        this.customerId=customerId;
        this.openingDate=openingDate;
        this.accNumber=accNumber;
        this.accType=accType;
        this.accBalance=accBalance;
    }
    public int getcustomerId(){
        return this.customerId;
    }
    public int setcustomerId(int id){
        this.customerId=id;
        return this.customerId;
    }
    public String getcustomerName(){
        return this.customerName;
    }
    public String setcustomerName(String name){
        this.customerName=name;
        return this.customerName;
    }
    public String getphoneNumber(){
        return this.phoneNumber;
    }
    public String setphoneNumber(String phoneNo){
        this.phoneNumber=phoneNo;
        return this.phoneNumber;
    }

    public String getaadharId(){
        return this.aadharId;
    }
    public String setaadharId(String aadharId){
        this.aadharId=aadharId;
        return this.aadharId;
    }
    public String getpermanentAdd(){
        return this.permanentAdd;
    }
    public String setpermanentAdd(String permanentAdd){
        this.permanentAdd=permanentAdd;
        return this.permanentAdd;
    }
    public String getcurrentAdd(){
        return this.currentAdd;
    }
    public String setcurrentAdd(String currentAdd){
        this.currentAdd=currentAdd;
        return this.currentAdd;
    }
    public String getopeningDate(){
        return this.openingDate;
    }
    public String setopeningDate(String openingDate){
        this.openingDate=openingDate;
        return this.openingDate;
    }
    public String getaccNumber(){
        return this.accNumber;
    }
    public String setaccNumber(String accNumber){
        this.openingDate=openingDate;
        return this.openingDate;
    }
    public String getaccType(){
        return this.accType;
    }
    public String setaccType(String accType){
        this.accType=accType;
        return this.accType;
    }
    public long getaccBalance(){
        return this.accBalance;
    }
   public long setaccBalance(long accBalance){
        this.accBalance=accBalance;
        return accBalance;
   }

}
