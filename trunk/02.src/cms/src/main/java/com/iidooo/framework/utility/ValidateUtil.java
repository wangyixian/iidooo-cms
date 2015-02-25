package com.iidooo.framework.utility;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public final class ValidateUtil {

    private static Logger logger = Logger.getLogger(ValidateUtil.class);

    /**
     * 字符串为空验证（null或"").
     *
     * @param str 验证文字列
     * @return true:(null或"") false:非空
     */
    public static boolean isEmpty(final String str) {

        logger.debug("The begin of the method ValidatorUtil.isEmpty");
        boolean flg = false;
        if (str == null || str.length() == 0) {
            flg = true;
        }
        logger.debug("The end of the method ValidatorUtil.isEmpty");
        return flg;
    }
    /*
    *//**
     * 字符串为空验证(null或trim后"").
     *
     * @param str 验证文字列
     * @return true:(null或trim后为"") false:非空
     */
    /*
     * public static boolean isEmptyIgnoreSpace(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isEmptyIgnoreSpace"); boolean flg = false; if (str == null || str.trim().length()
     * == 0) { flg = true; } logger.debug("The end of the method ValidatorUtil.isEmptyIgnoreSpace"); return flg; }
     *//**
     * 字符串非空验证（非null且非""）.
     *
     * @param str 验证文字列
     * @return true:(null或"") false:非空
     */
    /*
     * public static boolean isNotEmpty(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isNotEmpty"); boolean flg = false; if (str != null && str.length() > 0) { flg =
     * true; } logger.debug("The end of the method ValidatorUtil.isNotEmpty"); return flg; }
     *//**
     * 字符串非空验证(非null且trim后非"").
     *
     * @param str 验证文字列
     * @return true:(null或trim后为"") false:非空
     */
    /*
     * public static boolean isNotEmptyIgnoreSpace(final String str) {
     * logger.debug("The begin of the method ValidatorUtil.isNotEmptyIgnoreSpace"); boolean flg = false; if (str != null &&
     * str.trim().length() >= 0) { flg = true; } logger.debug("The end of the method ValidatorUtil.isNotEmptyIgnoreSpace"); return flg; }
     *//**
     * 是否是纯数字组合的字符串验证.
     *
     * @param str 对象文字列
     * @return true:数字组合字符串 false:非数字组合字符串
     */
    /*
     * public static boolean isStrNumber(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isStrNumber"); if (isEmptyIgnoreSpace(str)) { return false; } Pattern pattern =
     * Pattern.compile(Constants.REGEX_NUMBER_STR); boolean flg = pattern.matcher(str).matches();
     * logger.debug("The end of the method ValidatorUtil.isStrNumber"); return flg; }
     *//**
     * 金额类数据字符串验证（可带小数点的金额类数据）.
     *
     * @param str 对象文字列
     * @return true false
     */
    /*
     * public static boolean isNumeric(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isNumeric"); if (isEmptyIgnoreSpace(str)) { return false; } Pattern pattern =
     * Pattern.compile(Constants.REGEX_NUMERIC_STR); boolean flg = pattern.matcher(str).matches();
     * logger.debug("The end of the method ValidatorUtil.isNumeric"); return flg; }
     *//**
     * 是否是英文字母验证.
     *
     * @param str 对象文字列
     * @return true:是英文字母字符串 false:非英文字母字符串
     */
    /*
     * public static boolean isEnglish(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isEnglish"); if (isEmptyIgnoreSpace(str)) { return false; } Pattern pattern =
     * Pattern.compile(Constants.REGEX_ENGLISH_STR); boolean flg = pattern.matcher(str).matches();
     * logger.debug("The end of the method ValidatorUtil.isEnglish"); return flg; }
     *//**
     * 验证匹配由数字和26个英文字母组成的字符串.
     *
     * @param str 验证文字列
     * @return boolean
     */
    /*
     * public static boolean strNumberEnglish(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.strNumberEnglish"); if (isEmptyIgnoreSpace(str)) { return false; } Pattern
     * pattern = Pattern.compile(Constants.REGEX_ENGLISH_NUMBER_STR); boolean flg = pattern.matcher(str).matches();
     * logger.debug("The end of the method ValidatorUtil.strNumberEnglish"); return flg; }
     *//**
     * 字符特定长度验证.
     *
     * @param str 对象文字列
     * @param length 文字列的长度
     * @return true:字符位数正确 false:字符位数不正
     */
    /*
     * public static boolean strLength(final String str, final int length) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.strLength"); if (isEmptyIgnoreSpace(str)) { return false; } boolean flg = false;
     * if (str.length() == length) { flg = true; } logger.debug("The end of the method ValidatorUtil.strLength"); return flg; }
     *//**
     * 字符特定长度范围验证.
     *
     * @param str 对象文字列
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return true:字符位数范围正确 false:字符位数范围不正
     */
    /*
     * public static boolean strLengthRanger(final String str, final int minLength, final int maxLength) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.strLengthRanger"); if (isEmptyIgnoreSpace(str) || minLength > maxLength) { return
     * false; } int strlength = str.length(); boolean flg = false; if (strlength >= minLength && strlength <= maxLength) { flg = true; }
     * logger.debug("The end of the method ValidatorUtil.strLengthRanger"); return flg; }
     *//**
     * 全角字符验证（是否为全角字符）.
     *
     * @param str 判定的文字列
     * @return true:验证正确 false:验证不正
     */
    /*
     * public static boolean checkWideChar(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.checkWideChar"); boolean flg = false; try { if (isNotEmpty(str)) { byte[] abyte =
     * str.getBytes(Constants.EUC_JP); for (int i = 0; i < abyte.length; i++) { byte be = abyte[i]; if (be >= 0 && be <=
     * Constants.NUMBER_127 || be == Constants.NUMBER_MINUS_114) { if (be == Constants.NUMBER_63) { for (int j = 0; j < str.length(); j++) {
     * char c = str.charAt(j); if (c == Constants.CHAR_QUESTION) { flg = false; break; } } } else { flg = false; break; } } } } } catch
     * (UnsupportedEncodingException exception) { flg = false; } logger.debug("The end of the method ValidatorUtil.checkWideChar"); return
     * flg; }
     *//**
     * 半角字符验证（是否为半角字符）.
     *
     * @param str 判定的文字列
     * @return true:验证正确 false:验证不正
     */
    /*
     * public static boolean checkHalfChar(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.checkHalfChar"); boolean flg = true; if (isNotEmptyIgnoreSpace(str)) { char
     * cTemp; for (int i = 0; str.length() > i; i++) { cTemp = str.charAt(i); if (!((cTemp >= Constants.CHAR_EXCLAMATION && cTemp <=
     * Constants.CHAR_TILDE) || (cTemp >= Constants.CHAR_PERIOD && cTemp <= Constants.CHAR_UP_PERIOD) || (cTemp == Constants.CHAR_SPACE))) {
     * flg = false; break; } } } logger.debug("The end of the method ValidatorUtil.checkHalfChar"); return flg; }
     *//**
     * 邮箱格式验证.
     *
     * @param email 验证邮箱地址文字列
     * @return true:格式正确 false:格式不正
     */
    /*
     * public static boolean emailFormateValidate(final String email) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.emailFormateValidate"); boolean flg = false; if (isNotEmptyIgnoreSpace(email)) {
     * Pattern p = Pattern.compile(Constants.REGEX_EMAIL_FORMATE); Matcher m = p.matcher(email); flg = m.matches(); }
     * logger.debug("The end of the method ValidatorUtil.emailFormateValidate"); return flg; }
     *//**
     * 网址URL格式验证.
     *
     * @param url 验证网址URL文字列
     * @return true:格式正确 false:格式不正
     */
    /*
     * public static boolean urlFormateValidate(final String url) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.urlFormateValidate"); boolean flg = false; if (isNotEmptyIgnoreSpace(url)) {
     * Pattern p = Pattern.compile(Constants.REGEX_URL_FORMATE); Matcher m = p.matcher(url); flg = m.matches(); }
     * logger.debug("The end of the method ValidatorUtil.urlFormateValidate"); return flg; }
     *//**
     * 日期格式验证（严格的日期格式yyyy/MM/dd）.
     *
     * @param date 验证日期文字列
     * @return true:格式正确 false:格式不正
     */
    /*
     * public static boolean dateFormateValidate(final String date) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.dateFormateValidate"); boolean formateFlg = false; if
     * (isNotEmptyIgnoreSpace(date)) { Pattern p = Pattern.compile(Constants.REGEX_DATE_FORMATE); Matcher m = p.matcher(date); // 匹配格式有
     * YYYY-MM-DD； YYYY/MM/DD ；YYYY.MM.DD if (m.matches()) { if (date.length() == Constants.NUMBER_10 &&
     * date.indexOf(Constants.STRING_SLASH) > 0) { formateFlg = true; } } }
     * logger.debug("The end of the method ValidatorUtil.dateFormateValidate"); return formateFlg; }
     *//**
     * 日期格式验证.
     *
     * @param strDateTime 验证日期文字列
     * @param dateFormate 验证日期文字列格式
     * @return true：日期格式正确 false：日期格式不正
     */
    /*
     * public static boolean checkDateFormatAndValidate(final String strDateTime, final String dateFormate) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.checkDateFormatAndValidate"); boolean flg = false; try { SimpleDateFormat format
     * = new SimpleDateFormat(dateFormate); Date ndate = format.parse(strDateTime); String str = format.format(ndate); if
     * (str.equals(strDateTime)) { flg = true; } } catch (Exception e) { return flg; }
     * logger.debug("The end of the method ValidatorUtil.checkDateFormatAndValidate"); return flg; }
     *//**
     * 验证字符串中是否含特殊字符(特殊字符数组(<,>,&,",')).
     *
     * @param str 验证文字列
     * @return true :含有特殊字符 false :不含有特殊字符
     */
    /*
     * public static boolean indexOfSpecialCharacter(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.indexOfSpecialCharacter"); boolean flg = false; // 非空判断 if
     * (isNotEmptyIgnoreSpace(str)) { for (String chara : Constants.SPECIAL_CHARACTER) { if (str.indexOf(chara) >= 0) { flg = true; break; }
     * } } logger.debug("The end of the method ValidatorUtil.indexOfSpecialCharacter"); return flg; }
     *//**
     * 是否是中文验证.
     *
     * @param str 对象文字列
     * @return true:是中文字符串 false:非中文字符串
     */
    /*
     * public static boolean isChinese(final String str) {
     * 
     * logger.debug("The begin of the method ValidatorUtil.isChinese"); if (isEmptyIgnoreSpace(str)) { return false; } Pattern pattern =
     * Pattern.compile(Constants.REGEX_CHINESE_STR); boolean flg = pattern.matcher(str).matches();
     * logger.debug("The end of the method ValidatorUtil.isChinese"); return flg; }
     */
}