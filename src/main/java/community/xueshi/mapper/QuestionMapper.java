package community.xueshi.mapper;

import community.xueshi.dto.QuestionDTO;
import community.xueshi.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO QUESTION (TITLE, DESCRIPTION, GMT_CREATE, GMT_MODIFIED, CREATOR, TAG) VALUES (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    public void create(Question question);

    @Select("SELECT * FROM QUESTION LIMIT #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("SELECT COUNT(1) FROM QUESTION")
    Integer count();
    @Select("SELECT * FROM QUESTION WHERE creator = #{userId} LIMIT #{offset}, #{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);
    @Select("SELECT COUNT(1) FROM QUESTION WHERE creator = #{userId}  ")
    Integer countByUserId(@Param(value = "userId") Integer userId);

    @Select("SELECT * FROM QUESTION WHERE id = #{id}")
    Question getById(@Param("id")Integer id);

    @Update("UPDATE QUESTION SET TITLE = #{title}, DESCRIPTION = #{description},GMT_CREATE = #{gmt_create}, GMT_MODIFIED = #{gmt_modified}, TAG = #{tag} WHERE id = #{id}")
    void update(Question question);
}
