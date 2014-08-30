-- -----------------------------------------------------
-- IDO_DICT_TYPE的初始化数据
-- -----------------------------------------------------
INSERT INTO `CMS`.`IDO_DICT_TYPE` (`DictTypeID`, `DictTypeCode`, `DictTypeName`, `ReadonlyFlag`, `DisableFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', 'TYPE_PROPERTIES', '系统配置', '1', '0', '系统的配置信息', 'zh-CN', now(), '1', now(), '1', '0', '1');

-- -----------------------------------------------------
-- IDO_DICT_CLASS的初始化数据
-- -----------------------------------------------------
INSERT INTO `CMS`.`IDO_DICT_CLASS` (`DictClassID`, `DictTypeID`, `DictClassCode`, `DictClassName`, `ReadonlyFlag`, `DisableFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '1', 'PROPERTIES_MAIL', '邮件配置', '1', '0', '邮件配置类', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_CLASS` (`DictClassID`, `DictTypeID`, `DictClassCode`, `DictClassName`, `ReadonlyFlag`, `DisableFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('2', '1', 'PROPERTIES_PAGING', '分页配置', '1', '0', '分页配置类', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_CLASS` (`DictClassID`, `DictTypeID`, `DictClassCode`, `DictClassName`, `ReadonlyFlag`, `DisableFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '1', 'PROPERTIES_LANG', '语言类型', '0', '0', '语言类型类', 'zh-CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_CLASS` (`DictClassID`, `DictTypeID`, `DictClassCode`, `DictClassName`, `ReadonlyFlag`, `DisableFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('4', '1', 'PROPERTIES_SITE', '站点配置', '0', '0', '站点配置类', 'zh-CN', now(), '1', now(), '1', '0', '1');

-- -----------------------------------------------------
-- IDO_DICT_ITEM的初始化数据
-- -----------------------------------------------------
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('1', '1', 'PROPERTIES_MAIL_SMTP', 'SMTP服务器地址', '192.168.2.4', '1', '1', '0', '0', 'SMTP服务器地址', 'zh_CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('2', '1', 'PROPERTIES_MAIL_FROM', '邮件来自', 'huanggang@sot-soft.com', '2', '1', '0', '0', '邮件来自', 'zh_CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('3', '1', 'PROPERTIES_MAIL_PASSWORD', '邮件密码', MD5('huanggang201212'), '3', '1', '0', '0', '邮件密码', 'zh_CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('4', '1', 'PROPERTIES_MAIL_VALIDATOR', '邮件认证', 'true', '4', '1', '0', '0', '邮件认证', 'zh_CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('5', '1', 'PROPERTIES_MAIL_FORMAT', '邮件格式', 'sot-soft.com', '5', '1', '0', '0', '邮件格式', 'zh_CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('6', '2', 'PROPERTIES_PAGING_PAGESIZE', '每页显示行总数', '5', '1', '1', '0', '0', '每页显示行总数', 'zh_CN', now(), '1', now(), '1', '0', '1');

INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('7', '3', 'PROPERTIES_LANG_ZHCN', '简体中文', 'zh_CN', '1', '0', '0', '1', '简体中文', 'zh_CN', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('8', '3', 'PROPERTIES_LANG_ZHTW', '繁體中文', 'zh_TW', '1', '0', '0', '1', '繁體中文', 'zh_TW', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('9', '3', 'PROPERTIES_LANG_JAPANESE', '日本語', 'ja_JP', '1', '0', '0', '1', '日本語', 'ja_JP', now(), '1', now(), '1', '0', '1');
INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('10', '3', 'PROPERTIES_LANG_ENGLISH', 'English', 'en_US', '1', '0', '0', '1', 'English', 'en_US', now(), '1', now(), '1', '0', '1');

INSERT INTO `CMS`.`IDO_DICT_ITEM` 
(`DictItemID`, `DictClassID`, `DictItemCode`, `DictItemName`, `DictItemValue`, `Sequence`, `ReadonlyFlag`, `DisableFlag`, `DefaultFlag`, `Remarks`, `Language`, `CreateTime`, `CreateUser`, `UpdateTime`, `UpdateUser`, `DeleteFlag`, `Version`) 
VALUES ('11', '4', 'PROPERTIES_SITE_DOMAIN', '域名', 'www.iidooo.com', '1', '0', '0', '1', '域名', 'zh_CN', now(), '1', now(), '1', '0', '1');