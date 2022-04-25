package com.dev.product.Coffee.exception;

import java.text.MessageFormat;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(final Long id){
        super(MessageFormat.format("Could not find list category with id: {0}" , id));
    }
}
