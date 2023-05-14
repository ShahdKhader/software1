package com.example.software;

public class TrackOrderTable {
    private int orderIdt;
    private int aidt;
    private int cidt;
    private int quantityt;
    private int moneyt;
    private String statust;
    private String sizet;
    private String namet;
    private String colort;

    public TrackOrderTable(int orderId, int AID, int CID, String name, int quantity, String size, String color, String status, int money) {
        this.orderIdt = orderId;
        this.aidt = AID;
        this.cidt = CID;
        this.namet = name;
        this.quantityt = quantity;
        this.sizet = size;
        this.colort = color;
        this.statust = status;
        this.moneyt = money;
    }
    public int getOrderId() {
        return orderIdt;
    }

    public int getAID() {
        return aidt;
    }

    public int getCID() {
        return cidt;
    }

    public int getQuantity() {
        return quantityt;
    }

    public int getMoney() {
        return moneyt;
    }

    public String getStatus() {
        return statust;
    }

    public String getSize() {
        return sizet;
    }

    public String getName() {
        return namet;
    }

    public String getColor() {
        return colort;
    }
}
