package com.tanxm.girl.controller;

import com.tanxm.girl.domain.Girl;
import com.tanxm.girl.domain.Result;
import com.tanxm.girl.service.GirlService;
import com.tanxm.girl.service.dao.GirlRepository;
import com.tanxm.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

    /**
    * @Title: GirlController
    * @Package com.tanxm.girl.controller
    * @Description: 女生控制器
    * @author 谭小曼
    * @date 2019/1/18 16:27
    * @version V1.0
    */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * @Method_name: girlList
     * @Description: 查询所有女生列表
     * @author 谭小曼
     * @date 2019/1/18 16:27
     * @version V1.0
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("开始执行业务逻辑!");
        return girlRepository.findAll();
    }

    /**
    * @Method_name: girlAdd
    * @Description: 添加一个女生
    * @author 谭小曼
    * @date 2019/1/18 16:35
    * @version V1.0
    */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setName(girl.getName());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * @Method_name: girlFindOne
     * @Description: 通过Id查询一个女生
     * @author 谭小曼
     * @date 2019/1/18 18:31
     * @version V1.0
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    /**
     * @Method_name: girlUpdate
     * @Description: 更新
     * @author 谭小曼
     * @date 2019/1/18 18:31
     * @version V1.0
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age,
                           @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * @Method_name: girlDelete
     * @Description: 删除
     * @author 谭小曼
     * @date 2019/1/18 18:31
     * @version V1.0
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * @Method_name: girlListByNameAndAge
     * @Description: 通过名字和年龄查询女生
     * @author 谭小曼
     * @date 2019/1/18 19:23
     * @version V1.0
     */
    @GetMapping(value = "/girls/NameAge/{name}/{age}")
    public List<Girl> girlListByNameAndAge(@PathVariable("name") String name,
                                           @PathVariable("age") Integer age){
        return girlRepository.findByNameAndAge(name,age);
    }

    /**
     * @Method_name: addGirlTwo
     * @Description: 同时插入两个女生
     * @author 谭小曼
     * @date 2019/1/18 19:39
     * @version V1.0
     */
    @PostMapping(value = "/girls/addTwo")
        public void addGirlTwo(){
        girlService.insertTwo();
    }

    /**
     * @Method_name: getAge
     * @Description: 获取女生的年龄并判断属于哪个区间
     * @author 谭小曼
     * @date 2019/1/19 19:42
     * @version V1.0
     */
    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
