package community.xueshi.dto;

import community.xueshi.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtcreator;
    private Long gmtmodified;
    private Integer creator;
    private Integer viewcount;
    private Integer commentcount;
    private int likecount;
    private User user;
}
