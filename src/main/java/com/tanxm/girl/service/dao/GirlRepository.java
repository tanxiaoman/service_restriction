package com.tanxm.girl.service.dao;

import com.tanxm.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过名字和年龄查询
    public List<Girl> findByNameAndAge(String name,Integer age);
}
