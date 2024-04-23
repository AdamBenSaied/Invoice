package com.example.Invoice.service;

import com.example.Invoice.model.WVO.UserWVO;
import com.example.Invoice.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

}
