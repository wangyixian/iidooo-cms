-- -----------------------------------------------------
-- IDO_DICT_TYPE的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', '内容标签', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_COMMON', '内容通用字典', '', now(), 1, now(), 1, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_CLASS的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_MAIL', '邮件配置', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_LANG', '语言类型', '', now(), 1, now(), 1, 0, 1);



-- 在线动漫标签类
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_COMIC_STATUS', '动漫状态', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_COMIC_TYPE', '动漫类型', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_LETTER', '首字母', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_COUNTRY', '区域国家', '', now(), 1, now(), 1, 0, 1);

-- 通用类型
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_COMMON', 'COMMON_STATISTICS_TYPE', '统计类型', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_COMMON', 'ATTACH_ALBUM_CLASSIFY', '专辑分类', '', now(), 1, now(), 1, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_ITEM的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_SMTP', 'SMTP服务器地址', 'mail.iidooo.com', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_FROM', '邮件来自', 'cms@iidooo.com', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_PASSWORD', '邮件密码', MD5('111111'), 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_VALIDATOR', '邮件认证', 'true', 4, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_FORMAT', '邮件格式', 'iidooo.com', 5, 0, '', now(), 1, now(), 1, 0, 1);



INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ZHCN', '简体中文', 'zh_CN', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ZHTW', '繁體中文', 'zh_TW', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_JAPANESE', '日本語', 'ja_JP', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ENGLISH', 'English', 'en_US', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 动漫状态
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_STATUS', '1', '连载', '连载', 1, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_STATUS', '2', '完结', '完结', 2, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_STATUS', '3', '新番', '新番', 3, 0, '', now(), 1, now(), 1, 0, 1);

-- 动漫类型
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '1', '热血', '热血', 1, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '2', '冒险', '冒险', 2, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '3', '搞笑', '搞笑', 3, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '4', '奇幻', '奇幻', 4, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '5', '科幻', '科幻', 5, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '6', '爱情', '爱情', 6, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '7', '推理', '推理', 7, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '8', '竞技', '竞技', 8, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '9', '魔幻', '魔幻', 9, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '10', '校园', '校园', 10, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '11', '恐怖', '恐怖', 11, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '12', '悬疑', '悬疑', 12, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '13', '后宫', '后宫', 13, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '14', '历史', '历史', 14, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '15', '战争', '战争', 15, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '16', '青春', '青春', 16, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COMIC_TYPE', '17', '治愈', '治愈', 17, 0, '', now(), 1, now(), 1, 0, 1);

-- 首字母
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'A', 'A', 'A', 1, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'B', 'B', 'B', 2, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'C', 'C', 'C', 3, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'D', 'D', 'D', 4, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'E', 'E', 'E', 5, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'F', 'F', 'F', 6, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'G', 'G', 'G', 7, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'H', 'H', 'H', 8, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'I', 'I', 'I', 9, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'J', 'J', 'J', 10, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'K', 'K', 'K', 11, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'L', 'L', 'L', 12, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'M', 'M', 'M', 13, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'N', 'N', 'N', 14, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'O', 'O', 'O', 15, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'P', 'P', 'P', 16, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'Q', 'Q', 'Q', 17, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'R', 'R', 'R', 18, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'S', 'S', 'S', 19, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'T', 'T', 'T', 20, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'U', 'U', 'U', 21, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'V', 'V', 'V', 22, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'W', 'W', 'W', 23, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'X', 'X', 'X', 24, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'Y', 'Y', 'Y', 25, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_LETTER', 'Z', 'Z', 'Z', 26, 0, '', now(), 1, now(), 1, 0, 1);

-- 区域国家
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COUNTRY', '1', '日本', '日本', 1, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COUNTRY', '2', '港台', '港台', 2, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COUNTRY', '3', '大陆', '大陆', 3, 0, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_COUNTRY', '4', '欧美', '欧美', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 统计类型
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'COMMON_STATISTICS_TYPE', '1', 'PV', 'PV', 1, 0, '', now(), 1, now(), 1, 0, 1);

-- 专辑类型
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'ATTACH_ALBUM_CLASSIFY', '1', '正篇', '正篇', 1, 0, '', now(), 1, now(), 1, 0, 1);