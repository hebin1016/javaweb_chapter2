package com.hank.chapter2.service;

import com.hank.chapter2.helper.DatabaseHelper;
import com.hank.chapter2.model.Customer;
import com.hank.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);


    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer where id=" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }

    /**
     * 创建用户
     *
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户信息
     *
     * @param id
     * @param filemap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> filemap) {
        return DatabaseHelper.updateEntity(Customer.class, id, filemap);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.daleteEntity(Customer.class, id);

    }
}
