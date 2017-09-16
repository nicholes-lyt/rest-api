package com.rest.api.model;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: User   
 * @Description: 用户
 * @author yuting.li
 * @version 1.0 
 * @date 2017年8月12日 下午4:40:58
 */
@ApiModel(value = "用户对象", description = "user2")
public class User{

	@ApiModelProperty(value = "姓名", required = true)
	@NotBlank(message="姓名不能为空!")
	private String name;
	
	@ApiModelProperty(value = "密码", required = true)
	private String password;

	@ApiModelProperty(value = "性别")
	private Integer sex;
	
	@ApiModelProperty(value = "票据", required = true)
	@NotBlank(message="票据不能为空!")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}
