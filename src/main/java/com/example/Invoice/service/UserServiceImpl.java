package com.example.Invoice.service;

import com.example.Invoice.model.VO.UserVO;
import com.example.Invoice.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserVO saveUser(UserVO userVO) {
        return userRepository.saveAndFlush(userVO);
    }


    public UserVO saveUserIfDoesNotExist(UserVO userVO) {
        Optional<UserVO> userVOOptional = userRepository.findByNameAndSurname(userVO.getName(),userVO.getSurname());
        if (userVOOptional.isPresent()) {
            return userVOOptional.get();
        } else {
            return userVO;
        }
    }

}
