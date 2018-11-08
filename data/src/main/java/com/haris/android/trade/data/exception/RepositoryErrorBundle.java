
package com.haris.android.trade.data.exception;

import com.haris.android.trade.domain.exception.ErrorBundle;


class RepositoryErrorBundle implements ErrorBundle {

  private final Exception exception;

  RepositoryErrorBundle(Exception exception) {
    this.exception = exception;
  }

  @Override
  public Exception getException() {
    return exception;
  }

  @Override
  public String getErrorMessage() {
    String message = "";
    if (this.exception != null) {
      message = this.exception.getMessage();
    }
    return message;
  }
}
