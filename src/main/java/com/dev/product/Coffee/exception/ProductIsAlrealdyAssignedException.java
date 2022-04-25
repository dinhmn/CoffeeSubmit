package com.dev.product.Coffee.exception;

import java.text.MessageFormat;

public class ProductIsAlrealdyAssignedException extends RuntimeException{
    public ProductIsAlrealdyAssignedException(final Long categoryId, final Long productId){
        super(MessageFormat.format("Product: {0} is already assigned to category: {1} ", productId, categoryId));
    }
}
