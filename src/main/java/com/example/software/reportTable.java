package com.example.software;

public class reportTable {
    private  int customerId;
    private int totalAmountOfMoney;
    public reportTable( int customerId,int totalAmountOfMoney) {
       this.customerId=customerId;
       this.totalAmountOfMoney=totalAmountOfMoney;
    }

    public int getCustomerId() {
        return customerId;
    }
    public int getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }
}
