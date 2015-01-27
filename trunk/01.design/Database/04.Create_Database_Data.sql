-- IDO_DICT_TYPE
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', '系统配置', 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PROPERTIES', '扩展字段配置', 2, '', now(), 1, now(), 1, 0, 1);

-- IDO_DICT_CLASS
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_PAGING', '分页配置', 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_SITE', '站点配置', 2, '', now(), 1, now(), 1, 0, 1);

-- FIELD_PROPERTIES
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PROPERTIES', 'FIELD_PRODUCT_TYPE', '产品类型', 3, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PROPERTIES', 'FIELD_PRODUCT_COUNTRY', '产品国家', 4, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PROPERTIES', 'FIELD_PRODUCT_ORIGIN', '产品产地', 5, '', now(), 1, now(), 1, 0, 1);

-- IDO_DICT_ITEM
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('PROPERTIES_PAGING', 'PAGE_SIZE', '每页显示总行数', '20', 1, 0, 0, 0, '', now(), 1, now(), 1, 0, 1);

-- PROPERTIES_SITE
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('PROPERTIES_SITE', 'SITE_URL', '网址', 'http://localhost:8080/cms', 1, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('PROPERTIES_SITE', 'SITE_NAME', 'INABA进口红酒品尊', 'INABA进口红酒品尊', 2, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('PROPERTIES_SITE', 'SITE_RES_ROOT', '资源根目录', 'http://localhost:8080/cms/templates/inaba/res', 3, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('PROPERTIES_SITE', 'CONTENT_RES_ROOT', '内容资源根目录', 'http://localhost:8080/cms/res', 4, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);

-- FIELD_PRODUCT_TYPE
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_TYPE', '1', '红酒', '红酒', 1, 1, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_TYPE', '2', '干白', '干白', 2, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_TYPE', '3', '起泡酒', '起泡酒', 3, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_TYPE', '4', '冰酒', '冰酒', 4, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
-- FIELD_PRODUCT_COUNTRY
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '1', '法国', '法国', 1, 1, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '2', '德国', '德国', 2, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '3', '意大利', '意大利', 3, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '4', '西班牙', '西班牙', 4, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
-- FIELD_PRODUCT_ORIGIN
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '1', '法国罗纳河谷', '法国罗纳河谷', 1, 1, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '2', '法国产区桃红葡萄酒', '法国产区桃红葡萄酒', 2, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '3', '法国优质产区原装干红', '法国优质产区原装干红', 3, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '4', '法国波尔多产区', '法国波尔多产区', 4, 0, 0, 0,'', now(), 1, now(), 1, 0, 1);

-- IDO_FIELD_MODEL
INSERT INTO `IDO_FIELD_MODEL` (`ModelName`, `ModelType`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`) 
VALUES ('产品', 1, 1, '', now(), 1, now(), 1, 0);

-- IDO_SECURITY_USER
INSERT INTO `IDO_SECURITY_USER` 
(`UserName`, `LoginID`, `Password`, `LoginTime`, `IsDisable`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('超级管理员', 'admin', md5(111111), now(), 0, '', now(), 1, now(), 1, 0, 1);

-- IDO_CMS_USER
INSERT INTO `IDO_CMS_USER` (`UserID`,`Sex`, `Birthday`, `Email`, `WeChat`, `Telphone`, `Description`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, '1', '1984-07-24', 'wangyixian@iidooo.com', 'ouitiken', '13816867453', '网站超级管理员', '', now(), 1, now(), 1, 0, 1);

-- IDO_CMS_CHANNEL
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (1, 0, '首页', 'index', 1, '首页标题', '首页关键字', '首页描述', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (2, 0, '产品介绍', 'product', 1, '产品介绍标题', '产品介绍关键字', '产品介绍描述', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (3, 0, '红酒资讯', 'info', 1, '红酒资讯标题', '红酒资讯关键字', '红酒资讯描述', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (4, 0, '关于我们', 'about', 1, '关于我们标题', '关于我们关键字', '关于我们描述', 4, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (5, 0, '联系我们', 'cantact', 1, '联系我们标题', '联系我们关键字', '联系我们描述', 5, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (6, 0, '合作加盟', 'join', 1, '合作加盟标题', '合作加盟关键字', '合作加盟描述', 6, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (7, 0, '人才招聘', 'recruit', 1, '人才招聘标题', '人才招聘关键字', '人才招聘描述', 7, 0, '', now(), 1, now(), 1, 0, 1);

-- 红酒咨询子栏目
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (8, 3, '文章', 'article', 2, '文章标题', '文章关键字', '文章描述', 8, 0, '', now(), 1, now(), 1, 0, 1);

-- IDO_CMS_TEMPLATE
INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('首页', '/templates/inaba/index/index.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('产品介绍', '/templates/inaba/channel/product.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('红酒资讯', '/templates/inaba/channel/info.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('关于我们', '/templates/inaba/channel/about.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('联系我们', '/templates/inaba/channel/contact.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('合作加盟', '/templates/inaba/channel/join.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('人才招聘', '/templates/inaba/channel/recruit.html', '', now(), 1, now(), 1, 0, 1);

-- 产品介绍内容
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (2, 8, '德国皇冠司令白葡萄酒', '子标题', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');

-- 红酒资讯
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (3, 9,'红酒资讯', '子标题', '/inaba/info/红酒资讯1/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', ' ', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'全球最昂贵葡萄酒2014排名出炉', '子标题', '/inaba/info/全球最昂贵葡萄酒2014排名出炉/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');
 
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `ContentAlias`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) VALUES (8, 9,'THANKSGIVING 感恩节餐酒搭配', '子标题', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', '别名', 'meta标题', 'meta关键字', 'meta描述', '摘要', '内容', '来源', 'Inaba', '1', '0', '', now(), '1', now(), '1', '0', '1');
