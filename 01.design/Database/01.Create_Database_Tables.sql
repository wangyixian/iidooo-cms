-- -----------------------------------------------------
-- Table `IDO_CMS_CONTENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_CONTENT` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_CONTENT` (
  `ContentID` INT NOT NULL AUTO_INCREMENT COMMENT '内容主键ID',
  `ChannelID` INT NOT NULL COMMENT '所属栏目',
  `TemplateID` INT NOT NULL COMMENT '所属模板',
  `ContentTitle` VARCHAR(256) NOT NULL COMMENT '内容标题',
  `ContentSubTitle` VARCHAR(256) NOT NULL COMMENT '副标题',
  `ContentImageTitle` VARCHAR(1024) NOT NULL COMMENT '图片标题的URL',
  `ContentAlias` VARCHAR(256) NOT NULL COMMENT '别名',
  `MetaTitle` VARCHAR(256) NOT NULL,
  `MetaKeywords` VARCHAR(1024) NOT NULL COMMENT '关键字',
  `MetaDescription` VARCHAR(1024) NOT NULL COMMENT '描述',
  `ContentSummary` VARCHAR(512) NOT NULL,
  `ContentBody` TEXT NOT NULL COMMENT '文本内容',
  `ContentSource` VARCHAR(1024) NOT NULL COMMENT '内容来源',
  `ContentAuthor` VARCHAR(256) NOT NULL COMMENT '作者',
  `Sequence` INT NOT NULL,
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
-- Table `IDO_CMS_CHANNEL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_CHANNEL` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_CHANNEL` (
  `ChannelID` INT NOT NULL AUTO_INCREMENT COMMENT '栏目ID',
  `TemplateID` INT NOT NULL COMMENT '关联模板ID',
  `ParentID` INT NOT NULL COMMENT '父栏目ID',
  `ChannelName` VARCHAR(64) NOT NULL COMMENT '栏目名称',
  `ChannelPath` VARCHAR(256) NOT NULL COMMENT '栏目路径',
  `MetaTitle` VARCHAR(256) NOT NULL COMMENT 'Meta标题',
  `MetaKeywords` VARCHAR(1024) NOT NULL COMMENT '关键字',
  `MetaDescription` VARCHAR(1024) NOT NULL COMMENT 'Meta描述',
  `Sequence` INT NOT NULL COMMENT '权重',
  `IsHidden` INT NOT NULL COMMENT '栏目的不可见',
  `ExternalURL` VARCHAR(1024) NOT NULL COMMENT '外部链接',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL DEFAULT 0 COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL DEFAULT 1 COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ChannelID`))
ENGINE = InnoDB
COMMENT = '栏目表';

-- -----------------------------------------------------
-- Table `IDO_CMS_TEMPLATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_TEMPLATE` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_TEMPLATE` (
  `TemplateID` INT NOT NULL AUTO_INCREMENT COMMENT '模板主键ID',
  `TemplateName` VARCHAR(128) NOT NULL,
  `TemplatePath` VARCHAR(1024) NOT NULL COMMENT '模板路径',
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
-- Table `IDO_CMS_ATTACH_ALBUM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_ATTACH_ALBUM` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_ATTACH_ALBUM` (
  `AlbumID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ContentID` INT NOT NULL COMMENT '所属内容',
  `TemplateID` INT NOT NULL,
  `AlbumTitle` VARCHAR(256) NOT NULL COMMENT '专辑名',
  `AlbumSubTitle` VARCHAR(256) NOT NULL,
  `AlbumClassify` INT NOT NULL COMMENT '专辑类型',
  `Sequence` INT NOT NULL,
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
-- Table `IDO_CMS_ATTACH`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_ATTACH` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_ATTACH` (
  `AttachID` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `AlbumID` INT NOT NULL COMMENT '所属专辑',
  `TemplateID` INT NOT NULL,
  `AttachTitle` VARCHAR(256) NOT NULL COMMENT '附件名称',
  `AttachSubTitle` VARCHAR(256) NOT NULL,
  `AttachURL` VARCHAR(1024) NOT NULL COMMENT '附件路径',
  `Sequence` INT NOT NULL,
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
-- Table `IDO_CMS_CONTENT_TAG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_CONTENT_TAG` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_CONTENT_TAG` (
  `ContentTagID` INT NOT NULL AUTO_INCREMENT,
  `ContentID` INT NOT NULL COMMENT '关联内容ID',
  `TagID` INT NOT NULL COMMENT '标签分类',
  `Remarks` VARCHAR(1024) NOT NULL COMMENT '描述备注',
  `CreateTime` VARCHAR(32) NOT NULL COMMENT '字段创建时间',
  `CreateUser` INT NOT NULL COMMENT '字段创建者ID',
  `UpdateTime` VARCHAR(32) NOT NULL COMMENT '字段更新时间',
  `UpdateUser` INT NOT NULL COMMENT '字段更新者ID',
  `IsDelete` INT NOT NULL COMMENT '逻辑删除的Flag，非0即删除',
  `Version` INT NOT NULL COMMENT '排他用该字段的版本',
  PRIMARY KEY (`ContentTagID`))
ENGINE = InnoDB
COMMENT = '内容标签关联表';


-- -----------------------------------------------------
-- Table `IDO_CMS_STATISTICS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_STATISTICS` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_STATISTICS` (
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
-- Table `IDO_CMS_COMMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_COMMENT` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_COMMENT` (
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


-- -----------------------------------------------------
-- Table `IDO_CMS_TAG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `IDO_CMS_TAG` ;

CREATE TABLE IF NOT EXISTS `IDO_CMS_TAG` (
  `TagID` INT NOT NULL AUTO_INCREMENT,
  `TagName` VARCHAR(256) NOT NULL COMMENT '标签名',
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

