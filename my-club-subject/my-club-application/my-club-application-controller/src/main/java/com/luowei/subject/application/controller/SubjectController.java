package com.luowei.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.luowei.subject.application.convert.SubjectAnswerDTOConverter;
import com.luowei.subject.application.convert.SubjectInfoDTOConverter;
import com.luowei.subject.application.dto.SubjectInfoDTO;
import com.luowei.subject.common.entity.Result;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.service.SubjectInfoDomainService;
import com.luowei.subject.infra.basic.entity.SubjectCategory;
import com.luowei.subject.infra.basic.entity.SubjectInfo;
import com.luowei.subject.infra.basic.service.SubjectCategoryService;
import com.luowei.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                    , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                    , "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOList =
                    SubjectAnswerDTOConverter.INSTANCE.convertDTOListToBOList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOList);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }
}
