package com.iidooo.framework.utility;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring框架共通处理类
 * 
 * @author wangyixian
 * 
 */
public class SpringUtil {

	/**
	 * 得到Spring容器管理的对象
	 * 
	 * @param sc
	 *            ServletContext
	 * @param beanName
	 *            对象的实例名
	 * @return 从容器中获取的对象
	 */
	public static Object getBean(ServletContext sc, String beanName) {
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		Object beanObj = appContext.getBean(beanName);
		return beanObj;
	}
}
