package com.luowei.subject.domain.handler;

import com.luowei.subject.common.enums.IsDeleteEnum;
import com.luowei.subject.common.enums.SubjectInfoTypeEnum;
import com.luowei.subject.domain.convert.SubjectJudgeConverter;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
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
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeleteEnum.UN_DELETE.getCode());
        subjectJudgeService.insert(subjectJudge);
    }
    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = SubjectJudgeConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
