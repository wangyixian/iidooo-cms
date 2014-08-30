package com.iidooo.framework.common;

/**
 * 共通的常量类
 * 
 * @author wangyixian
 * 
 */
public class Constants {

	/**
	 * 登录用户的Session所用Key
	 */
	public static final String SESSION_USER = "SessionUser";

	/**
	 * 分页设置每页多少的字典项
	 */
	public static final String DICT_ITEM_PAGESIZE = "PROPERTIES_PAGING_PAGESIZE";

	/**
	 * 阿里云开放存储服务的Bucket名称字典项
	 */
	public static final String DICT_ITEM_ALIOSS_BUCKET = "PROPERTIES_ALIOSS_BUCKET";
	/**
	 * 阿里云开放存储服务的ID字典项
	 */
	public static final String DICT_ITEM_ALIOSS_ID = "PROPERTIES_ALIOSS_ID";
	/**
	 * 阿里云开放存储服务的密码字典项
	 */
	public static final String DICT_ITEM_ALIOSS_SECRET = "PROPERTIES_ALIOSS_SECRET";

	/**
	 * 数据库查询升序
	 */
	public static final String DB_SORT_ASC = "asc";

	/**
	 * 数据库查询降序
	 */
	public static final String DB_SORT_DESC = "desc";

	/**
	 * 数据库字段UpdateTime
	 */
	public static final String DB_FIELD_UPDATETIME = "UpdateTime";

	public static final String FILE_TYPE_GIF = "gif";
	public static final String FILE_TYPE_JPG = "jpg";
	public static final String FILE_TYPE_PNG = "png";
	public static final String FILE_TYPE_BMP = "bmp";

	/**
	 * 日期格式
	 */
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	/**
	 * 日期时间格式
	 */	
	public static final String FORMAT_DATETIME = "yyyy-MM-dd hh:ss:mm";
}
