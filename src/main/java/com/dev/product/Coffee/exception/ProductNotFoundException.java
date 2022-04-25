package com.dev.product.Coffee.exception;

import java.text.MessageFormat;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(final Long id){
        super(MessageFormat.format("Could not find list product with id: {0}" , id));
    }
}
