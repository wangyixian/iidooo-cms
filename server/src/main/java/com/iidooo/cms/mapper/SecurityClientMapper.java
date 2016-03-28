package com.iidooo.cms.mapper;

import org.apache.ibatis.annotations.Param;

import com.iidooo.cms.model.po.SecurityClient;

public interface SecurityClientMapper {
    int deleteByPrimaryKey(Integer clientID);

    int insert(SecurityClient record);

    int insertSelective(SecurityClient record);

    SecurityClient selectByPrimaryKey(Integer clientID);
    
    /**
     * 通过AppID和Secret查询注册客户端对象
     * @param appID 分配给授权客户端的AppID
     * @param secret 分配给授权客户端的Secret
     * @return 查询活的SecurityClient对象
     */
    SecurityClient selectByAppIDSecret(@Param("appID")String appID, @Param("secret")String secret);

    int updateByPrimaryKeySelective(SecurityClient record);

    int updateByPrimaryKey(SecurityClient record);
}