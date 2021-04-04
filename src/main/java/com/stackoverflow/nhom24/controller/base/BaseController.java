package com.stackoverflow.nhom24.controller.base;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired(required = false)
    protected MapperFacade mapper = new ConfigurableMapper();
}
