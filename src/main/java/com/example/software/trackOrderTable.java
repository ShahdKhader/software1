package com.example.software;

public class trackOrderTable {
    private int OrderId;
    private int AID;
    private int CID;
    private int Quantity;
    private int Money;
    private String Status,Size,Name,Color;

    public trackOrderTable(int orderId, int AID, int CID, String name,int quantity, String size, String color, String status,int money) {
        this.OrderId = orderId;
        this.AID = AID;
        this.CID = CID;
        this.Name = name;
        this.Quantity = quantity;
        this.Size = size;
        this.Color = color;
        this.Status = status;
        this.Money = money;
    }
    public int getOrderId() {
        return OrderId;
    }

    public int getAID() {
        return AID;
    }

    public int getCID() {
        return CID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getMoney() {
        return Money;
    }

    public String getStatus() {
        return Status;
    }

    public String getSize() {
        return Size;
    }

    public String getName() {
        return Name;
    }

    public String getColor() {
        return Color;
    }
}
