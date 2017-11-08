package com.ecostrum.controller;

import com.ecostrum.entity.UserDTO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {

  @PostMapping(value = "/login")
  public boolean isValidUser(@RequestBody UserDTO userDTO) throws IOException {
    List<String> lines = Files
        .readAllLines(
            Paths.get(System.getProperty("user.dir") + "/src/main/resources/security/users.txt"));
    for (String line : lines) {
      if (line.substring(0, line.indexOf("=")).equals(userDTO.getUsername())) {
        if (userDTO.getPassword().equals("")) {
          return true;
        } else if (line.substring(line.indexOf("=") + 1).equals(userDTO.getPassword())) {
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }
}
