package com.ecostrum.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PoloProducts")
public class PoloProducts {

  @XmlElement
  private List<Product> product;

  public PoloProducts() {
  }

  public PoloProducts(List<Product> products) {
    this.product = products;
  }

  public List<Product> getProducts() {
    return product;
  }

  public void setProducts(List<Product> products) {
    this.product = products;
  }
}
