package com.luowei.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.luowei.subject.application.convert.SubjectCategoryDTOConverter;
import com.luowei.subject.application.dto.SubjectCategoryDTO;
import com.luowei.subject.common.entity.Result;
import com.luowei.subject.domain.convert.SubjectCategoryConverter;
import com.luowei.subject.domain.entity.SubjectCategoryBO;
import com.luowei.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: luowei
 * @Description: 分类接口
 * @DateTime:
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto: {}",subjectCategoryDTO);
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToBO(subjectCategoryDTO);
            subjectCategoryDomainService.insert(subjectCategoryBO);
            return Result.ok(true);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.fail(false);
        }
    }

    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService
                    .queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                    .convertBOListToDTOList(subjectCategoryBOList);
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.dto: {}",subjectCategoryDTOList);
            }
            return Result.ok(subjectCategoryBOList);
        }catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto: {}"
                        , JSON.toJSONString(subjectCategoryDTO));
            }
            //TODO 需要校验 parent_id不能为空

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService
                    .queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                    .convertBOListToDTOList(subjectCategoryBOList);
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto: {}",subjectCategoryDTOList);
            }
            return Result.ok(subjectCategoryBOList);
        }catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 更新分类
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDTOToBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新分类失败");
        }
    }

    /**
     * 删除分类
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDTOToBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除分类失败");
        }
    }
}
