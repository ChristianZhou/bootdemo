package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.controller.dto.CustomerDTO;
import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
import com.zgx.bootdemo.entity.Page;
import com.zgx.bootdemo.service.CustomerSerivce;
import com.zgx.bootdemo.utils.CglibBeanCopierUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;


/**
 * @author zhouguixing
 * @date 2019/4/16 18:41
 * @description 客户信息Controller
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerSerivce customerSerivce;

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:37
     * @description 根据主键查询客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/read/{customerId}",method = RequestMethod.GET)
    public CustomerDTO read(@PathVariable("customerId")Long customerId) throws Exception {
        Customer read = customerSerivce.read(customerId);
        CustomerDTO customerDTO = new CustomerDTO();
        CglibBeanCopierUtil.copyProperties(read, customerDTO);
        return customerDTO;
    }

    /**
     * @author zhouguixing
     * @date 2019/4/18 13:17
     * @description 根据关键字、分页信息（页码、页面大小），查询客户列表
     *
     * @param keywordPage 1
     * @return : com.zgx.bootdemo.entity.Page<com.zgx.bootdemo.entity.CustomerDTODTO>
     */
    @ResponseBody
    @RequestMapping(value = "/listPage",method = RequestMethod.POST)
    public Page listPage(@RequestBody KeywordPage keywordPage) {

        Page<Customer> page = customerSerivce.listPage(keywordPage);

        Page<CustomerDTO> pageDTO = new Page<>();
        CglibBeanCopierUtil.copyPage(page,pageDTO);
        return pageDTO;
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:39
     * @description 添加客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        CglibBeanCopierUtil.copyProperties(customerDTO,customer);
        customerSerivce.save(customer);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:39
     * @description 根据主键删除客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{customerId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("customerId")Long customerId) throws Exception {
        customerSerivce.delete(customerId);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:40
     * @description 修改客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void update(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        CglibBeanCopierUtil.copyProperties(customerDTO, customer);
        customerSerivce.update(customer);
    }

}
