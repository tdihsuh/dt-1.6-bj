package com.cycredit.app.controller.memo;

import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.User;
import com.cycredit.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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


    @Resource
    MemoService memoService;

    /**
     * @param pid
     * @return
     */
    @RequestMapping(value = "/publish/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "已发布备忘录列表", httpMethod = "GET", value = "已发布备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object publishList(String pid) {
        List<UniMemo> list = memoService.findPublishMemo();
        return Response.success("成功", list);
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
        List<UniMemo> list = memoService.findPendingMemo();

        return Response.success("成功", list);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/temporary", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "暂存或者修改备忘录", httpMethod = "GET", value = "暂存或者修改备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object add(Long id, String name, String type, String relationDepartment, String tag) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setName(name);
        uniMemo.setType(type);
        uniMemo.setRelationDepartment(relationDepartment);
        uniMemo.setTag(tag);
        uniMemo.setStatus(0);

        User user = UserInfoThreadLocal.getFromThread();
        uniMemo.setOperator(user.getId());
        uniMemo.setOperatrorDepartment(user.getDepartment());
        uniMemo.setOperatorArea(user.getArea());

        memoService.save(uniMemo);

        return Response.success("暂存备忘录成功");

    }

    /**
     * @return
     */
    @RequestMapping(value = "/publish", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "发布备忘录", httpMethod = "GET", value = "发布备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object pass(Long id) {
        memoService.publishMemo(id);
        return Response.success("成功");

    }



    @RequestMapping(value = "/department/add", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录新增关联部门", httpMethod = "GET", value = "备忘录新增关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentAdd(String pid) {

        return Response.success("成功");

    }


    @RequestMapping(value = "/department/delete", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录删除关联部门", httpMethod = "GET", value = "备忘录删除关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentDelete(String pid) {

        return Response.success("成功");

    }


}
