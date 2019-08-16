package com.rabo.bank.processrecords.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.rabo.bank.data.model.RecordModel;

public class ValidateRecords {

  public static Integer ONE = 1;

  public static List<RecordModel> getFilteredList(List<RecordModel> allRecordsList) {

    List<RecordModel> processedList = new ArrayList<RecordModel>();
    List<RecordModel> wrongEndBalanceRecords = new ArrayList<RecordModel>();
    Map<RecordModel, Integer> filterDupMap = new LinkedHashMap<>();

    Iterator<RecordModel> recordIterator = allRecordsList.iterator();
    while (recordIterator.hasNext()) {
      RecordModel recordModel = recordIterator.next();
     // String reference = recordModel.getReference();
      Double startBalance = Double.parseDouble(recordModel.getStartBalance());
      Double mutation = Double.parseDouble(recordModel.getMutation());
      Double endBalance = Double.parseDouble(recordModel.getEndBalance());
      Double value = startBalance + mutation;

      if (Double.compare(endBalance,value) != 0) {
        wrongEndBalanceRecords.add(recordModel);
      }

      if (filterDupMap.containsKey(recordModel)) {
        int count=filterDupMap.get(recordModel);
        filterDupMap.put(recordModel, ++count);
      } else {
        filterDupMap.put(recordModel, ONE);
      }
    }

    filterSingleEntries(allRecordsList, filterDupMap);

    processedList.addAll(wrongEndBalanceRecords);
    processedList.addAll(allRecordsList);
    return processedList;
  }

  private static void filterSingleEntries(List<RecordModel> allRecordsList,
      Map<RecordModel, Integer> filterDupMap) {
    for (RecordModel key : filterDupMap.keySet()) {
      if (filterDupMap.get(key) == ONE) {
        allRecordsList.remove(key);
      }
    }
  }
}
