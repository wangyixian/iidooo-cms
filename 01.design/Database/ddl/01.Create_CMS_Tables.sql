SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `IDOCMS` ;
CREATE SCHEMA IF NOT EXISTS `IDOCMS` DEFAULT CHARACTER SET utf8 ;
USE `IDOCMS` ;

-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_DICT_TYPE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_DICT_TYPE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_DICT_TYPE` (
  `DictTypeID` INT NOT NULL AUTO_INCREMENT COMMENT '字典类型的主键ID',
  `DictTypeCode` VARCHAR(128) NOT NULL COMMENT '字典类型编码',
  `DictTypeName` VARCHAR(256) NOT NULL COMMENT '字典类型名',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '备注信息',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`DictTypeID`))
ENGINE = InnoDB
COMMENT = '字典类型表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SAMPLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SAMPLE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SAMPLE` (
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_DICT_CLASS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_DICT_CLASS` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_DICT_CLASS` (
  `DictClassID` INT NOT NULL AUTO_INCREMENT COMMENT '字典类的主键',
  `DictTypeCode` VARCHAR(128) NOT NULL COMMENT '关联字典类型的Code',
  `DictClassCode` VARCHAR(128) NOT NULL COMMENT '字典类的编码',
  `DictClassName` VARCHAR(256) NOT NULL COMMENT '字典类名字',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`DictClassID`))
ENGINE = InnoDB
COMMENT = '字典类';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_DICT_ITEM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_DICT_ITEM` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_DICT_ITEM` (
  `DictItemID` INT NOT NULL AUTO_INCREMENT COMMENT '字典项目ID',
  `ParentItemID` INT NOT NULL COMMENT '父项目ID',
  `DictClassCode` VARCHAR(128) NOT NULL COMMENT '字典项目所属类的ID',
  `DictItemCode` VARCHAR(128) NOT NULL COMMENT '字典项目的编码',
  `DictItemName` VARCHAR(256) NOT NULL COMMENT '字典编码的名字',
  `DictItemValue` VARCHAR(256) NOT NULL COMMENT '字典项目的值',
  `Weight` INT NOT NULL COMMENT '字典项目的序列',
  `IsDefault` INT NOT NULL COMMENT '非0即默认选项',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '备注信息',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`DictItemID`))
ENGINE = InnoDB
COMMENT = '字典项目';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SECURITY_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SECURITY_USER` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SECURITY_USER` (
  `UserID` INT NOT NULL AUTO_INCREMENT COMMENT '用户ID主键',
  `LoginID` VARCHAR(256) NOT NULL COMMENT '登录ID',
  `Password` VARCHAR(256) NOT NULL COMMENT '登录密码',
  `LoginTime` VARCHAR(32) NOT NULL COMMENT '登录时间',
  `IsDisable` INT NOT NULL COMMENT '不可用',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB
COMMENT = '安全权限的用户表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SECURITY_ROLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SECURITY_ROLE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SECURITY_ROLE` (
  `RoleID` INT NOT NULL AUTO_INCREMENT COMMENT '角色ID主键',
  `RoleName` VARCHAR(256) NOT NULL COMMENT '角色名',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`RoleID`))
ENGINE = InnoDB
COMMENT = '安全权限的角色表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SECURITY_USER_ROLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SECURITY_USER_ROLE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SECURITY_USER_ROLE` (
  `UserRoleID` INT NOT NULL AUTO_INCREMENT COMMENT '用户角色ID主键',
  `UserID` INT NOT NULL COMMENT '角色ID外键',
  `RoleID` INT NOT NULL COMMENT '角色ID',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`UserRoleID`))
ENGINE = InnoDB
COMMENT = '安全权限的用户角色关系表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SECURITY_RESOURCE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SECURITY_RESOURCE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SECURITY_RESOURCE` (
  `ResourceID` INT NOT NULL AUTO_INCREMENT COMMENT '资源ID主键',
  `ParentResourceID` INT NOT NULL COMMENT '父资源ID',
  `ResourceName` VARCHAR(128) NOT NULL COMMENT '资源名称',
  `ResourceURL` VARCHAR(1024) NOT NULL COMMENT '资源路径',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ResourceID`))
ENGINE = InnoDB
COMMENT = '安全权限的资源表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_SECURITY_ROLE_RESOURCE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_SECURITY_ROLE_RESOURCE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_SECURITY_ROLE_RESOURCE` (
  `RoleResourceID` INT NOT NULL AUTO_INCREMENT COMMENT '角色资源ID主键',
  `RoleID` INT NOT NULL COMMENT '角色ID',
  `ResourceID` VARCHAR(128) NOT NULL COMMENT '资源ID',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`RoleResourceID`))
ENGINE = InnoDB
COMMENT = '安全权限的角色资源表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_CONTENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_CONTENT` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_CONTENT` (
  `ContentID` INT NOT NULL AUTO_INCREMENT COMMENT '内容主键ID',
  `ChannelID` INT NOT NULL COMMENT '所属栏目',
  `TemplateID` INT NOT NULL COMMENT '所属模板',
  `Title` VARCHAR(256) NOT NULL COMMENT '内容标题',
  `Alias` VARCHAR(256) NOT NULL COMMENT '别名',
  `TitleImage` VARCHAR(1024) NOT NULL COMMENT '图片标题的URL',
  `SubTitle` VARCHAR(256) NOT NULL COMMENT '副标题',
  `MetaTitle` VARCHAR(256) NOT NULL,
  `MetaKeyworlds` VARCHAR(1024) NOT NULL COMMENT '关键字',
  `MetaDescription` VARCHAR(1024) NOT NULL COMMENT '描述',
  `ContentSummary` VARCHAR(512) NOT NULL,
  `ContentBody` TEXT NOT NULL COMMENT '文本内容',
  `ContentSource` VARCHAR(1024) NOT NULL COMMENT '内容来源',
  `ContentAuthor` VARCHAR(256) NOT NULL COMMENT '作者',
  `Weight` INT NOT NULL,
  `IsAllowComment` INT NOT NULL COMMENT '是否允许评论',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ContentID`))
ENGINE = InnoDB
COMMENT = '内容表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_CHANNEL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_CHANNEL` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_CHANNEL` (
  `ChannelID` INT NOT NULL AUTO_INCREMENT COMMENT '栏目ID',
  `TemplateID` INT NOT NULL COMMENT '关联模板ID',
  `ParentChannelID` INT NOT NULL COMMENT '父栏目ID',
  `ChannelName` VARCHAR(64) NOT NULL COMMENT '栏目名称',
  `ChannelPath` VARCHAR(256) NOT NULL COMMENT '栏目路径',
  `MetaTitle` VARCHAR(256) NOT NULL COMMENT 'Meta标题',
  `MetaKeyworlds` VARCHAR(1024) NOT NULL COMMENT '关键字',
  `MetaDescription` VARCHAR(1024) NOT NULL COMMENT 'Meta描述',
  `Weight` INT NOT NULL COMMENT '权重',
  `IsHidden` INT NOT NULL COMMENT '栏目的不可见',
  `URL` VARCHAR(1024) NOT NULL,
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ChannelID`))
ENGINE = InnoDB
COMMENT = '栏目表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_SAMPLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_SAMPLE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_SAMPLE` (
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本')
ENGINE = InnoDB
COMMENT = '内容表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_TEMPLATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_TEMPLATE` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_TEMPLATE` (
  `TemplateID` INT NOT NULL AUTO_INCREMENT COMMENT '模板主键ID',
  `TemplateName` VARCHAR(128) NOT NULL,
  `TemplateSource` VARCHAR(1024) NOT NULL COMMENT '模板路径',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`TemplateID`))
ENGINE = InnoDB
COMMENT = '内容表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_FIELD_MODEL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_FIELD_MODEL` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_FIELD_MODEL` (
  `ModelID` INT NOT NULL AUTO_INCREMENT COMMENT '字段模型的主键ID',
  `ModelName` VARCHAR(128) NOT NULL COMMENT '模型名',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ModelID`))
ENGINE = InnoDB
COMMENT = '扩展字段模型';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_FIELD_CONFIG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_FIELD_CONFIG` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_FIELD_CONFIG` (
  `FieldID` INT NOT NULL AUTO_INCREMENT COMMENT '字段主键ID',
  `ModelID` INT NOT NULL COMMENT '关联模型',
  `FieldCode` VARCHAR(128) NOT NULL COMMENT '字段编码',
  `FieldName` VARCHAR(128) NOT NULL COMMENT '字段名',
  `FieldType` INT NOT NULL COMMENT '字段类型',
  `Weight` INT NOT NULL COMMENT '权重',
  `DefaultValue` VARCHAR(256) NOT NULL COMMENT '默认值',
  `Options` VARCHAR(512) NOT NULL COMMENT '字段可选项，多个用,分割',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`FieldID`))
ENGINE = InnoDB
COMMENT = '字段配置';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_FIELD_DATA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_FIELD_DATA` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_FIELD_DATA` (
  `DataID` INT NOT NULL AUTO_INCREMENT COMMENT '字段数据主键',
  `TableDataID` INT NOT NULL COMMENT '表数据关联ID',
  `FieldCode` VARCHAR(128) NOT NULL COMMENT '关联字段',
  `FieldValue` VARCHAR(256) NOT NULL COMMENT '字段的值',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`DataID`))
ENGINE = InnoDB
COMMENT = '字段数据';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_ATTACH_ALBUM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_ATTACH_ALBUM` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_ATTACH_ALBUM` (
  `AlbumID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ContentID` INT NOT NULL COMMENT '所属内容',
  `TemplateID` INT NOT NULL,
  `Title` VARCHAR(256) NOT NULL COMMENT '专辑名',
  `SubTitle` VARCHAR(256) NOT NULL,
  `Classify` INT NOT NULL COMMENT '专辑类型',
  `Weight` INT NOT NULL,
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`AlbumID`))
ENGINE = InnoDB
COMMENT = '附件专辑';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_ATTACH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_ATTACH` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_ATTACH` (
  `AttachID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `AlbumID` INT NOT NULL COMMENT '所属专辑',
  `TemplateID` INT NOT NULL,
  `Name` VARCHAR(256) NOT NULL COMMENT '附件名称',
  `SubName` VARCHAR(256) NOT NULL,
  `URL` VARCHAR(1024) NOT NULL COMMENT '附件路径',
  `Weight` INT NOT NULL,
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`AttachID`))
ENGINE = InnoDB
COMMENT = '附件表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_CONTENT_TAG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_CONTENT_TAG` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_CONTENT_TAG` (
  `TagID` INT NOT NULL AUTO_INCREMENT,
  `ContentID` INT NOT NULL COMMENT '关联内容ID',
  `ClassCode` VARCHAR(128) NOT NULL COMMENT '标签分类',
  `ItemCode` VARCHAR(128) NOT NULL COMMENT '标签项',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`TagID`))
ENGINE = InnoDB
COMMENT = '内容标签关联表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_STATISTICS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_STATISTICS` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_STATISTICS` (
  `StatisticsID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `TableName` VARCHAR(128) NOT NULL COMMENT '统计表名',
  `TableDataID` INT NOT NULL COMMENT '统计目标数据',
  `StatisticsIP` VARCHAR(256) NOT NULL COMMENT '统计IP地址',
  `StatisticsType` INT NOT NULL COMMENT '统计类型',
  `StatisticsValue` INT NOT NULL COMMENT '统计值',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`StatisticsID`))
ENGINE = InnoDB
COMMENT = '统计表';


-- -----------------------------------------------------
-- Table `IDOCMS`.`IDO_CMS_COMMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDOCMS`.`IDO_CMS_COMMENT` ;

CREATE TABLE IF NOT EXISTS `IDOCMS`.`IDO_CMS_COMMENT` (
  `CommentID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `TableName` VARCHAR(128) NOT NULL,
  `TableDataID` INT NOT NULL,
  `ParentCommentID` INT NOT NULL COMMENT '上级评论ID',
  `Comment` TEXT NOT NULL COMMENT '评论内容',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`CommentID`))
ENGINE = InnoDB
COMMENT = '评论表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
