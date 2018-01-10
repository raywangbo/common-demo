package com.ray.service.impl;

import com.ray.entity.Admin;
import com.ray.mapper.AdminMapper;
import com.ray.mapper.BaseMapper;
import com.ray.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ${DESCRIPTION}
 *
 * @author Ray
 * @date 2018/1/10 14:37
 */
@Service
public class AdminService extends BaseService<Admin,AdminMapper>  implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public AdminMapper getMapper() {
        return adminMapper;
    }
}
