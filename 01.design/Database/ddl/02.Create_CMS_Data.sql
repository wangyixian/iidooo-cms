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

INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_page_block` (`PageID`, `BlockID`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '2', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('企业建站', 'ENTERPRISE WEBSITE', ' ', 'service_enterprise_website', 'url', '_blank', '描述', '1', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('企业邮箱', 'ENTERPRISE E-MAIL', ' ', 'service_enterprise_mail', 'url', '_blank', '描述', '2', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('软件定制', 'SOFTWARE CUSTOMIZATION', ' ', 'service_software_customization', 'url', '_blank', '描述', '3', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('移动应用', 'MOBILE APP', ' ', 'service_mobile_app', 'url', '_blank', '描述', '4', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('电子商城', 'ELECTRONIC MALL', ' ', 'service_electronic_mall', 'url', '_blank', '描述', '5', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('虚拟主机', 'WEB HOST', ' ', 'service_web_host', 'url', '_blank', '描述', '6', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('个人博客', 'PERSONAL BLOG', ' ', 'service_personal_blog', 'url', '_blank', '描述', '7', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `cms`.`ido_cms_link` 
(`LinkTitle`, `LinkSubTitle`, `LinkImageTitle`, `LinkName`, `LinkURL`, `LinkTarget`, `LinkDescription`, `LinkSequence`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('社区论坛', 'COMMUNITY FORUM', ' ', 'service_community_forum', 'url', '_blank', '描述', '8', '备注', 'zh-CN', now(), '1', now(), '1', '0', '1');