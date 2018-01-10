package com.ray.mapper;

import com.ray.entity.Role;

public interface RoleMapper extends BaseMapper<Role>
{
    java.util.List<Role> getByAdminId(Integer adminId);
}
