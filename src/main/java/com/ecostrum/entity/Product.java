package com.ecostrum.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

  @XmlAttribute
  private String kod1C;

  @XmlAttribute
  private String name;

  @XmlAttribute
  private double price;

  public Product() {
  }

  public Product(String kod1C, String name, double price) {
    this.kod1C = kod1C;
    this.name = name;
    this.price = price;
  }

  public String getKod1C() {
    return kod1C;
  }

  public void setKod1C(String kod1C) {
    this.kod1C = kod1C;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
