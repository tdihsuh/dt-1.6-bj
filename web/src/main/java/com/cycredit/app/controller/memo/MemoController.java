package com.cycredit.app.controller.memo;

import com.cycredit.app.controller.memo.pojo.DepartmentItem;
import com.cycredit.app.controller.memo.pojo.DepartmentMergeItem;
import com.cycredit.app.controller.memo.pojo.MemoDetail;
import com.cycredit.app.controller.memo.pojo.MemoItem;
import com.cycredit.app.util.cache.UserInfoCache;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.app.util.threads.UserInfoThreadLocal;
import com.cycredit.base.utils.consts.Response;
import com.cycredit.common.PageInfo;
import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.User;
import com.cycredit.service.MemoDepartmentService;
import com.cycredit.service.MemoService;
import com.cycredit.service.OriginService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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
    @Resource
    OriginService originService;


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
        //TODO 需要调活
        map.put("publishCount", 1);
        map.put("pendingCount", 1);
        return Response.success("成功", map);
    }


    private List<MemoItem> transferToMemoResponseList(List<UniMemo> list) {

        List<MemoItem> memoItemList = Lists.transform(list, x -> {
            MemoItem memoItem = new MemoItem();
            try {
                BeanUtils.copyProperties(memoItem, x);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (x.getOperator() != null) {
                String oid = x.getOperator().toString();
                UserInfo userInfo = UserInfoCache.getFromCache(oid);
                if (userInfo != null) {
                    memoItem.setOperatorName(userInfo.getName());
                }
            }

            return memoItem;

        });
        return memoItemList;
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
        return Response.success("成功", transferToMemoResponseList(list)).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


    /**
     * @return
     */
    @RequestMapping(value = "/pending/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "未发布备忘录列表", httpMethod = "GET", value = "未发布备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object pendingList(Integer pageNum, Integer limitSize) {
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        List<UniMemo> list = memoService.findPendingMemo(pageInfo);
        return Response.success("成功", transferToMemoResponseList(list)).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


    /**
     * @return
     */
    @RequestMapping(value = "/modify/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(notes = "暂存备忘录列表", httpMethod = "GET", value = "暂存备忘录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object modifyList(Integer pageNum, Integer limitSize) {
        PageInfo pageInfo = new PageInfo(pageNum, limitSize);
        List<UniMemo> list = memoService.findModifyMemo(pageInfo);
        return Response.success("成功", transferToMemoResponseList(list)).setPageInfo(pageInfo.getPageNo(), pageInfo.getTotalCount());
    }


    /**
     * @return
     */
    @RequestMapping(value = "/publish", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "发布备忘录", httpMethod = "POST", value = "发布备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object publishMemo(@RequestParam(required = false, value = "id") Long id) {
        memoService.publishMemo(id);
        return Response.success("成功");
    }


    /**
     * @return
     */
    @RequestMapping(value = "/complete", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "完成备忘录", httpMethod = "POST", value = "完成备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object completeMemo(@RequestParam(required = false, value = "id") Long id) {
        memoService.completeMemo(id);
        return Response.success("成功");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/back", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "完成备忘录", httpMethod = "POST", value = "完成备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object back(@RequestParam(required = false, value = "id") Long id) {
        memoService.backMemo(id);
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
        memoDetail.setStatus(uniMemo.getStatus());
        List<DepartmentItem> departmentItems = Lists.newArrayList();

        Map<String, DepartmentItem> map = Maps.newHashMap();

        for (UniMemoDepartment uniMemoDepartment : departmentList) {

            DepartmentItem temp = map.get(uniMemoDepartment.getDepartmentCode());
            if (temp == null) {

                temp = new DepartmentItem();
                temp.setDepartmentCode(uniMemoDepartment.getDepartmentCode());
                temp.setDepartmentName(originService.getDepartment(uniMemoDepartment.getDepartmentCode()).getDepartmentName());
                temp.setMemoId(uniMemoDepartment.getMemoId());
                temp.setDepartmentMergeItemList(Lists.newArrayList());
                departmentItems.add(temp);
                map.put(uniMemoDepartment.getDepartmentCode(), temp);
            }

            DepartmentMergeItem departmentMergeItem = new DepartmentMergeItem();
            departmentMergeItem.setId(uniMemoDepartment.getId());
            departmentMergeItem.setMeasure(uniMemoDepartment.getMeasure());
            departmentMergeItem.setReason(uniMemoDepartment.getReason());

            temp.getDepartmentMergeItemList().add(departmentMergeItem);
        }
        memoDetail.setDepartmentItems(departmentItems);
        return Response.success("成功", memoDetail);

    }


    //------------------------------------------Post-------------------------------------------------------------------

    /**
     * @return
     */
    @RequestMapping(value = "/temporary", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "暂存或者修改备忘录", httpMethod = "POST", value = "暂存或者修改备忘录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false)}
    )
    public Object add(@ApiParam("传入ID时表示修改备忘录") @RequestParam(required = false, value = "id") Long id, @RequestParam(required = false, value = "name") String name, @RequestParam(required = false, value = "type") String type, @RequestParam(required = false, value = "relationDepartment") String relationDepartment, @RequestParam(required = false, value = "tags") String tags, @ApiParam("-1 修改中 0待发布") @RequestParam(defaultValue = "-1") Integer status) {
        if (!(status == 0 || status == -1)) {
            return Response.fail("暂存备忘录失败");
        }


        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setName(name);
        uniMemo.setType(type);
        uniMemo.setRelationDepartment(relationDepartment);
        uniMemo.setTags(tags);
        uniMemo.setStatus(status);

        UserInfo user = UserInfoThreadLocal.getFromThread();
        uniMemo.setOperator(user.getId());
        uniMemo.setOperatrorDepartmentCode(user.getDepartmentCode());
        uniMemo.setOperatorAreaCode(user.getAreaCode());
        uniMemo.setCreateTime(new Date());
        uniMemo.setUpdateTime(new Date());
        memoService.save(uniMemo);

        return Response.success("暂存备忘录成功", uniMemo.getId());

    }


    @RequestMapping(value = "/department/add", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录新增或者修改关联部门措施", httpMethod = "POST", value = "备忘录新增或者修改关联部门措施")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentAdd(@RequestBody String f , @ApiParam("传入ID更新不传入则保存") @RequestParam(required = false, value = "id") Long id, @RequestParam(required = false, value = "memoId") Long memoId, @RequestParam(required = false, value = "departmentCode") String departmentCode, @RequestParam(required = false, value = "measure") String measure, @RequestParam(required = false, value = "reason") String reason) {
        UniMemoDepartment uniMemoDepartment = new UniMemoDepartment();
        uniMemoDepartment.setDepartmentCode(departmentCode);
        uniMemoDepartment.setMeasure(measure);
        uniMemoDepartment.setReason(reason);
        uniMemoDepartment.setCreateTime(new Date());
        uniMemoDepartment.setMemoId(memoId);
        memoDepartmentService.saveDepartment(uniMemoDepartment);


        memoDepartmentService.updateUnimo(memoId);

        return Response.success("成功", uniMemoDepartment.getId());

    }


    @RequestMapping(value = "/department/delete", produces = "application/json;charset=UTF-8")
    @ApiOperation(notes = "备忘录删除关联部门措施", httpMethod = "POST", value = "备忘录删除关联部门措施")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", paramType = "header", value = "token", required = false),
            @ApiImplicitParam(name = "uid", paramType = "header", value = "uid", required = false),
    })
    public Object departmentDelete(@RequestParam(required = false, value = "id") Long id) {
        memoDepartmentService.deleteDepartment(id);
        return Response.success("成功");

    }


}
