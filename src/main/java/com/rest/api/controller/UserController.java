package com.rest.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Result;
import com.rest.api.model.User;
import com.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @ClassName: UserController   
 * @Description: Rest接口
 * @author yuting.li
 * @version 1.0 
 * @date 2017年8月12日 下午4:42:23
 */
@Api(value = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

	// 列出某个类目的所有规格
	@ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Result<List<User>> list(
			@ApiParam(value = "分类ID", required = false) @RequestParam(required=false) Long categoryId,
			@ApiParam(value = "分类ID", required = false) @RequestParam(required=false) Long categoryId2,
			@ApiParam(value = "token", required = true) @RequestParam String token) {
		Result<List<User>> ru = new Result<>();
		ru.setSuccessInfo(200, "success", getUserList());
		return ru;
	}

	@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Object> add(@RequestBody User user) {
		String u = findUser(user);
		return ResultUtil.setData(u, 1, "success");
	}

	private String findUser(User user) {
		user.setToken("userToken");
		String token = user.getToken();
		return token;
	}
	
	private List<User> getUserList(){
		List<User> list = new ArrayList<>();
		for(int i = 0;i<30;i++) {
			User user = new User();
			user.setName("用户"+i);
			user.setToken("token_"+(new Random().nextInt(10000)*9+1));
			user.setSex(i % 2 == 0 ? 1 : 2);// 1男 2女
			user.setV("v-"+i);
			list.add(user);
		}
		return list;
	}
	
}