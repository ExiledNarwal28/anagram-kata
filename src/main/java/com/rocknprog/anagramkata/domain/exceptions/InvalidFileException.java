package com.rocknprog.anagramkata.domain.exceptions;

public class InvalidFileException extends AnagramException {
  private static final String ERROR = "Invalid file";
  private static final String DESCRIPTION = "File is invalid";

  public InvalidFileException() {
    super(ERROR, DESCRIPTION);
  }
}
