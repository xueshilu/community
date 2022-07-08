package community.xueshi.mapper;

import community.xueshi.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIED) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
