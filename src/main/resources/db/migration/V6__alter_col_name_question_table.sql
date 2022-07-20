
alter table QUESTION alter column GMT_CREATE rename to "gmtCreator";

alter table QUESTION alter column GMT_MODIFIED rename to "gmtModified";

alter table QUESTION alter column COMMENT_COUNT rename to "commentCount";

alter table QUESTION alter column VIEW_COUNT rename to "viewCount";

alter table QUESTION alter column LIKE_COUNT rename to "likeCount";

