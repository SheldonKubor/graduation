package com.model;

/**
 * Created by Constantine on 2017/6/10.
 */
public class OrderItemBean {
    private int id;
    private String username;
    private String book_name;
    private int bookNum;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", book_name='" + book_name + '\'' +
                ", bookNum=" + bookNum +
                ", price=" + price +
                '}';
    }
}
