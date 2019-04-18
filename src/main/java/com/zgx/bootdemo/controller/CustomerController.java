package com.zgx.bootdemo.controller;

import com.zgx.bootdemo.entity.Customer;
import com.zgx.bootdemo.entity.KeywordPage;
import com.zgx.bootdemo.entity.Page;
import com.zgx.bootdemo.service.CustomerSerivce;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;


/**
 * @author zhouguixing
 * @date 2019/4/16 18:41
 * @description 客户信息Controller
 */
@RestController
public class CustomerController {

    @Resource(name = "customerSerivce")
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
     * @date 2019/4/17 10:38
     * @description  根据实体类参数属性查询客户列表，为空的属性忽略
     */
    @ResponseBody
    @RequestMapping(value = "/customer/list",method = RequestMethod.POST)
    public List listCustomer(@RequestBody Customer customer) {
        return customerSerivce.listCustomer(customer);
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
     * @date 2019/4/17 10:38
     * @description  根据实体类参数属性查询客户数量，为空的属性忽略
     */
    @ResponseBody
    @RequestMapping(value = "/customer/count",method = RequestMethod.POST)
    public int countCustomer(@RequestBody Customer customer) {
        return customerSerivce.countCustomer(customer);
    }

    /**
     * @author zhouguixing
     * @date 2019/4/17 10:39
     * @description 添加客户信息
     */
    @ResponseBody
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public String saveCustomer(@RequestBody Customer customer) {
        customer.setCustCode(UUID.randomUUID().toString());
        boolean flag  = customerSerivce.saveCustomer(customer);
        return flag?"添加成功":"添加失败";
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



    /**
     * @author zhouguixing
     * @date 2019/4/17 10:40
     * @description 获取某个实体类完整的JSON字符串
     */
//    public static void main(String[] args) {
//        System.out.println(JSON.toJSONString(new Customer(), SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero));
//    }


}
