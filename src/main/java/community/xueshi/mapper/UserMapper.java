package community.xueshi.mapper;

import community.xueshi.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USERS (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED,AVATAR_URL) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);
    @Select("SELECT * FROM USERS WHERE token = #{token}")
    User findByToken(@Param("token") String token);
    @Select("SELECT * FROM USERS WHERE id = #{id}")
    User findById(@Param("id") Integer id);
    @Select("SELECT * FROM USERS WHERE ACCOUNT_ID = #{account_id}")
    User findByAccountId(@Param("account_id") String account_id);
    @Update("update USERS set NAME = #{name},TOKEN=#{token},GMT_CREATE =#{gmt_create},GMT_MODIFIED=#{gmt_modified}, AVATAR_URL=#{avatar_url} WHERE ACCOUNT_ID = #{account_id}")
    void update(User dbUser);
}
