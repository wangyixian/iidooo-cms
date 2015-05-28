package com.iidooo.core.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LoadSiteService {

//	public List<SiteDto> getSites() throws Exception {
//		List<SiteDto> siteDtos = new ArrayList<SiteDto>();
//
//		InputStream is = this.getClass().getResourceAsStream("/site.xml");
//		SAXReader saxReader = new SAXReader();
//		Document document = saxReader.read(is);
//		Element sites = document.getRootElement();
//		List<Element> siteList = sites.elements();
//		for (Element site : siteList) {
//			SiteDto siteDto = new SiteDto();
//			siteDto.setId(site.attribute("id").getValue());
//			siteDto.setName(site.attribute("name").getValue());
//			siteDto.setUrl(site.attribute("url").getValue());
//			siteDto.setComment(site.attribute("comment").getValue());
//			siteDtos.add(siteDto);
//		}
//		return siteDtos;
//	}

	public static void main(String[] args) throws Exception {
		LoadSiteService svr = new LoadSiteService();
		//svr.getSites();
	}
	// public void createXml(String fileName) {
	// Document document = DocumentHelper.createDocument();
	// Element employees = document.addElement("employees");
	// Element employee = employees.addElement("employee");
	// Element name = employee.addElement("name");
	// name.setText("ddvip");
	// Element sex = employee.addElement("sex");
	// sex.setText("m");
	// Element age = employee.addElement("age");
	// age.setText("29");
	// try {
	// Writer fileWriter = new FileWriter(fileName);
	// XMLWriter xmlWriter = new XMLWriter(fileWriter);
	// xmlWriter.write(document);
	// xmlWriter.close();
	// } catch (IOException e) {
	//
	// System.out.println(e.getMessage());
	// }
	//
	// }
}
