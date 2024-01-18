package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.infra.basic.entity.SubjectJudge;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-18T23:36:00+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class SubjectJudgeConverterImpl implements SubjectJudgeConverter {

    @Override
    public List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList) {
        if ( subjectJudgeList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectJudgeList.size() );
        for ( SubjectJudge subjectJudge : subjectJudgeList ) {
            list.add( subjectJudgeToSubjectAnswerBO( subjectJudge ) );
        }

        return list;
    }

    protected SubjectAnswerBO subjectJudgeToSubjectAnswerBO(SubjectJudge subjectJudge) {
        if ( subjectJudge == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        subjectAnswerBO.setIsCorrect( subjectJudge.getIsCorrect() );

        return subjectAnswerBO;
    }
}
