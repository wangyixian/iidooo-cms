-- -----------------------------------------------------
-- IDO_DICT_TYPE的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_TYPE` (`DictTypeCode`, `DictTypeName`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', '系统配置', '', 'zh-CN', now(), 1, now(), 1, 1, 0, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_CLASS的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_MAIL', '邮件配置', '', 'zh-CN', now(), 1, now(), 1, 1, 0, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_PAGING', '分页配置', '', 'zh-CN', now(), 1, now(), 1, 1, 0, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_LANG', '语言类型', '', 'zh-CN', now(), 1, now(), 1, 1, 0, 0, 1);

INSERT INTO `IDO_DICT_CLASS` (`DictTypeCode`, `DictClassCode`, `DictClassName`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES ('SYSTEM_PROPERTIES', 'PROPERTIES_SITE', '站点配置', '', 'zh-CN', now(), 1, now(), 1, 1, 0, 0, 1);

-- -----------------------------------------------------
-- IDO_DICT_ITEM的初始化数据
-- -----------------------------------------------------
INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_SMTP', 'SMTP服务器地址', 'mail.iidooo.com', 1, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_FROM', '邮件来自', 'cms@iidooo.com', 2, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_PASSWORD', '邮件密码', MD5('111111'), 3, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_VALIDATOR', '邮件认证', 'true', 4, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_MAIL', 'PROPERTIES_MAIL_FORMAT', '邮件格式', 'iidooo.com', 5, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_PAGING', 'PROPERTIES_PAGING_PAGESIZE', '每页显示行总数', '5', 1, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ZHCN', '简体中文', 'zh_CN', 1, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ZHTW', '繁體中文', 'zh_TW', 2, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_JAPANESE', '日本語', 'ja_JP', 3, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_LANG', 'PROPERTIES_LANG_ENGLISH', 'English', 'en_US', 4, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'PROPERTIES_SITE_DOMAIN', '域名', 'www.iidooo.com', 1, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'PROPERTIES_SITE_URL', '网址', 'http://localhost:8080/cms', 2, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);

INSERT INTO `IDO_DICT_ITEM` (`ParentItemID`, `DictClassCode`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Weight`, `IsDefault`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `IsReadonly`, `IsDisable`, `IsDelete`, `Version`) 
VALUES (0, 'PROPERTIES_SITE', 'PROPERTIES_SITE_RES_ROOT', '资源根目录', 'http://localhost:8080/cms/templates/default/res', 3, 0, '', 'zh_CN', now(), 1, now(), 1, 0, 0, 0, 1);