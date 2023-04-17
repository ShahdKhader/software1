package com.example.software;

public class report {
    int col_price, col_quantity, col_size;
    String customer_name, product_name, col_color;

    public void setCol_price(int col_price){
        this.col_price = col_price ;
    }
    public void setCol_quantity(int col_quantity){
        this.col_quantity = col_quantity ;
    }
    public void setCol_size(int col_size){
        this.col_size = col_size ;
    }
    public void setCustomer_name(String customer_name){
        this.customer_name = customer_name ;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name ;
    }
    public void setCol_color(String col_color){
        this.col_color = col_color ;
    }
    public int getCol_price(){
        return col_price;
    }
    public int getCol_quantity(){
        return col_quantity;
    }
    public int getCol_size(){
        return col_size;
    }

    public String getCol_color() {
        return col_color;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }
    public report(int col_price, int col_quantity, int col_size, String col_color, String customer_name, String product_name){
        this.col_price = col_price;
        this.col_size = col_size;
        this.col_quantity = col_quantity;
        this.col_color = col_color;
        this.customer_name = customer_name;
        this.product_name = product_name;
    }
}