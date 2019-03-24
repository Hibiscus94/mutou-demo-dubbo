package com.mutou.dubbo.demo.service;

import com.mutou.dubbo.demo.api.dto.business.UserDTO;
import com.mutou.dubbo.demo.api.dto.common.Result;
import com.mutou.dubbo.demo.api.service.UserService;
import com.mutou.dubbo.demo.dao.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.service <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
public class UserServiceImpl implements UserService {

    private static final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private static final AtomicLong userIdGenerator = new AtomicLong(0);

    @Override
    public Long addUser(String name,Integer age,String sex) {
        User user = new User();
        user.setId(userIdGenerator.incrementAndGet());
        user.setAge(age);
        user.setName(name);
        user.setSex(sex);
        userMap.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public Result<UserDTO> getUser(Long id) {
        Result<UserDTO> result = new Result<>();
        User user = userMap.get(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(user.getAge());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSex(user.getSex());
        result.success(userDTO);
        result.setCode("0");
        result.setDescription("");
        return result;
    }
}
