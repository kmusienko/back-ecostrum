package com.ecostrum.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootDTO {

  @XmlElement(name = "Counterparty")
  private List<CounterpartyDTO> counterpartyDTOList;

  public List<CounterpartyDTO> getCounterpartyDTOList() {
    return counterpartyDTOList;
  }

  public void setCounterpartyDTOList(
      List<CounterpartyDTO> counterpartyDTOList) {
    this.counterpartyDTOList = counterpartyDTOList;
  }
}
