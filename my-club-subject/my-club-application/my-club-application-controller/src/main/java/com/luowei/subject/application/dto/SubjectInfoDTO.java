package com.luowei.subject.application.dto;

import com.luowei.subject.common.entity.PageInfo;
import com.luowei.subject.domain.entity.SubjectAnswerBO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 分类id
     */
    private List<Long> categoryIds;
    /**
     * 标签id
     */
    private List<Long> labelIds;
    /**
     * 标签name
     */
    private List<String> labelName;
    /**
     * 答案选项
     */
    private List<SubjectAnswerDTO> optionList;

    //用来进行题目列表查询的时候使用
    private Long categoryId;
    private Long labelId;
}