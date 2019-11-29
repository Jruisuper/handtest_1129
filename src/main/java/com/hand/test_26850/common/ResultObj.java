package com.hand.test_26850.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录状态
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

    public static final ResultObj LOGIN_SUCCESS=new ResultObj(Constast.OK,"登录成功");
    public static final ResultObj LOGIN_ERROR_PASS=new ResultObj(Constast.ERROR,"登录失败，用户名或密码不正确");

    public static final ResultObj UPDATE_SUCCESS=new ResultObj(Constast.UPDATE_OK,"修改成功");
    public static final ResultObj UPDATE_ERROR=new ResultObj(Constast.UPDATE_ERROR,"修改失败");

    public static final ResultObj ADD_SUCCESS=new ResultObj(Constast.ADD_OK,"增加成功");
    public static final ResultObj ADD_ERROR=new ResultObj(Constast.ADD_ERROR,"增加失败");

    public static final ResultObj  DELETE_SUCCESS=new ResultObj(Constast.OK, "删除成功");
    public static final ResultObj  DELETE_ERROR=new ResultObj(Constast.ERROR, "删除失败");

    private Integer code;
    private String msg;

}
