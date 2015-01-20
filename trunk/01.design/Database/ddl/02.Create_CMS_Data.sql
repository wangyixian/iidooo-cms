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
VALUES ('在线动画内容', '/templates/default/content/animation_content.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫音乐内容', '/templates/default/content/music_content.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫图库内容', '/templates/default/content/picture_content.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('动漫资讯内容', '/templates/default/content/news_content.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线漫画内容的专辑', '/templates/default/content/comic_content_album.html', '', now(), 1, now(), 1, 0, 1);

INSERT INTO `IDO_CMS_TEMPLATE` (`TemplateName`, `TemplateSource`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES ('在线动画内容的附件播放', '/templates/default/content/animation_content_attach.html', '', now(), 1, now(), 1, 0, 1);

-- 内容构建
-- 在线漫画内容构建
-- 热门连载
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '海贼王', '/comic/海贼王/title/1.jpg', 'One Piece', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '火影忍者', '/comic/火影忍者/title/1.jpg', 'Naruto', '767话', '火影忍者标题', '火影忍者关键字', '火影忍者描述', '火影忍者摘要', '火影忍者内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '死神', '/comic/死神/title/1.jpg', '767话', 'Bleach', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '名侦探柯南', '/comic/名侦探柯南/title/1.jpg', 'Conan', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '妖精的尾巴', '/comic/妖精的尾巴/title/1.jpg', 'Faily Tail', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '美食的俘虏', '/comic/美食的俘虏/title/1.jpg', '别名', '767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`,`TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '进击的巨人', '/comic/进击的巨人/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '全职猎人', '/comic/全职猎人/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '新网球王子', '/comic/新网球王子/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`,`TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (2, 7, '斩赤红之瞳', '/comic/斩赤红之瞳/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);

-- 在线动画内容构建
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '海贼王', '/animation/海贼王/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '火影忍者', '/animation/火影忍者/title/1.jpg', '别名','767话', '火影忍者标题', '火影忍者关键字', '火影忍者描述', '火影忍者摘要', '火影忍者内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '死神', '/animation/死神/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`,`TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '名侦探柯南', '/animation/名侦探柯南/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '妖精的尾巴', '/animation/妖精的尾巴/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '美食的俘虏', '/animation/美食的俘虏/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '进击的巨人', '/animation/进击的巨人/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`,`TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '全职猎人', '/animation/全职猎人/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`,`Alias`, `TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '新网球王子', '/animation/新网球王子/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT` (`ChannelID`, `TemplateID`, `Title`, `Alias`,`TitleImage`, `SubTitle`, `MetaTitle`, `MetaKeyworlds`, `MetaDescription`, `ContentSummary`, `ContentBody`, `ContentSource`, `ContentAuthor`, `Weight`, `IsAllowComment`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (3, 8, '斩赤红之瞳', '/animation/斩赤红之瞳/title/1.jpg', '别名','767话', '海贼王标题', '海贼王关键字', '海贼王描述', '海贼王摘要', '海贼王内容', '网友共享', '尾田荣一郎', 1, 1, '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_LETTER', 'O', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (11, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_LETTER', 'N', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (12, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_LETTER', 'S', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_LETTER', 'B', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (13, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_LETTER', 'M', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_LETTER', 'C', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_LETTER', 'K', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (14, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_LETTER', 'Y', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_LETTER', 'F', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (15, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_LETTER', 'M', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (16, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_LETTER', 'J', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (17, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_LETTER', 'Q', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_LETTER', 'H', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (18, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_LETTER', 'W', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_LETTER', 'T', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (19, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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

INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_COMIC_STATUS', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_COMIC_TYPE', '1', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_COMIC_TYPE', '2', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_COMIC_TYPE', '3', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_LETTER', 'Z', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_LETTER', 'A', '', now(), 1, now(), 1, 0, 1);
INSERT INTO `IDO_CMS_CONTENT_TAG` (`ContentID`, `ClassCode`, `ItemCode`, `Remarks`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsDelete`, `Version`) 
VALUES (20, 'TAG_COUNTRY', '1', '', now(), 1, now(), 1, 0, 1);

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
