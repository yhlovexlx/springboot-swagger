package com.jeecx.web;

import com.jeecx.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ===========================
 * Created with IntelliJ IDEA.
 * User：yanghl
 * Date：2018/3/6
 * Time：16:09
 * ===========================
 */
@RestController
public class UserController {

    //创建线程安全的Map
    private static Map<Integer,User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    static {
        User tom = new User();
        tom.setIdCard("111111");
        tom.setName("汤姆");
        users.put(1,tom);
        User lucy = new User();
        lucy.setIdCard("222222");
        lucy.setName("撸屎");
        users.put(2,lucy);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id){
//        System.out.println("2222");
        return users.get(id);

    }


}
