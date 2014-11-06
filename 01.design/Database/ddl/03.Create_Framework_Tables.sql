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

