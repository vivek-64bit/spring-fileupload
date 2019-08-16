package com.rabo.bank.data.model;

import javax.xml.bind.annotation.XmlAttribute;

public class RecordModel {

  private String reference;
  private String accNumber;
  private String description;
  private String startBalance;
  private String mutation;
  private String endBalance;

  @XmlAttribute(name="reference")
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getAccNumber() {
    return accNumber;
  }

  public void setAccNumber(String accNumber) {
    this.accNumber = accNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartBalance() {
    return startBalance;
  }

  public void setStartBalance(String startBalance) {
    this.startBalance = startBalance;
  }

  public String getMutation() {
    return mutation;
  }

  public void setMutation(String mutation) {
    this.mutation = mutation;
  }

  public String getEndBalance() {
    return endBalance;
  }

  public void setEndBalance(String endBalance) {
    this.endBalance = endBalance;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((reference == null) ? 0 : reference.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RecordModel other = (RecordModel) obj;
    if (reference == null) {
      if (other.reference != null)
        return false;
    } else if (!reference.equals(other.reference))
      return false;
    return true;
  }
   
}
