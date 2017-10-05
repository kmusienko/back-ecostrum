package com.ecostrum.controller;

import com.ecostrum.entity.PoloProducts;
import com.ecostrum.entity.Product;
import com.ecostrum.service.FtpService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private FtpService ftpService;

  @Autowired
  public void setFtpService(FtpService ftpService) {
    this.ftpService = ftpService;
  }

  @GetMapping(value = "/uploadfile")
  public String uploadFile() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("credentials");
    ftpService.deliverFileFtp(
        resourceBundle.getString("server.host"),
        resourceBundle.getString("server.username"),
        resourceBundle.getString("server.password"),
        resourceBundle.getString("server.fs"),
        resourceBundle.getString("local.path"));
    return "successfully uploaded";
  }

  @GetMapping(value = "/downloadfile")
  public File downloadFile() throws IOException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("credentials");
    ftpService.downloadFileFromFtp(
        resourceBundle.getString("server.host"),
        resourceBundle.getString("server.username"),
        resourceBundle.getString("server.password"),
        resourceBundle.getString("server.fs"));
    File file = new File(System.getProperty("user.dir") + "/src/main/resources/dtest.xml");
    return file;
  }

  @GetMapping(value = "/gettestxml", produces = "application/xml")
  public PoloProducts getProducts() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("kod1", "firstName", 4.5));
    products.add(new Product(("kod2"), "secondName", 12));
    PoloProducts poloProducts = new PoloProducts(products);
    return poloProducts;
  }

  @GetMapping(value = "/getxmlastext")
  public String getXmlLikeString() throws IOException {
    String s = "";
    Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/obmenT.xml");
    List<String> lines = Files.readAllLines(path);
    for (String line : lines) {
      s += line;
    }
    System.out.println(s);
    return s;
  }

}
