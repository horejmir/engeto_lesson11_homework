package com.engeto;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem")
    private Integer id;

    private String partNo;

    private String serialNo;

    private String name;

    private String description;

    private Integer numberInStock;

    private BigDecimal price;

    public Item() {
    }

    public Item(String partNo, String serialNo, String name, String description, Integer numberInStock, BigDecimal price) {
        this.partNo = partNo;
        this.serialNo = serialNo;
        this.name = name;
        this.description = description;
        this.numberInStock = numberInStock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", partNo='" + partNo + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberInStock=" + numberInStock +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
