package com.tanxm.girl.service;

import com.tanxm.girl.domain.Girl;
import com.tanxm.girl.enums.ResultEnum;
import com.tanxm.girl.exception.GirlException;
import com.tanxm.girl.service.dao.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setName("Tom");
        girlA.setAge(15);
        girlA.setCupSize("F");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("Alis");
        girlB.setAge(19);
        girlB.setCupSize("A");
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age=girl.getAge();
        if(age<10){
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            //返回你可能在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * @Method_name: findOne
     * @Description: 通过Id查询一个女生的信息
     * @author 谭小曼
     * @date 2019/1/22 12:22
     * @version V1.0
     */
    public Girl findOne(Integer id){
        return girlRepository.getOne(id);
    }
}
