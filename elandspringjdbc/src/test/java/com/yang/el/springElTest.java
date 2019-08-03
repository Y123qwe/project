package com.yang.el;

import com.yang.Address;
import com.yang.Car;
import com.yang.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springElTest {
    private ApplicationContext applicationContext=null;
    @Before
    public void testInit(){
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void  testSpEl(){
        Address address= (Address) applicationContext.getBean("address");
        System.out.println("city= "+address.getCity());
        System.out.println("street= "+address.getStreet());
        Car car=(Car) applicationContext.getBean("car");
        System.out.println("brand ="+car.getBrand());
        System.out.println("price ="+car.getPrice());
        System.out.println("ty ="+car.getTyrperimeter());
        Person person=(Person)applicationContext.getBean("person");
        System.out.println("city="+person.getCity());
        System.out.println("name="+person.getpName());
        System.out.println("Info="+person.getInfo());
        System.out.println("car="+person.getCar());

    }
}
