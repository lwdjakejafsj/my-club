package com.luowei.subject.domain.handler;

import com.luowei.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: luowei
 * @Description: 题目类型工厂
 * @DateTime:
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    // 将SubjectTypeHandler的所有实现全部注入
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private HashMap<Integer,SubjectTypeHandler> map = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        subjectTypeHandlerList.forEach((v) -> {
            map.put(v.getHandlerType().getCode(),v);
        });
    }

    public SubjectTypeHandler getSubjectTypeHandler(int subjectInfoType) {
        return map.get(subjectInfoType);
    }
}
