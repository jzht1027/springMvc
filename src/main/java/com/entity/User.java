package com.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class User {
    @NotEmpty(message = "不允许为空")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "需输入范围为0-9a-zA-Z")
    public String name;
    @NumberFormat(pattern = "#,###.##")
    public Double balance;   // 余额  10.000.00
    @Past(message = "生日不能超过当前时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public Date birthday;
    @Min(value = 0,message = "年龄最小{value}")
    @Max(value = 100,message = "年龄最大{value}")
    public Integer age;
    @Range(min = 1000, max = 20000, message = "工资范围为{min}和{max}之间")
//    @NumberFormat(style = NumberFormat.Style.CURRENCY) //货币
    public BigDecimal salary; //工资  ￥5000
    public String[] hobbies;
    @Range(min = 0,max = 1,message = "百分比在{min}和{max}之间")
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    public Double taskCount;  //百分比

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Double getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Double taskCount) {
        this.taskCount = taskCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", birthday=" + birthday +
                ", age=" + age +
                ", salary=" + salary +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", taskCount=" + taskCount +
                '}';
    }
}
