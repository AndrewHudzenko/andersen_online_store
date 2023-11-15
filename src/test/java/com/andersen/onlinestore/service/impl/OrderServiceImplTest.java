package com.andersen.onlinestore.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Test
    @Disabled
    void testGetById() {

    }

    @Test
    @Disabled
    void testCreate() {

    }

    @Test
    @Disabled
    void testDeleteById() {

    }
}
