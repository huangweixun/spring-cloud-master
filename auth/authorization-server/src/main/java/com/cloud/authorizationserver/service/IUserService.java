package com.cloud.authorizationserver.service;

import com.cloud.authorizationserver.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User getByUsername(String username);
}
