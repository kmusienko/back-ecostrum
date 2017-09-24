package com.ecostrum.service;

import java.io.File;
import java.io.IOException;

public interface FtpService {

  void deliverFileFtp(String host, String username, String password, String fs, String localPath);

  void downloadFileFromFtp(String host, String username, String password, String fs)
      throws IOException;
}
