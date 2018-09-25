package com.original.service.service;

import com.original.bean.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * UserService
 *
 * @author luhangqi
 * @date 2018/9/25
 */
public interface UserService {

    List<User> list();
}
