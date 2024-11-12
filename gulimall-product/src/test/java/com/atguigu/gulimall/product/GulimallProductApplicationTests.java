package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        //brandEntity.setBrandId(1L);
        //brandEntity.setDescript("修改");
        //brandService.updateById(brandEntity);
        //brandEntity.setName("华为");
        //brandService.save(brandEntity);
        //System.out.println("保存成功");
        //System.out.println(brandService.getById(1L));
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",1L));
        list.forEach((item)->{
            System.out.println(item);
        });
    }


    public void test1() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        // 扫描的配置类，如@ComponentScan
        // 会去解析配置类然后实例化一个扫描器去扫描
        ac.register(A.class);
        ac.scan("");
        ac.refresh();
        String[] bds = ac.getBeanDefinitionNames();


        Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                A.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(proxy, args);
                        return invoke;

                    }
                });
    }
}

interface A {
    public int test();
}
