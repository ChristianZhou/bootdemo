package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
import com.zgx.bootdemo.entity.Page;
import com.zgx.bootdemo.service.CustomerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


/**
 * @author zhouguixing
 * @date 2019/4/16 18:41
 * @description 客户信息Controller
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerSerivce customerSerivce;

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:37
     * @description 根据主键查询客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/customer/{customerId}",method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("customerId")String customerId) throws Exception {
        return customerSerivce.getCustomer(customerId);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/18 13:17
     * @description 根据关键字、分页信息（页码、页面大小），查询客户列表
     *
     * @param keywordPage 1
     * @return : com.zgx.bootdemo.entity.Page<com.zgx.bootdemo.entity.Customer>
     */
    @ResponseBody
    @RequestMapping(value = "/customer/listPage",method = RequestMethod.POST)
    public Page<Customer> listPageCustomer(@RequestBody KeywordPage keywordPage) {
        String keyword = keywordPage.getKeyword();

        Page page = keywordPage.getPage();
        int pageNum =1;
        int pageSize = 10;
        if (page != null) {
            if (page.getPageNum() != null)
                pageNum=page.getPageNum();
            if (page.getPageSize() != null)
                pageSize = page.getPageSize();
        }
        return customerSerivce.listPageCustomer(keyword, pageNum, pageSize);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:39
     * @description 添加客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public void saveCustomer(@RequestBody Customer customer) {
        customer.setCustCode(UUID.randomUUID().toString());
        customerSerivce.saveCustomer(customer);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:39
     * @description 根据主键删除客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/customer/{customerId}",method = RequestMethod.DELETE)
    public void removeCustomer(@PathVariable("customerId")String customerId) throws Exception {
        customerSerivce.removeCustomer(customerId);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:40
     * @description 修改客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/customer",method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer) {
        customerSerivce.updateCustomer(customer);
    }

}
