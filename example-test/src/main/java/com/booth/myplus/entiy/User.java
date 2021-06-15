package com.booth.myplus.entiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/11:47
 * @Description: //TODO
 */
@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = -4779287878298283666L;

	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "id")
	private Integer id;
	private String username;
	private String password;
	private String birthday;
}
