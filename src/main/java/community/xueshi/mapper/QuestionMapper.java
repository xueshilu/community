package community.xueshi.mapper;

import community.xueshi.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO QUESTION (TITLE, DESCRIPTION, GMT_CREATE, GMT_MODIFIED, CREATOR, TAG) VALUES (${title},${description},${gmt_create},${gmt_modified},${creator},${tag})")
    public void create(Question question);

    @Insert("INSERT INTO QUESTION (TITLE) VALUES (${title})")
    public void create2(Question question);

}
