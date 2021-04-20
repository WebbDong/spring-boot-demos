package com.webbdong.springboot.yml.controller;

import com.webbdong.springboot.yml.model.Car;
import com.webbdong.springboot.yml.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SpringEL
 *  在 Spring 3 中引入了 Spring 表达式语言 - SpringEL，可以通过运行期间执行的表达式将值装配到我们的属性或构造函数当中,
 *  更可以调用JDK中提供的静态常量,获取外部 properties 文件中的的配置
 *
 * SpringEL 通过 #{} 来使用
 * @author Webb Dong
 * @date 2021-04-20 5:22 PM
 */
@RestController
public class SpringELController {

    // --------------------- 注入简单值 ------------------------

    // 注入常量值，num 赋值为 50
    @Value("#{50}")
    private int num;

    // 注入 name 为 car 的 bean 实例
    @Value("#{car}")
    private Car car;

    // 注入 Student 类的 CLASS_NAME 常量的值
    @Value("#{T(com.webbdong.springboot.yml.model.Student).CLASS_NAME}")
    private String className;

    // 注入 car 对象的 brand 属性值
    @Value("#{car.brand}")
    private String brand;

    // --------------------- 调用方法并注入方法返回值 ------------------------

    // 调用 car 对象的 drive 方法，并且将方法返回值注入
    @Value("#{car.drive()}")
    private Integer power;

    // 调用 student 对象的 addNum 方法传入参数，并且注入返回值
    @Value("#{student.addNum(car.power, student.age)}")
    private Integer sumNum;

    // 拼接字符串
    @Value("#{student.name + '' + car.brand}")
    private String str;

    // --------------------- 调用静态字段与运算 ------------------------

    // 注入算术运算结果
    @Value("#{3 * T(java.lang.Math).PI + car.power}")
    private double arithmeticOperation;

    // 注入逻辑运算结果
    @Value("#{car.power > 500 and student.age < 60}")
    private boolean logicOperation;

    // 注入逻辑非运算结果
    @Value("#{!(car.power > 500)}")
    private boolean logicOperation2;

    // 三目运算符
    @Value("#{car.power > 500 ? student.age : car.power}")
    private Integer ternaryOperator;

    // --------------------- 正则表达式 ------------------------

    // 正则表达式
    @Value("#{student.email matches '\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+'}")
    private boolean regularExpression;

    // --------------------- 操作集合 ------------------------

    // 注入 studentList 数组下标为 0 的元素
    @Value("#{studentList[0]}")
    private Student stu1;

    @Value("#{studentList[0].name.toUpperCase()}")
    private String upperCaseName;

    // --------------------- 筛选集合和投影 ------------------------

    // 将 studentList 数组中 name 属性值是 John 的元素
    @Value("#{studentList.?[name == 'John']}")
    private Student stu2;

    // 将 studentList 数组中 age 属性值大于 50 的元素筛选出来，放入一个新的 List 中并且注入
    @Value("#{studentList.?[age > 50]}")
    private List<Student> stuList3;

    // 将 studentList 数组中 age 属性值大于 30 的元素筛选出来，然后将这些元素对象的 name 属性值放入一个新的 List 中并且注入
    @Value("#{studentList.?[age > 30].![name]}")
    private List<String> nameList;

    @RequestMapping("/springEL")
    public String springEL() {
        System.out.println("num = " + num);
        System.out.println("car = " + car);
        System.out.println("className = " + className);
        System.out.println("brand = " + brand);
        System.out.println("power = " + power);
        System.out.println("sumNum = " + sumNum);
        System.out.println("str = " + str);
        System.out.println("arithmeticOperation = " + arithmeticOperation);
        System.out.println("logicOperation = " + logicOperation);
        System.out.println("logicOperation2 = " + logicOperation2);
        System.out.println("ternaryOperator = " + ternaryOperator);
        System.out.println("regularExpression = " + regularExpression);
        System.out.println("stu1 = " + stu1);
        System.out.println("upperCaseName = " + upperCaseName);
        System.out.println("stu2 = " + stu2);
        System.out.println("stuList3 = " + stuList3);
        System.out.println("nameList = " + nameList);
        return "success";
    }

}
