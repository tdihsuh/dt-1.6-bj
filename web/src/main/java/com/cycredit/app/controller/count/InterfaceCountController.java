package com.cycredit.app.controller.count;

import com.cycredit.app.util.authc.SecurityUtils;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.service.AreaRankService;
import com.cycredit.service.DepartmentRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyubin on 2017/11/9 0009.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "/api/count")
@ResponseBody
@Api(value = "count", description = "统计接口")
public class InterfaceCountController {

    @Resource
    AreaRankService areaRankService;
    @Resource
    DepartmentRankService departmentRankService;


    @RequestMapping(value = "/areaRank", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "地区排名", httpMethod = "GET", value = "地区排名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token"),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid"),
    })
    public Object areaRank() {

        return Response.success("成功", areaRankService.findAll());
    }

    @RequestMapping(value = "/departmentRank", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "部门排名", httpMethod = "GET", value = "部门排名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token"),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid"),
    })
    public Object departmentRank() {
        SecurityUtils.fetchCurrentUserToken();
        return Response.success("成功", departmentRankService.findAll());
    }


}
