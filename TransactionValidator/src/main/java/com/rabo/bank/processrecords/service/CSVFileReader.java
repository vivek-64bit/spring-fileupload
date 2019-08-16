package com.rabo.bank.processrecords.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.rabo.bank.data.model.RecordModel;

public class CSVFileReader {

  public static List<RecordModel> readAndValidateFile(InputStream inputStream) throws Exception {

    List<RecordModel> recordList = null;

    Function<String, RecordModel> mapToRecords = (line) -> {
      String[] columns = line.split(",");
      RecordModel record = new RecordModel();
      record.setReference(columns[0]);
      record.setAccNumber(columns[1]);
      record.setDescription(columns[2]);
      record.setStartBalance(columns[3]);
      record.setMutation(columns[4]);
      record.setEndBalance(columns[5]);
      return record;
    };

    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    recordList = br.lines().skip(1).map(mapToRecords).collect(Collectors.toList());
    br.close();

    return ValidateRecords.getFilteredList(recordList);
  }
}
