package com.hank.chapter2.test;

import com.hank.chapter2.helper.DatabaseHelper;
import com.hank.chapter2.model.Customer;
import com.hank.chapter2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class CustomerServiceTest {

    private CustomerService mCustomerService;

    public CustomerServiceTest() {
        mCustomerService = new CustomerService();
    }

    @Before
    public void init(){
        String file = "sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);
    }


    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = mCustomerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() {
        long id = 1;
        Customer customer = mCustomerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "customer100");
        map.put("contact", "frank");
        map.put("telephone", "12345678910");
        boolean isSuccess = mCustomerService.createCustomer(map);
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void updateCustomerTest() {
        long id = 1;
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("contact", "eric");
        boolean isSuccess = mCustomerService.updateCustomer(id, map);
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void deleteCustomerTest() {
        long id = 1;
        boolean isSuccess = mCustomerService.deleteCustomer(id);
        Assert.assertTrue(isSuccess);
    }
}
