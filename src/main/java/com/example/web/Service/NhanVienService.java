package com.example.web.Service;

import com.example.web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {
    @Autowired
    UserRepository nhanVienRepository;


}
