package com.rabo.bank.processrecords.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.rabo.bank.processrecords.exception.InvalidFileException;

@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(InvalidFileException.class)
  public ModelAndView handleFileUploadException(InvalidFileException ex) {
    String errorMessage = ex.getMessage();
    ModelAndView model = new ModelAndView("fileUploadFailure");
    model.addObject("message", errorMessage);
    return model;
  }
}
