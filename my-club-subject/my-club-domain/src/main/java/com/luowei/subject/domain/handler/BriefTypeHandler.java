package com.luowei.subject.domain.handler;

import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.common.enums.SubjectInfoTypeEnum;
import com.luowei.subject.domain.convert.SubjectBriefConverter;
import com.luowei.subject.domain.convert.SubjectJudgeConverter;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectBrief;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import com.luowei.subject.infra.basic.service.SubjectBriefService;
import com.luowei.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: luowei
 * @Description: 判断题策略类
 * @DateTime:
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //简答题目的插入
        SubjectBrief subjectBrief = SubjectBriefConverter.INSTANCE
                .convertBOToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        subjectBriefService.insert(subjectBrief);
    }
    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(Long.valueOf(subjectId));
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = SubjectBriefConverter.INSTANCE.convertEntityToOptionBO(result);
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
