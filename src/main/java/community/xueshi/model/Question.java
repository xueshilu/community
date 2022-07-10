package community.xueshi.model;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer view_count;
    private Integer comment_count;
    private int like_count;
}
