package com.cycredit.app.controller.memo;

import com.cycredit.base.utils.consts.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyubin on 2017/11/23 0023.
 *
 * @author qiyubin
 */

@RestController
@RequestMapping(value = "/api/memo")
@ResponseBody
@Api(value = "memo", description = "备忘录接口")
public class MemoController {


    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/publish/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "已发布备忘录列表", httpMethod = "GET", value = "已发布备忘录列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
//            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
//    })
    public Object publishList(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }


    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/pending/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "未发布备忘录列表", httpMethod = "GET", value = "已发布备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object list(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");
    }

    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/drafts/list", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "暂存备忘录", httpMethod = "GET", value = "暂存备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object add(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");

    }

    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/publish", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "发布备忘录", httpMethod = "GET", value = "暂存备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object pass(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");

    }


    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "修改备忘录", httpMethod = "GET", value = "修改备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object update(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");

    }


    @RequestMapping(value = "/department/add", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录新增关联部门", httpMethod = "GET", value = "备忘录新增关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentAdd(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");

    }


    @RequestMapping(value = "/department/delete", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录删除关联部门", httpMethod = "GET", value = "备忘录删除关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentDelete(String pid) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return Response.success("成功");

    }


}
