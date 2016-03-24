package com.iidooo.cms.mapper;

import com.iidooo.cms.model.po.SecurityUser;
import com.iidooo.cms.model.vo.SecurityUserInfo;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(SecurityUser user);

    /**
     * 插入一个SecurityUser
     * @param user 该记录的信息会被插入
     * @return 返回影响行数以判断是否插入成功
     */
    int insertSelective(SecurityUser user);

    /**
     * 通过用户主键ID获得UserInfo对象
     * @param userID 用户主键ID
     * @return SecurityUserInfo对象
     */
    SecurityUserInfo selectByUserID(Integer userID);

    int updateByUserIDSelective(SecurityUser user);

    int updateByPrimaryKey(SecurityUser record);
}