package com.rabo.bank.processrecords.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import com.rabo.bank.data.model.RecordModel;
import com.rabo.bank.data.model.RecordsModel;

@Service
public class XMLFileReader{
  
  public static List<RecordModel> readAndValidateFile(InputStream inputStream) throws FileNotFoundException, IOException, JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(RecordsModel.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    RecordsModel recordsModel=(RecordsModel) unmarshaller.unmarshal(inputStream);
    return ValidateRecords.getFilteredList(recordsModel.getRecordModel());
  }
}
