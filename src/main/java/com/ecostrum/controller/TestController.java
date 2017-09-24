package com.ecostrum.controller;

import com.ecostrum.service.FtpService;
import java.io.IOException;
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
  public String downloadFile() throws IOException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("credentials");
    ftpService.downloadFileFromFtp(
        resourceBundle.getString("server.host"),
        resourceBundle.getString("server.username"),
        resourceBundle.getString("server.password"),
        resourceBundle.getString("server.fs"));
    return "successfully downloaded";
  }

}
