package com.luowei.subject.domain.convert;

import com.luowei.subject.domain.entity.SubjectAnswerBO;
import com.luowei.subject.domain.entity.SubjectInfoBO;
import com.luowei.subject.domain.entity.SubjectOptionBO;
import com.luowei.subject.infra.basic.entity.SubjectBrief;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-18T23:36:00+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class SubjectBriefConverterImpl implements SubjectBriefConverter {

    @Override
    public SubjectBrief convertBOToEntity(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        subjectBrief.setId( subjectInfoBO.getId() );
        subjectBrief.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );

        return subjectBrief;
    }

    @Override
    public List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectBrief> subjectBriefList) {
        if ( subjectBriefList == null ) {
            return null;
        }

        List<SubjectAnswerBO> list = new ArrayList<SubjectAnswerBO>( subjectBriefList.size() );
        for ( SubjectBrief subjectBrief : subjectBriefList ) {
            list.add( subjectBriefToSubjectAnswerBO( subjectBrief ) );
        }

        return list;
    }

    @Override
    public SubjectOptionBO convertEntityToOptionBO(SubjectBrief subjectBrief) {
        if ( subjectBrief == null ) {
            return null;
        }

        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();

        subjectOptionBO.setSubjectAnswer( subjectBrief.getSubjectAnswer() );

        return subjectOptionBO;
    }

    protected SubjectAnswerBO subjectBriefToSubjectAnswerBO(SubjectBrief subjectBrief) {
        if ( subjectBrief == null ) {
            return null;
        }

        SubjectAnswerBO subjectAnswerBO = new SubjectAnswerBO();

        return subjectAnswerBO;
    }
}
