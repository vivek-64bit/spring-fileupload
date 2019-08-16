package com.rabo.bank.data.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "records")
public class RecordsModel {
  
  private List<RecordModel> recordModel = null;

  @XmlElement(name = "record")
  public List<RecordModel> getRecordModel() {
    return recordModel;
  }

  public void setRecordModel(List<RecordModel> recordModel) {
    this.recordModel = recordModel;
  }

}
