package com.zgx.bootdemo.utils;

import com.zgx.bootdemo.controller.dto.BankDTO;
import com.zgx.bootdemo.controller.dto.CustomerDTO;
import com.zgx.bootdemo.controller.dto.CustomerTypeDTO;
import com.zgx.bootdemo.entity.Customer;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouguixing
 * @date 2019/4/23 16:39
 * @description Cglib类拷贝工具
 */
public class CglibBeanCopierUtil {

    private static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

    public static void copyProperties(Object source,Object target){
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        }else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    public static void copyPage(Object source,Object target){
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), true);
            beanCopierMap.put(beanKey, copier);
        }else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, new Converter() {
            @Override
            public Object convert(Object value, Class target, Object context) {
                if(value instanceof List){
                    List<CustomerDTO> list = new ArrayList<>();
                    for (Object o2 : (List) value) {
                        if(o2 instanceof Customer){
                            Customer customer = new Customer();
                            CglibBeanCopierUtil.copyProperties(o2,customer);
                            CustomerDTO customerData = new CustomerDTO();
                            BankDTO bankDTO = new BankDTO();
                            CustomerTypeDTO customerTypeDTO = new CustomerTypeDTO();
                            CglibBeanCopierUtil.copyProperties(customer.getBank() ==null?new BankDTO():customer.getBank(), bankDTO);
                            CglibBeanCopierUtil.copyProperties(customer.getCustomerType()==null?new CustomerDTO():customer.getCustomerType(),customerTypeDTO);
                            CglibBeanCopierUtil.copyProperties(customer, customerData);
                            customerData.setBank(bankDTO);
                            customerData.setCustomerType(customerTypeDTO);
                            list.add((customerData));
                        }
                    }
                    return list;
                }else {
                    return value;
                }
            }
        });
    }

    private static String generateKey(Class<?>class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }

}