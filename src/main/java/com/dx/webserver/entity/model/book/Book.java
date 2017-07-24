package com.dx.webserver.entity.model.book;

import java.io.Serializable;

/**
 * @Description Book 实体类
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:16
 */
public class Book implements Serializable {

    /** 序列号*/
    private static final long serialVersionUID = -1L;

    private Integer id;

    private String name;

    private String author;

    private float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
