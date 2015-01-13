-- -----------------------------------------------------
-- IDO_DICT_TYPE的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', '系统配置', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', '内容标签', '', now(), 1, now(), 1, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_CLASS的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_SITE', '站点配置', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_PRODUCT_TYPE', '产品类型', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_PRODUCT_COUNTRY', '国家', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_PRODUCT_GROWING', '产区', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_PRODUCT_CLASSIFY', '产品分类', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('CMS_TAGS', 'TAG_INFO_CLASSIFY', '文章分类', '', now(), 1, now(), 1, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_ITEM的初始化数据
-- -----------------------------------------------------
-- 站点配置
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'SITE_DOMAIN', '域名', 'www.iidooo.com', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'SITE_NAME', 'INABA进口红酒品尊', 'INABA进口红酒品尊', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'SITE_URL', '网址', 'http://localhost:8080/cms', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'SITE_RES_ROOT', '资源根目录', 'http://localhost:8080/cms/templates/inaba/res', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'CONTENT_RES_ROOT', '内容资源根目录', 'http://localhost:8080/cms/res', 3, 0, '', now(), 1, now(), 1, 0, 1);

-- 产品类型
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_TYPE', '1', '精品', '精品', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_TYPE', '2', '热销', '热销', 2, 0, '', now(), 1, now(), 1, 0, 1);

-- 产品国家
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_COUNTRY', '1', '法国', '法国', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_COUNTRY', '2', '意大利', '意大利', 2, 0, '', now(), 1, now(), 1, 0, 1)
;
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_COUNTRY', '3', '德国', '德国', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_COUNTRY', '4', '西班牙', '西班牙', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 产品产区
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_GROWING', '1', '法国罗纳河谷', '法国罗纳河谷', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_GROWING', '2', '法国产区桃红葡萄酒', '法国产区桃红葡萄酒', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_GROWING', '3', '法国优质产区原装干红', '法国优质产区原装干红', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_GROWING', '4', '法国波尔多产区', '法国波尔多产区', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 产品分类
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_CLASSIFY', '1', '红酒', '红酒', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_CLASSIFY', '2', '干白', '干白', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_CLASSIFY', '3', '起泡酒', '起泡酒', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_PRODUCT_CLASSIFY', '4', '冰酒', '冰酒', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 文章分类
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_INFO_CLASSIFY', '1', '热门文章', '热门文章', 1, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_INFO_CLASSIFY', '2', '热点新闻', '热点新闻', 2, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_INFO_CLASSIFY', '3', '葡萄酒知识', '葡萄酒知识', 3, 0, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (0, 'TAG_INFO_CLASSIFY', '4', '博客', '博客', 4, 0, '', now(), 1, now(), 1, 0, 1);

-- 栏目构建
-- 顶部栏目
INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (1, 0, '首页', 'index', '首页标题', '首页关键字', '首页描述', 1, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (2, 0, '产品介绍', 'product', '产品介绍标题', '产品介绍关键字', '产品介绍描述', 2, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (3, 0, '红酒资讯', 'info', '红酒资讯标题', '红酒资讯关键字', '红酒资讯描述', 3, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (4, 0, '关于我们', 'about', '关于我们标题', '关于我们关键字', '关于我们描述', 4, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (5, 0, '联系我们', 'cantact', '联系我们标题', '联系我们关键字', '联系我们描述', 5, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (6, 0, '合作加盟', 'join', '合作加盟标题', '合作加盟关键字', '合作加盟描述', 6, 0, '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (7, 0, '人才招聘', 'recruit', '人才招聘标题', '人才招聘关键字', '人才招聘描述', 7, 0, '', '', now(), 1, now(), 1, 0, 1);

-- 模板构建
INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('首页', '/templates/inaba/index/index.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('产品介绍', '/templates/inaba/channel/product.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('红酒资讯', '/templates/inaba/channel/info.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('关于我们', '/templates/inaba/channel/about.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('联系我们', '/templates/inaba/channel/contact.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('合作加盟', '/templates/inaba/channel/join.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('人才招聘', '/templates/inaba/channel/recruit.html', '', now(), 1, now(), 1, 0, 1);

-- 内容构建
-- 产品
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '德国皇冠司令白葡萄酒', '/inaba/product/德国皇冠司令白葡萄酒/title/1.jpg', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒', '德国皇冠司令白葡萄酒标题', '德国皇冠司令白葡萄酒关键字', '德国皇冠司令白葡萄酒描述', '德国皇冠司令白葡萄酒摘要', '德国皇冠司令白葡萄酒内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

-- 红酒资讯
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯1', '红酒资讯1', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯1子标题', '红酒资讯1Meta标题', '红酒资讯1关键字', '红酒资讯1描述', '红酒资讯1摘要', '红酒资讯1内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯2', '红酒资讯2', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯2子标题', '红酒资讯2Meta标题', '红酒资讯2关键字', '红酒资讯2描述', '红酒资讯2摘要', '红酒资讯2内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯3', '红酒资讯3', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯3子标题', '红酒资讯3Meta标题', '红酒资讯3关键字', '红酒资讯3描述', '红酒资讯3摘要', '红酒资讯3内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯4', '红酒资讯4', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯4子标题', '红酒资讯4Meta标题', '红酒资讯4关键字', '红酒资讯4描述', '红酒资讯4摘要', '红酒资讯4内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯5', '红酒资讯5', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯5子标题', '红酒资讯5Meta标题', '红酒资讯5关键字', '红酒资讯5描述', '红酒资讯5摘要', '红酒资讯5内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯6', '红酒资讯6', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯6子标题', '红酒资讯6Meta标题', '红酒资讯6关键字', '红酒资讯6描述', '红酒资讯6摘要', '红酒资讯6内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯7', '红酒资讯7', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯7子标题', '红酒资讯7Meta标题', '红酒资讯7关键字', '红酒资讯7描述', '红酒资讯7摘要', '红酒资讯7内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯8', '红酒资讯8', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯8子标题', '红酒资讯8Meta标题', '红酒资讯8关键字', '红酒资讯8描述', '红酒资讯8摘要', '红酒资讯8内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯9', '红酒资讯9', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯9子标题', '红酒资讯9Meta标题', '红酒资讯9关键字', '红酒资讯9描述', '红酒资讯9摘要', '红酒资讯9内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '红酒资讯10', '红酒资讯10', '/inaba/info/红酒资讯1/title/1.jpg', '红酒资讯10子标题', '红酒资讯10Meta标题', '红酒资讯10关键字', '红酒资讯10描述', '红酒资讯10摘要', '红酒资讯10内容', '', '', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, '全球最昂贵葡萄酒2014排名出炉', '全球最昂贵葡萄酒2014排名出炉', '/inaba/info/全球最昂贵葡萄酒2014排名出炉/title/1.jpg', '全球最昂贵葡萄酒2014排名出炉子标题', '全球最昂贵葡萄酒2014排名出炉Meta标题', '全球最昂贵葡萄酒2014排名出炉关键字', '全球最昂贵葡萄酒2014排名出炉描述', '全球最昂贵葡萄酒2014排名出炉摘要', '全球最昂贵葡萄酒2014排名出炉内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 9, 'THANKSGIVING 感恩节餐酒搭配', 'THANKSGIVING 感恩节餐酒搭配', '/inaba/info/THANKSGIVING感恩节餐酒搭配/title/1.jpg', 'THANKSGIVING 感恩节餐酒搭配子标题', 'THANKSGIVING 感恩节餐酒搭配Meta标题', 'THANKSGIVING 感恩节餐酒搭配关键字', 'THANKSGIVING 感恩节餐酒搭配描述', 'THANKSGIVING 感恩节餐酒搭配摘要', 'THANKSGIVING 感恩节餐酒搭配内容', '', 'INABA编辑', 1, 1, '', now(), 1, now(), 1, 0, 1);

-- 内容标签
-- 产品类型
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_PRODUCT_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_PRODUCT_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_PRODUCT_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_PRODUCT_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_PRODUCT_TYPE', '1', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_PRODUCT_TYPE', '2', '', now(), 1, now(), 1, 0, 1);

-- 资讯热门文章
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_INFO_CLASSIFY', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_INFO_CLASSIFY', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_INFO_CLASSIFY', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_INFO_CLASSIFY', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_INFO_CLASSIFY', '1', '', now(), 1, now(), 1, 0, 1);

-- 资讯热点新闻
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_INFO_CLASSIFY', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_INFO_CLASSIFY', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_INFO_CLASSIFY', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_INFO_CLASSIFY', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_INFO_CLASSIFY', '2', '', now(), 1, now(), 1, 0, 1);

-- 资讯葡萄酒知识
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_INFO_CLASSIFY', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_INFO_CLASSIFY', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_INFO_CLASSIFY', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_INFO_CLASSIFY', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_INFO_CLASSIFY', '3', '', now(), 1, now(), 1, 0, 1);

-- 资讯博客
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (21, 'TAG_INFO_CLASSIFY', '4', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (22, 'TAG_INFO_CLASSIFY', '4', '', now(), 2, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (23, 'TAG_INFO_CLASSIFY', '4', '', now(), 3, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (24, 'TAG_INFO_CLASSIFY', '4', '', now(), 4, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (25, 'TAG_INFO_CLASSIFY', '4', '', now(), 5, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (26, 'TAG_INFO_CLASSIFY', '4', '', now(), 6, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (27, 'TAG_INFO_CLASSIFY', '4', '', now(), 7, now(), 1, 0, 1);

-- 附件专辑构建
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第1卷', '冒险之序幕', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第2话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第3话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第4话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第5话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第6话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第7话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第8话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第9话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 12, '第10话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
-- 在线动画专辑
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '搜狐视频', '搜狐视频', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '爱奇异视频', '爱奇异视频', 1, 1, '', now(), 1, now(), 1, 0, 1);

-- 构建附件内容
-- 海贼王第一卷
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第1页', '', '/comic/海贼王/Album/正篇/第1卷/001.jpg', 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第2页', '', '/comic/海贼王/Album/正篇/第1卷/002.jpg', 2, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第3页', '', '/comic/海贼王/Album/正篇/第1卷/003.jpg', 3, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第4页', '', '/comic/海贼王/Album/正篇/第1卷/004.jpg', 4, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第5页', '', '/comic/海贼王/Album/正篇/第1卷/005.jpg', 5, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第6页', '', '/comic/海贼王/Album/正篇/第1卷/006.jpg', 6, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第7页', '', '/comic/海贼王/Album/正篇/第1卷/007.jpg', 7, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第8页', '', '/comic/海贼王/Album/正篇/第1卷/008.jpg', 8, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第9页', '', '/comic/海贼王/Album/正篇/第1卷/009.jpg', 9, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 13, '第10页', '', '/comic/海贼王/Album/正篇/第1卷/010.jpg', 10, '', now(), 1, now(), 1, 0, 1);
-- 海贼王视频
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第1集', '', '/comic/海贼王/Album/正篇/第1卷/001.jpg', 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第2集', '', '/comic/海贼王/Album/正篇/第1卷/002.jpg', 2, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第3集', '', '/comic/海贼王/Album/正篇/第1卷/003.jpg', 3, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第4集', '', '/comic/海贼王/Album/正篇/第1卷/004.jpg', 4, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第5集', '', '/comic/海贼王/Album/正篇/第1卷/005.jpg', 5, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第6集', '', '/comic/海贼王/Album/正篇/第1卷/006.jpg', 6, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第7集', '', '/comic/海贼王/Album/正篇/第1卷/007.jpg', 7, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第8集', '', '/comic/海贼王/Album/正篇/第1卷/008.jpg', 8, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第9集', '', '/comic/海贼王/Album/正篇/第1卷/009.jpg', 9, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第10集', '', '/comic/海贼王/Album/正篇/第1卷/010.jpg', 10, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第11集', '', '/comic/海贼王/Album/正篇/第1卷/001.jpg', 11, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第12集', '', '/comic/海贼王/Album/正篇/第1卷/002.jpg', 12, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第13集', '', '/comic/海贼王/Album/正篇/第1卷/003.jpg', 13, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第14集', '', '/comic/海贼王/Album/正篇/第1卷/004.jpg', 14, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第15集', '', '/comic/海贼王/Album/正篇/第1卷/005.jpg', 15, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第16集', '', '/comic/海贼王/Album/正篇/第1卷/006.jpg', 16, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第17集', '', '/comic/海贼王/Album/正篇/第1卷/007.jpg', 17, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第18集', '', '/comic/海贼王/Album/正篇/第1卷/008.jpg', 18, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第19集', '', '/comic/海贼王/Album/正篇/第1卷/009.jpg', 19, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH` (`AlbumID`, `TemplateID`, `Name`, `SubName`, `URL`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 13, '第20集', '', '/comic/海贼王/Album/正篇/第1卷/010.jpg', 20, '', now(), 1, now(), 1, 0, 1);

-- 统计信息构建
INSERT INTO `IDO_CMS_STATISTICS` (`TableName`, `TableDataID`, `StatisticsIP`, `StatisticsType`, `StatisticsValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`)
VALUES ('IDO_CMS_CONTENT', 1, '127.0.0.1', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_STATISTICS` (`TableName`, `TableDataID`, `StatisticsIP`, `StatisticsType`, `StatisticsValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`)
VALUES ('IDO_CMS_CONTENT', 1, '127.0.0.2', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_STATISTICS` (`TableName`, `TableDataID`, `StatisticsIP`, `StatisticsType`, `StatisticsValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`)
VALUES ('IDO_CMS_CONTENT', 1, '127.0.0.3', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_STATISTICS` (`TableName`, `TableDataID`, `StatisticsIP`, `StatisticsType`, `StatisticsValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`)
VALUES ('IDO_CMS_CONTENT', 1, '127.0.0.4', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_STATISTICS` (`TableName`, `TableDataID`, `StatisticsIP`, `StatisticsType`, `StatisticsValue`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`)
VALUES ('IDO_CMS_CONTENT', 1, '127.0.0.5', 1, 1, '', now(), 1, now(), 1, 0, 1);
