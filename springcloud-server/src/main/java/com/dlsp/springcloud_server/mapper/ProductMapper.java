package com.dlsp.springcloud_server.mapper;

import com.dlsp.springcloud_server.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    @Select("select pid, pname, price from product where pid in (select pid from user inner join access on user.uid=access.uid where user.uid=${uid})")
    List<Product> getProductsByUid(Integer uid);
}
