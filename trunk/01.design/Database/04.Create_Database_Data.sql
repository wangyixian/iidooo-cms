-- IDO_DICT_TYPE
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('SYSTEM_PROPERTIES', '系统配置', 1, '', now(), 1, now(), 1);
-- INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('FIELD_PROPERTIES', '扩展字段配置', 2, '', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', '内容配置', 3, '', now(), 1, now(), 1);

-- IDO_DICT_CLASS
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_PAGING', '分页配置', 1, '', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_SITE', '站点配置', 2, '', now(), 1, now(), 1);

-- FIELD_PROPERTIES
-- INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('FIELD_PROPERTIES', 'FIELD_MODEL_TYPE', '模型类型', 3, '', now(), 1, now(), 1);

-- INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('FIELD_PROPERTIES', 'FIELD_TYPE', '字段类型', 4, '', now(), 1, now(), 1);

-- 内容分类
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', 'CONTENT_TYPE', '内容分类', 5, '', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', 'FIELD_PRODUCT_TYPE', '产品类型', 5, '', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', 'FIELD_PRODUCT_COUNTRY', '产品国家', 6, '', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', 'FIELD_PRODUCT_ORIGIN', '产品产地', 7, '', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_PROPERTIES', 'ARTICLE_TYPE', '文章分类', 7, '', now(), 1, now(), 1);

-- IDO_DICT_ITEM
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_PAGING', 'PAGE_SIZE', '每页显示总行数', '20', 1, 0, 0, 0, '', now(), 1, now(), 1);

-- PROPERTIES_SITE
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_SITE', 'SITE_URL', '网址', 'http://localhost:8080/cms', 1, 0, 0, 0,'', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_SITE', 'SITE_NAME', 'INABA进口红酒品尊', 'INABA进口红酒品尊', 2, 0, 0, 0,'', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_SITE', 'SITE_TEMPLATE_URL', '模版根目录', 'http://localhost:8080/cms/templates/inaba', 3, 0, 0, 0,'', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_SITE', 'CONTENT_RES_ROOT', '内容资源根目录', 'http://localhost:8080/cms/res', 4, 0, 0, 0,'', now(), 1, now(), 1);

INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('PROPERTIES_SITE', 'UPLOAD_MAX_SIZE', '上传最大文件大小单位B', '1000000', 5, 0, 0, 0,'', now(), 1, now(), 1);

-- FIELD_MODEL_TYPE
-- INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('FIELD_MODEL_TYPE', '1', '内容模型', '内容模型', 1, 1, 0, 0,'', now(), 1, now(), 1);

-- FIELD_TYPE
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '1', '字符串文本', '字符串文本', 1, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '2', '整型文本', '整型文本', 2, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '3', '浮点型文本', '浮点型文本', 3, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '4', '文本区域', '文本区域', 4, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '5', '日期', '日期', 5, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '6', '下拉列表', '下拉列表', 6, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '7', '复选框', '复选框', 7, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_TYPE', '8', '单选框', '单选框', 8, 1, 0, 0,'', now(), 1, now(), 1);

-- FIELD_PRODUCT_TYPE
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_TYPE', '1', '红酒', '红酒', 1, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_TYPE', '2', '干白', '干白', 2, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_TYPE', '3', '起泡酒', '起泡酒', 3, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_TYPE', '4', '冰酒', '冰酒', 4, 0, 0, 0,'', now(), 1, now(), 1);
-- FIELD_PRODUCT_COUNTRY
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '1', '法国', '法国', 1, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '2', '德国', '德国', 2, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '3', '意大利', '意大利', 3, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_COUNTRY', '4', '西班牙', '西班牙', 4, 0, 0, 0,'', now(), 1, now(), 1);
-- FIELD_PRODUCT_ORIGIN
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '1', '法国罗纳河谷', '法国罗纳河谷', 1, 1, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '2', '法国产区桃红葡萄酒', '法国产区桃红葡萄酒', 2, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '3', '法国优质产区原装干红', '法国优质产区原装干红', 3, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('FIELD_PRODUCT_ORIGIN', '4', '法国波尔多产区', '法国波尔多产区', 4, 0, 0, 0,'', now(), 1, now(), 1);

-- 内容分类
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_TYPE', '1', '默认', '默认', 1, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_TYPE', '2', '产品', '产品', 2, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('CONTENT_TYPE', '3', '文章', '文章', 3, 0, 0, 0,'', now(), 1, now(), 1);

-- 文章分类
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('ARTICLE_TYPE', '1', '博客', '博客', 1, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('ARTICLE_TYPE', '2', '新闻', '新闻', 2, 0, 0, 0,'', now(), 1, now(), 1);
INSERT INTO `IDO_DICT_ITEM` (`DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `IsDefault`, `IsDisable`, `IsReadonly`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('ARTICLE_TYPE', '3', '葡萄酒知识', '葡萄酒知识', 3, 0, 0, 0,'', now(), 1, now(), 1);

-- INSERT INTO `IDO_FIELD_MODEL` (`ModelName`, `TableName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('默认', 'IDO_CMS_CONTENT', 1, '', now(), 1, now(), 1);
-- INSERT INTO `IDO_FIELD_MODEL` (`ModelName`, `TableName`, `Sequence`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES ('产品', 'IDO_CMS_CONTENT', 2, '', now(), 1, now(), 1);

-- IDO_FIELD_CONFIG
-- INSERT INTO `IDO_FIELD_CONFIG` (`ModelID`, `FieldCode`, `FieldTitle`, `FieldType`, `Sequence`, `DictClassCode`, `DefaultValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES (1, 'ProductType', '产品类型', 6, 1, 'FIELD_PRODUCT_TYPE', '', '', now(), 1, now(), 1);
-- INSERT INTO `IDO_FIELD_CONFIG` (`ModelID`, `FieldCode`, `FieldTitle`, `FieldType`, `Sequence`, `DictClassCode`,  `DefaultValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES (1, 'ProductCountry', '产品国家', 6, 2, 'FIELD_PRODUCT_COUNTRY', '', '', now(), 1, now(), 1);
-- INSERT INTO `IDO_FIELD_CONFIG` (`ModelID`, `FieldCode`, `FieldTitle`, `FieldType`, `Sequence`, `DictClassCode`,  `DefaultValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
-- VALUES (1, 'ProductOrigin', '产品产地', 6, 3, 'FIELD_PRODUCT_ORIGIN', '', '', now(), 1, now(), 1);

-- IDO_SECURITY_USER
INSERT INTO `IDO_SECURITY_USER` 
(`UserName`, `LoginID`, `Password`, `LoginTime`, `IsDisable`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('超级管理员', 'admin', md5(111111), now(), 0, '', now(), 1, now(), 1);

-- IDO_CMS_USER
INSERT INTO `IDO_CMS_USER` (`UserID`,`Sex`, `Birthday`, `Email`, `WeChat`, `Telphone`, `Description`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES (1, '1', '1984-07-24', 'wangyixian@iidooo.com', 'ouitiken', '13816867453', '网站超级管理员', '', now(), 1, now(), 1);

-- IDO_CMS_CHANNEL
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (1, 0, '首页', 'index', 1, '首页标题', '首页关键字', '首页描述', 1, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (2, 0, '产品介绍', 'productList', 1, '产品介绍标题', '产品介绍关键字', '产品介绍描述', 2, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (3, 0, '红酒资讯', 'blogList', 1, '红酒资讯标题', '红酒资讯关键字', '红酒资讯描述', 3, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (4, 0, '关于我们', 'aboutUs', 1, '关于我们标题', '关于我们关键字', '关于我们描述', 4, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (5, 0, '联系我们', 'cantact', 1, '联系我们标题', '联系我们关键字', '联系我们描述', 5, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (6, 0, '合作加盟', 'join', 1, '合作加盟标题', '合作加盟关键字', '合作加盟描述', 6, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (7, 0, '人才招聘', 'recruit', 1, '人才招聘标题', '人才招聘关键字', '人才招聘描述', 7, 0, '', now(), 1, now(), 1);

-- 红酒咨询子栏目
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (8, 3, '文章', 'article', 2, '文章标题', '文章关键字', '文章描述', 8, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (8, 3, '新闻', 'news', 2, '文章标题', '文章关键字', '文章描述', 8, 0, '', now(), 1, now(), 1);
INSERT INTO `IDO_CMS_CHANNEL`
(`TemplateID`,`ParentID`,`ChannelName`,`ChannelPath`,`ChannelLevel`,`MetaTitle`,`MetaKeywords`,`MetaDescription`,`Sequence`,`IsHidden`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (8, 3, '葡萄酒知识', 'konwledge', 2, '文章标题', '文章关键字', '文章描述', 8, 0, '', now(), 1, now(), 1);

-- IDO_CMS_TEMPLATE
INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('首页', '/templates/inaba/index/index.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('产品介绍', '/templates/inaba/channel/product.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('红酒资讯', '/templates/inaba/channel/info.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('关于我们', '/templates/inaba/channel/about.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('联系我们', '/templates/inaba/channel/contact.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('合作加盟', '/templates/inaba/channel/join.html', '', now(), 1, now(), 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplatePath`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('人才招聘', '/templates/inaba/channel/recruit.html', '', now(), 1, now(), 1);

-- 产品介绍内容
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '德国冰山雷司令', '德国冰山雷司令', ' ', '德国冰山雷司令', '德国冰山雷司令', '德国冰山雷司令', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '德国HXM甜白', '德国HXM甜白', ' ', '德国HXM甜白', '德国HXM甜白', '德国HXM甜白', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '地中海', '地中海', ' ', '地中海', '地中海', '地中海', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '高大骑士', '高大骑士', ' ', '高大骑士', '高大骑士', '高大骑士', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '教皇新堡', '教皇新堡', ' ', '教皇新堡', '教皇新堡', '教皇新堡', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '克罗兹埃米塔日', '克罗兹埃米塔日', ' ', '克罗兹埃米塔日', '克罗兹埃米塔日', '克罗兹埃米塔日', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '隆河丘', '隆河丘', ' ', '隆河丘', '隆河丘', '隆河丘', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '梅洛', '梅洛', ' ', '梅洛', '梅洛', '梅洛', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '神之恩赐', '神之恩赐', ' ', '神之恩赐', '神之恩赐', '神之恩赐', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '托索比诺霞多丽起泡酒', '托索比诺霞多丽起泡酒', ' ', '托索比诺霞多丽起泡酒', '托索比诺霞多丽起泡酒', '托索比诺霞多丽起泡酒', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '托索ASTI起泡酒', '托索ASTI起泡酒', ' ', '托索ASTI起泡酒', '托索ASTI起泡酒', '托索ASTI起泡酒', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '瓦给拉斯', '瓦给拉斯', ' ', '瓦给拉斯', '瓦给拉斯', '瓦给拉斯', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('2', '2', '霞多丽', '霞多丽', ' ', '霞多丽', '霞多丽', '霞多丽', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');

INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('1', '2', '3', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('2', '1', '1', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('3', '2', '2', '2');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('4', '3', '4', '4');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('5', '2', '1', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('6', '2', '3', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('7', '1', '1', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('8', '2', '2', '2');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('9', '3', '4', '4');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('10', '2', '1', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('11', '2', '3', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('12', '1', '1', '1');
INSERT INTO `IDO_CMS_CONTENT_PRODUCT` (`ContentID`, `ProductType`, `ProductCountry`, `ProductOrigin`) VALUES ('13', '2', '2', '2');

-- 红酒资讯
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章1', '热门文章1', ' ', '热门文章1', '热门文章1', '热门文章1', ' ', ' ', '1', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章2', '热门文章2', ' ', '热门文章2', '热门文章2', '热门文章2', ' ', ' ', '2', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章3', '热门文章3', ' ', '热门文章3', '热门文章3', '热门文章3', ' ', ' ', '3', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章4', '热门文章4', ' ', '热门文章4', '热门文章4', '热门文章4', ' ', ' ', '4', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章5', '热门文章5', ' ', '热门文章5', '热门文章5', '热门文章5', ' ', ' ', '5', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章6', '热门文章6', ' ', '热门文章6', '热门文章6', '热门文章6', ' ', ' ', '6', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章7', '热门文章7', ' ', '热门文章7', '热门文章7', '热门文章7', ' ', ' ', '7', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章8', '热门文章8', ' ', '热门文章8', '热门文章8', '热门文章8', ' ', ' ', '8', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章9', '热门文章9', ' ', '热门文章9', '热门文章9', '热门文章9', ' ', ' ', '9', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热门文章10', '热门文章10', ' ', '热门文章10', '热门文章10', '热门文章10', ' ', ' ', '10', '0', ' ', now(), '1', now(), '1');

INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('14', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('15', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('16', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('17', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('18', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('19', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('20', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('21', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('22', '1');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('23', '1');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻1', '热点新闻1', ' ', '热点新闻1', '热点新闻1', '热点新闻1', ' ', ' ', '11', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻2', '热点新闻2', ' ', '热点新闻2', '热点新闻2', '热点新闻2', ' ', ' ', '12', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻3', '热点新闻3', ' ', '热点新闻3', '热点新闻3', '热点新闻3', ' ', ' ', '13', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻4', '热点新闻4', ' ', '热点新闻4', '热点新闻4', '热点新闻4', ' ', ' ', '14', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻5', '热点新闻5', ' ', '热点新闻5', '热点新闻5', '热点新闻5', ' ', ' ', '15', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻6', '热点新闻6', ' ', '热点新闻6', '热点新闻6', '热点新闻6', ' ', ' ', '16', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻7', '热点新闻7', ' ', '热点新闻7', '热点新闻7', '热点新闻7', ' ', ' ', '17', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻8', '热点新闻8', ' ', '热点新闻8', '热点新闻8', '热点新闻8', ' ', ' ', '18', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻9', '热点新闻9', ' ', '热点新闻9', '热点新闻9', '热点新闻9', ' ', ' ', '19', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '热点新闻10', '热点新闻10', ' ', '热点新闻10', '热点新闻10', '热点新闻10', ' ', ' ', '20', '0', ' ', now(), '1', now(), '1');

INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('24', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('25', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('26', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('27', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('28', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('29', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('30', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('31', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('32', '2');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('33', '2');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识1', '葡萄酒知识1', ' ', '葡萄酒知识1', '葡萄酒知识1', '葡萄酒知识1', ' ', ' ', '21', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识2', '葡萄酒知识2', ' ', '葡萄酒知识2', '葡萄酒知识2', '葡萄酒知识2', ' ', ' ', '22', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识3', '葡萄酒知识3', ' ', '葡萄酒知识3', '葡萄酒知识3', '葡萄酒知识3', ' ', ' ', '23', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识4', '葡萄酒知识4', ' ', '葡萄酒知识4', '葡萄酒知识4', '葡萄酒知识4', ' ', ' ', '24', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识5', '葡萄酒知识5', ' ', '葡萄酒知识5', '葡萄酒知识5', '葡萄酒知识5', ' ', ' ', '25', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识6', '葡萄酒知识6', ' ', '葡萄酒知识6', '葡萄酒知识6', '葡萄酒知识6', ' ', ' ', '26', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识7', '葡萄酒知识7', ' ', '葡萄酒知识7', '葡萄酒知识7', '葡萄酒知识7', ' ', ' ', '27', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识8', '葡萄酒知识8', ' ', '葡萄酒知识8', '葡萄酒知识8', '葡萄酒知识8', ' ', ' ', '28', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识9', '葡萄酒知识9', ' ', '葡萄酒知识9', '葡萄酒知识9', '葡萄酒知识9', ' ', ' ', '29', '0', ' ', now(), '1', now(), '1');
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('3', '3', '葡萄酒知识10', '葡萄酒知识10', ' ', '葡萄酒知识10', '葡萄酒知识10', '葡萄酒知识10', ' ', ' ', '30', '0', ' ', now(), '1', now(), '1');

INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('34', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('35', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('36', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('37', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('38', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('39', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('40', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('41', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('42', '3');
INSERT INTO `IDO_CMS_CONTENT_ARTICLE` (`ContentID`, `ArticleType`) VALUES ('43', '3');

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `ContentType`, `ContentTitle`, `ContentSubTitle`, `ContentImageTitle`, `MetaTitle`, `MetaKeywords`, `MetaDescription`, `ContentSummary`, `ContentBody`, `Sequence`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`) 
VALUES ('4', '1', '关于我们', '关于我们', ' ', '关于我们', '关于我们', '关于我们', '关于我们描述', '关于我们内容体', '1', '0', ' ', now(), '1', now(), '1');