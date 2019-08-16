package com.rabo.bank.processrecords.exception;

public class InvalidFileException extends Throwable {

  private static final long serialVersionUID = 1L;

  public InvalidFileException() {
    super();
  }

  public InvalidFileException(String message) {
    super(message);
  }
}
