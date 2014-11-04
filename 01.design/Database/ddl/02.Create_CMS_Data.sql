-- 栏目构建
-- 顶部栏目
INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('1', '0', '首页', 'index', '首页标题', '首页关键字', '首页描述', 1, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('2', '0', '在线漫画', 'comic', '在线漫画标题', '在线漫画关键字', '在线漫画描述', 2, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('3', '0', '在线动画', 'animation', '在线动画标题', '在线动画关键字', '在线动画描述', 3, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('4', '0', '动漫音乐', 'music', '动漫音乐标题', '动漫音乐关键字', '动漫音乐描述', 4, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('5', '0', '动漫图库', 'picture', '动漫图库标题', '动漫图库关键字', '动漫图库描述', 5, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`IsBlankTarget`,`URL`,`Remarks`,`Language`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES ('6', '0', '动漫资讯', 'news', '动漫资讯标题', '动漫资讯关键字', '动漫资讯描述', 6, 0, 0, '', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

-- 模板构建
INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('首页', '/templates/default/index/index.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线漫画栏目', '/templates/default/channel/comic.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线动画栏目', '/templates/default/channel/animation.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫音乐栏目', '/templates/default/channel/music.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫图库栏目', '/templates/default/channel/picture.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫资讯栏目', '/templates/default/channel/news.html', '', 'zh-CN', now(), 1, now(), 1, 0, 1);

