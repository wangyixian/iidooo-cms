-- 栏目构建
-- 顶部栏目
INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (1, 0, '首页', 'index', '首页标题', '首页关键字', '首页描述', 1, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (2, 0, '在线漫画', 'comic', '在线漫画标题', '在线漫画关键字', '在线漫画描述', 2, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (3, 0, '在线动画', 'animation', '在线动画标题', '在线动画关键字', '在线动画描述', 3, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (4, 0, '动漫音乐', 'music', '动漫音乐标题', '动漫音乐关键字', '动漫音乐描述', 4, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (5, 0, '动漫图库', 'picture', '动漫图库标题', '动漫图库关键字', '动漫图库描述', 5, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_CHANNEL`(`TemplateID`,`ParentChannelID`,`ChannelName`,`ChannelPath`,`MetaTitle`,`MetaKeyworlds`,`MetaDescription`,`Weight`,`IsHidden`,`TargetType`,`URL`,`Remarks`,`CreateTime`,`CreateUser`,`UpdateTime`,`UpdateUser`,`IsDelete`,`Version`) 
VALUES (6, 0, '动漫资讯', 'news', '动漫资讯标题', '动漫资讯关键字', '动漫资讯描述', 6, 0, '_self', '', '', now(), 1, now(), 1, 0, 1);

-- 模板构建
INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('首页', '/templates/default/index/index.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线漫画栏目', '/templates/default/channel/comic.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线动画栏目', '/templates/default/channel/animation.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫音乐栏目', '/templates/default/channel/music.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫图库栏目', '/templates/default/channel/picture.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫资讯栏目', '/templates/default/channel/news.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线漫画内容', '/templates/default/content/comic_content.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线漫画内容的专辑', '/templates/default/content/comic_content_album.html', '', now(), 1, now(), 1, 0, 1);

-- 内容构建
-- 在线漫画内容构建
-- 热门连载
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '海贼王', '/comic/海贼王/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '火影忍者', '/comic/火影忍者/title/1.jpg', '767话', '火影忍者标题', '火影忍者关键字', '火影忍者描述', '火影忍者摘要', '火影忍者内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '死神', '/comic/死神/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '名侦探柯南', '/comic/名侦探柯南/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '妖精的尾巴', '/comic/妖精的尾巴/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '美食的俘虏', '/comic/美食的俘虏/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '进击的巨人', '/comic/进击的巨人/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '全职猎人', '/comic/全职猎人/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '新网球王子', '/comic/新网球王子/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '斩赤红之瞳', '/comic/斩赤红之瞳/title/1.jpg', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);

-- 内容标签
-- 海贼王
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_LETTER', 'O', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 火影忍者
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_LETTER', 'N', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 死神
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_LETTER', 'S', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_LETTER', 'B', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 名侦探柯南
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_LETTER', 'M', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_LETTER', 'C', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_LETTER', 'K', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (4, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 妖精的尾巴
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_LETTER', 'Y', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_LETTER', 'F', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (5, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 美食的俘虏
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_LETTER', 'M', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (6, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 进击的巨人
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_LETTER', 'J', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (7, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 全职猎人
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_LETTER', 'Q', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (8, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 网球王子
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_LETTER', 'W', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (9, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);
-- 斩赤红之瞳
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_LETTER', 'Z', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_LETTER', 'A', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (10, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

-- 附件专辑构建
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第1话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第2话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第3话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第4话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第5话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第6话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第7话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第8话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第9话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_ATTACH_ALBUM` (`ContentID`, `TemplateID`, `Title`, `SubTitle`, `Classify`, `Weight`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (1, 8, '第10话', 'ROMANCE DOWN 冒险！', 1, 1, '', now(), 1, now(), 1, 0, 1);

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
