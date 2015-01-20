package com.iidooo.framework.tag;

import java.util.ArrayList;

public class TreeNode {
	private String code;
	private TreeNode parent;
	private String name;
	private ArrayList<TreeNode> children;
	private String icon;
	private String url;
	private Object tag;
	
	public TreeNode(String code, String name) {
		children = new ArrayList<TreeNode>();

		this.code = code;
		this.name = name;
	}

	public TreeNode(String code, String name, TreeNode parentNode) {
		children = new ArrayList<TreeNode>();

		this.code = code;
		this.name = name;
		if (parentNode != null) {
			this.parent = parentNode;
			this.parent.children.add(this);
		}
	}

	public TreeNode(String code, String name, Object tag) {
		this.code = code;
		this.name = name;
		this.tag = tag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getTag() {
		return tag;
	}

	public void setTag(Object tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("<li class='tree-node expandable'>");
		sb.append("<div class='hitarea expandable-hitarea'></div>");
		sb.append("<input id='code' type='hidden' value='" + this.code + "'>");
		sb.append("<input id='tag' type='hidden' value='" + this.tag + "'>");
		sb.append("<input id='tag' type='hidden' value='" + this.url + "'>");
		sb.append("<span>" + this.name + "</span>");
		sb.append("<ul style='display: none;'></ul></li>");
		
		return sb.toString();
	}
}
