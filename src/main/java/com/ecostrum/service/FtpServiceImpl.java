package com.ecostrum.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

@Service
public class FtpServiceImpl implements FtpService {

  @Override
  public void deliverFileFtp(String host, String username, String password, String fs,
      String localPath) {
    FTPClient ftpClient = new FTPClient();
    try {
      FileInputStream fileInputStream = new FileInputStream(
          System.getProperty("user.dir") + "/src/main/resources/products.xml");
      ftpClient.connect(host);
      ftpClient.enterLocalPassiveMode();
      ftpClient.login(username, password);
      System.out.println("Connected..");
      ftpClient.storeFile(fs, fileInputStream);
      System.out.println("File has successfully stored.");
      ftpClient.logout();
      ftpClient.disconnect();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void downloadFileFromFtp(String host, String username, String password, String fs)
      throws IOException {
    FTPClient ftpClient = new FTPClient();
    ftpClient.connect(host);
    ftpClient.enterLocalPassiveMode();
    ftpClient.login(username, password);
    OutputStream outputStream = new FileOutputStream(
        System.getProperty("user.dir") + "/src/main/resources/dtest.xml");
    ftpClient.retrieveFile("/images/products.xml", outputStream);
    ftpClient.logout();
    ftpClient.disconnect();
  }
}
