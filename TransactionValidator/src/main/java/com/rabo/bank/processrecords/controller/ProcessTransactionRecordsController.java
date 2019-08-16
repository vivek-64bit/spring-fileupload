package com.rabo.bank.processrecords.controller;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.rabo.bank.data.model.FileUploadFormModel;
import com.rabo.bank.data.model.RecordModel;
import com.rabo.bank.processrecords.exception.InvalidFileException;
import com.rabo.bank.processrecords.service.CSVFileReader;
import com.rabo.bank.processrecords.service.XMLFileReader;

@Controller
public class ProcessTransactionRecordsController {

  List<String> csvMimeType =
      Arrays.asList(new String[] {"application/vnd.ms-excel", "application/csv"});
  List<String> xmlMimeType = Arrays.asList(new String[] {"text/xml", "application/xml"});

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String fetchUploadView(Model model) {
    model.addAttribute("fileUploadModel", new FileUploadFormModel());
    return "fileUpload";
  }

  @RequestMapping(value = "/processFile", method = RequestMethod.POST)
  public String processUpload(
      @ModelAttribute("fileUploadModel") FileUploadFormModel fileUploadModel,
      BindingResult bindingResult, ModelMap model) throws InvalidFileException, Exception {

    MultipartFile file = fileUploadModel.getFile();
    InputStream inputStream = file.getInputStream();
    model.addAttribute("fileName", file.getOriginalFilename());//set file name

    if (csvMimeType.contains(file.getContentType())) {
      List<RecordModel> recordList = CSVFileReader.readAndValidateFile(inputStream);
      if (recordList.size() > 0) {
        model.addAttribute("recordList", recordList);
        return "report";
      }
    } else if (xmlMimeType.contains(file.getContentType())) {
      List<RecordModel> recordList = XMLFileReader.readAndValidateFile(inputStream);
      if (recordList.size() > 0) {
        model.addAttribute("recordList", recordList);
        return "report";
      }
    } else {
      throw new InvalidFileException("Wrong format for file: "+file.getOriginalFilename());
    }
    return "fileUploadSuccess";
  }
}
