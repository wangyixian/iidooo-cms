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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '是否是只读，非0即只读',
  `IsDisable` INT NOT NULL COMMENT '非0即不可用',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NULL COMMENT '只读',
  `IsDisable` INT NOT NULL COMMENT '有效无效标识',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '非0即只读，不能修改',
  `IsDisable` INT NOT NULL COMMENT '非0即不可用',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '非0即只读',
  `IsDisable` INT NOT NULL COMMENT '非0即不可用',
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
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '只读',
  `IsDisable` INT NOT NULL COMMENT '不可用',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '只读标识',
  `IsDisable` INT NOT NULL COMMENT '无效标识',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '只读标识',
  `IsDisable` INT NOT NULL COMMENT '无效标识',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '只读标识',
  `IsDisable` INT NOT NULL COMMENT '无效标识',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsReadonly` INT NOT NULL COMMENT '只读标识',
  `IsDisable` INT NOT NULL COMMENT '无效标识',
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
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本')
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
  `MetaKeyworlds` VARCHAR(256) NOT NULL COMMENT '关键字',
  `MetaDescription` VARCHAR(1024) NOT NULL COMMENT 'Meta描述',
  `Weight` INT NOT NULL COMMENT '权重',
  `IsHidden` INT NOT NULL COMMENT '栏目的不可见',
  `TargetType` VARCHAR(16) NOT NULL COMMENT '是否在新窗口打开',
  `URL` VARCHAR(1024) NOT NULL,
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
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
  `Language` VARCHAR(32) NOT NULL COMMENT '多语言设置',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`TemplateID`))
ENGINE = InnoDB
COMMENT = '内容表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
