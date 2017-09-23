package com.ecostrum.service;

public interface FtpService {

  void deliverFileFtp(String host, String username, String password, String fs, String localPath);

}
