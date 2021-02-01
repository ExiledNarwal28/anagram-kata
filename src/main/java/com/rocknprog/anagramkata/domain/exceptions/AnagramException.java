package com.rocknprog.anagramkata.domain.exceptions;

public abstract class AnagramException extends RuntimeException {
  public String error;
  public String description;

  public AnagramException(String error, String description) {
    this.error = error;
    this.description = description;
  }
}
