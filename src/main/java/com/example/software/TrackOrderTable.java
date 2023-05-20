package com.example.software;

public class TrackOrderTable {
    private int orderIdt;
    private int cidt;
    private int quantityt;
    private String statust;
    private String sizet;
    private String namet;
    private String colort;

    public void setOrderIdt(int orderIdt) {
        this.orderIdt = orderIdt;
    }

    public void setCidt(int cidt) {
        this.cidt = cidt;
    }

    public void setQuantityt(int quantityt) {
        this.quantityt = quantityt;
    }
    public void setStatust(String statust) {
        this.statust = statust;
    }

    public void setSizet(String sizet) {
        this.sizet = sizet;
    }

    public void setNamet(String namet) {
        this.namet = namet;
    }

    public void setColort(String colort) {
        this.colort = colort;
    }

    public TrackOrderTable(int orderIdt, int cidt, String namet, int quantityt, String sizet, String colort, String statust) {
        this.orderIdt = orderIdt;
        this.cidt = cidt;
        this.namet = namet;
        this.quantityt = quantityt;
        this.sizet = sizet;
        this.colort = colort;
        this.statust = statust;
    }
    public int getOrderId() {
        return orderIdt;
    }
    public int getCID() {
        return cidt;
    }

    public int getQuantity() {
        return quantityt;
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
