package community.xueshi.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private long parentId;
    private String content;
    private Integer parentType;
}
