package com.andersen.onlinestore.exception;

import com.andersen.onlinestore.exception.type.ErrorType;
import com.andersen.onlinestore.util.GlobalConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotFoundException extends ResponseStatusException implements ContainErrorType {
    public ProductNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, String.format(GlobalConstants.PRODUCT_WITH_ID_NOT_FOUND, id));
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PRODUCT_NOT_FOUND;
    }
}
