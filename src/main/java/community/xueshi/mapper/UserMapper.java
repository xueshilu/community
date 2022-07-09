package community.xueshi.mapper;

import community.xueshi.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USERS (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);

    @Select("SELECT * FROM USERS WHERE token = #{token}")
    User findByToken(@Param("token") String token);
}
