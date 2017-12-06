package com.cycredit.app.controller.memo;

import com.cycredit.app.controller.memo.pojo.DepartmentItem;
import com.cycredit.app.controller.memo.pojo.MemoDetail;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.common.PageInfo;
import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.User;
import com.cycredit.service.MemoDepartmentService;
import com.cycredit.service.MemoService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    MemoDepartmentService memoDepartmentService;


    /**
     * @return
     */
    @RequestMapping(value = "/count", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "备忘录数量", httpMethod = "GET", value = "备忘录数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object count() {
        Map map = Maps.newHashMap();
        //todo 需要调活
        map.put("publishCount", 1);
        map.put("pendingCount", 1);
        return Response.success("成功", map);
    }


    /**
     * @return
     */
    @RequestMapping(value = "/publish/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "已发布备忘录列表", httpMethod = "GET", value = "已发布备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object publishList(Integer pageNum, Integer limitSize) {
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        List<UniMemo> list = memoService.findPublishMemo(pageInfo);
        //todo 需要调活分页
        return Response.success("成功", list).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


    /**
     * @return
     */
    @RequestMapping(value = "/pending/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "未发布备忘录列表", httpMethod = "GET", value = "已发布备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object list(Integer pageNum, Integer limitSize) {
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        List<UniMemo> list = memoService.findPendingMemo(pageInfo);
        //todo 需要调活分页
        return Response.success("成功", list).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
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
    public Object add(Long id, String name, String type, String relationDepartment, String tags) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setName(name);
        uniMemo.setType(type);
        uniMemo.setRelationDepartment(relationDepartment);
        uniMemo.setTags(tags);
        uniMemo.setStatus(0);

        User user = UserInfoThreadLocal.getFromThread();
        uniMemo.setOperator(user.getId());
        uniMemo.setOperatrorDepartmentCode(user.getDepartmentCode());
        uniMemo.setOperatorAreaCode(user.getAreaCode());

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


    @RequestMapping(value = "/detail", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录详情", httpMethod = "GET", value = "备忘录详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object detail(Long id) {

        UniMemo uniMemo = memoService.findById(id);

        if (uniMemo == null) {
            return Response.fail("查不到相应备忘录信息");
        }

        List<UniMemoDepartment> departmentList = memoDepartmentService.findMemoDepartment(id);
        MemoDetail memoDetail = new MemoDetail();
        memoDetail.setId(uniMemo.getId());
        memoDetail.setName(uniMemo.getName());
        memoDetail.setRelationDepartment(uniMemo.getRelationDepartment());
        memoDetail.setTags(uniMemo.getTags());
        memoDetail.setType(uniMemo.getType());

        List<DepartmentItem> departmentItems = Lists.newArrayList();

        for (UniMemoDepartment uniMemoDepartment : departmentList) {
            DepartmentItem temp = new DepartmentItem();
            temp.setDepartmentCode(uniMemoDepartment.getDepartmentCode());
            //TODO 需要翻译
            temp.setDepartmentName("省环保厅");
            temp.setMeasure(uniMemoDepartment.getMeasure());
            temp.setMemoId(uniMemoDepartment.getMemoId());
            temp.setReason(uniMemoDepartment.getReason());
            temp.setId(uniMemoDepartment.getId());
            departmentItems.add(temp);
        }
        memoDetail.setDepartmentItems(departmentItems);

        return Response.success("成功", memoDetail);

    }


    @RequestMapping(value = "/department/add", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录新增关联部门", httpMethod = "GET", value = "备忘录新增关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentAdd(Long memoId, String departmentCode, String measure, String reason) {
        UniMemoDepartment uniMemoDepartment = new UniMemoDepartment();
        uniMemoDepartment.setDepartmentCode(departmentCode);
        uniMemoDepartment.setMeasure(measure);
        uniMemoDepartment.setReason(reason);
        uniMemoDepartment.setCreateTime(new Date());
        uniMemoDepartment.setMemoId(memoId);
        memoDepartmentService.saveDepartment(uniMemoDepartment);
        return Response.success("成功");

    }


    @RequestMapping(value = "/department/delete", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录删除关联部门", httpMethod = "GET", value = "备忘录删除关联部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentDelete(Long id) {
        memoDepartmentService.deleteDepartment(id);
        return Response.success("成功");

    }


}
