package com.ecostrum.controller;

import com.ecostrum.entity.CounterpartyDTO;
import com.ecostrum.entity.RootDTO;
import com.ecostrum.entity.UserDTO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class MainTest {

  public static void main(String[] args) throws JAXBException, IOException {
//    JAXBContext jaxbContext = JAXBContext.newInstance(Pupils.class);
//    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//    Pupils pupils = (Pupils) jaxbUnmarshaller
//        .unmarshal(new File(System.getProperty("user.dir") + "/src/main/resources/hello.xml"));
//    System.out.println();
    JAXBContext jaxbContext2 = JAXBContext.newInstance(RootDTO.class);
    Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
    RootDTO rootDTO = (RootDTO) jaxbUnmarshaller2
        .unmarshal(new File(System.getProperty("user.dir") + "/src/main/resources/obmenK.xml"));

    boolean isValid = false;
    isValid = isValidUser(new UserDTO("user3", ""));
    System.out.println(isValid);
    List<CounterpartyDTO> counterpartyDTOS = rootDTO.getCounterpartyDTOList();
    for (CounterpartyDTO counterpartyDTO : counterpartyDTOS) {
      System.out.println(counterpartyDTO.getMeneger());
    }
  }

  public static boolean isValidUser(UserDTO userDTO) throws IOException {
    List<String> lines = Files
        .readAllLines(
            Paths.get(System.getProperty("user.dir") + "/src/main/resources/security/users.txt"));
    for (String line : lines) {
      if (line.substring(0, line.indexOf("=")).equals(userDTO.getUsername())) {
        if (userDTO.getPassword().equals("")) {
          return true;
        } else if (line.substring(line.indexOf("=")).equals(userDTO.getPassword())) {
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }

}
