INSERT INTO `cms`.`ido_cms_page` 
(`PageTitle`, `PageName`, `PageKeywords`, `PageDescription`, `PageTemplate`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('轶度空间首页', 'index', '轶度空间，网络服务，软件服务', '轶度空间，网络服务，软件服务', '/ftl/index.html', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_page` 
(`PageTitle`, `PageName`, `PageKeywords`, `PageDescription`, `PageTemplate`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('我们的服务', 'services', '网站建设，软件定制，技术支持', '网站建设，软件定制，技术支持', '/ftl/services.html', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_block` 
(`BlockTitle`, `BlockSubTitle`, `BlockImageTitle`, `BlockName`,  `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('我们的服务', 'OUR SERVICES', ' ', 'services', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block` 
(`BlockTitle`, `BlockSubTitle`, `BlockImageTitle`, `BlockName`,  `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('我们的产品', 'OUR PRODUCTS', ' ', 'products', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block` 
(`BlockTitle`, `BlockSubTitle`, `BlockImageTitle`, `BlockName`,  `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('主菜单', 'MAIN MENU', ' ', 'mainmenu', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block` 
(`BlockTitle`, `BlockSubTitle`, `BlockImageTitle`, `BlockName`,  `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('顶部', 'TOP BAR', ' ', 'top', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '2', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '3', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '4', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`, `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0', '网站建设', 'WEBSITE BUILDING', ' ', 'service_website_building', 'url', '_blank', '描述',  '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '电子邮箱', 'E-MAIL', ' ', 'service_email', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '软件定制', 'SOFTWARE CUSTOMIZATION', ' ', 'service_software_customization', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '移动应用', 'MOBILE APP', ' ', 'service_mobile_app', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '电子商城', 'ELECTRONIC MALL', ' ', 'service_electronic_mall', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '虚拟主机', 'WEB HOST', ' ', 'service_web_host', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '个人博客', 'PERSONAL BLOG', ' ', 'service_personal_blog', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '社区论坛', 'COMMUNITY FORUM', ' ', 'service_community_forum', 'url', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '1', '0',  '回到首页', ' ', ' ', 'mainmenu_home', 'page?pageName=index', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '服务一览', ' ', ' ', 'mainmenu_services', 'page?pageName=services', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '产品展示', ' ', ' ', 'mainmenu_products', 'page?pageName=products', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '案例欣赏', ' ', ' ', 'mainmenu_cases', 'page?pageName=cases', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '资讯中心', ' ', ' ', 'mainmenu_news', 'page?pageName=news', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0',  '关于我们', ' ', ' ', 'mainmenu_about', 'page?pageName=about', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0', '联系我们', ' ', ' ', 'mainmenu_contact', 'page?pageName=contact', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_link` 
(`ParentLinkID`,`LinkPageID`,`LinkArticleID`,  `LinkTitle`, `LinkSubTitle`, `LinkImageURL`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('0', '0', '0', '轶度空间', ' ', '/themes/default/image/logo.png', 'logo', 'page?pageName=index', '_blank', '描述', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '1', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '2', '2', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '3', '3', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '4', '4', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '5', '5', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '6', '6', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '7', '7', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '8', '8', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '9', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '10', '2', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '11', '3', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '12', '4', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '13', '5', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '14', '6', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '15', '7', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_block_link` (`BlockID`, `LinkID`, `Sequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('4', '16', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
