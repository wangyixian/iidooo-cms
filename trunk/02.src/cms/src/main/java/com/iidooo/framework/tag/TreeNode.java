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
		if (this.parent != null) {
            this.parent.getChildren().add(this);
        }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TreeNode> getChildren() {
	    if (children == null) {
            children = new ArrayList<TreeNode>();
        }
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
	
}
