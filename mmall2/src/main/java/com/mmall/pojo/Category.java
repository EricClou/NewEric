package com.mmall.pojo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor     //无参构造
@AllArgsConstructor    //全参构造
@EqualsAndHashCode(of = "id")   //利用注解重写equals方法，of代表着只从这一个属性上来判断
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}