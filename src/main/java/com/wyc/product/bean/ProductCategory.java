package com.wyc.product.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 文永川
 * @data 2018/10/11 2:15
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    @Id
    @GeneratedValue
    private  Integer categoryId;
    private  String categoryName;
    private  Integer categoryType;
    private  Date createTime;
    private  Date updateTime;

}
