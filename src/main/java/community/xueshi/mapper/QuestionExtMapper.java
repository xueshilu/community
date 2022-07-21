package community.xueshi.mapper;

import community.xueshi.model.Question;


public interface QuestionExtMapper {
    int incView(Question record);

    int incComment(Question record);
}