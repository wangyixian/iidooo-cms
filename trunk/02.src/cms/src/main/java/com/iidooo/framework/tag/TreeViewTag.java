package com.iidooo.framework.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

public class TreeViewTag extends SimpleTagSupport {
	
	private static final Logger logger = Logger.getLogger(TreeViewTag.class);

	private ArrayList<TreeNode> rootTreeNodes;
	private boolean recursion = true;

	public ArrayList<TreeNode> getRootTreeNodes() {
		return rootTreeNodes;
	}

	public void setRootTreeNodes(ArrayList<TreeNode> rootTreeNodes) {
		this.rootTreeNodes = rootTreeNodes;
	}

	public boolean isRecursion() {
		return recursion;
	}

	public void setRecursion(boolean recursion) {
		this.recursion = recursion;
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			JspContext jspCtx = getJspContext();
			JspWriter out = jspCtx.getOut();

			out.println("<ul class='treeview' id='tree'>");

			for (TreeNode treeNode : rootTreeNodes) {
				if (treeNode == null) {
					continue;
				}
				printHTML(out, treeNode);
			}

			out.println("</ul>");			
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage());
		}
	}

	private void appendTreeNode(JspWriter out, ArrayList<TreeNode> children)
			throws JspException, IOException {

		if (children.size() <= 0) {
			return;
		}

		out.println("<ul style='display: none;'>");
		for (TreeNode treeNode : children) {
			printHTML(out, treeNode);
		}

		out.println("</ul>");
	}

	private void printHTML(JspWriter out, TreeNode treeNode)
			throws JspException, IOException {

		//If has image, the image will display in the node
		if (treeNode.getIcon() != null && treeNode.getIcon() != "") {
			out.println("<img src='" + treeNode.getIcon() + "'/>");
		}

		//If has children, the node class should be set
		if (recursion) {
			if (treeNode.getChildren() != null && treeNode.getChildren().size() > 0) {
				out.println("<li class='tree-node expandable'>");
				out.println("<div class='hitarea expandable-hitarea'></div>");
			}
			else {
				out.println("<li class='tree-node'>");
			}
		}
		else {
			out.println("<li class='tree-node expandable'>");
			out.println("<div class='hitarea expandable-hitarea'></div>");
		}

		out.println("<input id='code' type='hidden' value='" + treeNode.getCode() + "'>");
		out.println("<input id='tag' type='hidden' value='" + treeNode.getTag() + "'>");
		out.println("<input id='name' type='hidden' value='" + treeNode.getName() + "'>");
		out.println("<input id='url' type='hidden' value='" + treeNode.getUrl() + "'>");
		out.println("<span class='tree-nod'>");
		//if (treeNode.getUrl() != null && treeNode.getUrl() != "") {
			//out.println("<a href='" + treeNode.getUrl() + "' >");
		//}
		out.println(treeNode.getName());

		//if (treeNode.getUrl() != null && treeNode.getUrl() != "") {
			//out.println("</a>");
		//}
		out.println("</span>");
		if (recursion) {
			appendTreeNode(out, treeNode.getChildren());
		}
		else {
			out.println("<ul style='display: none;'>");

			out.println("</ul>");
		}
		out.println("</li>");
	}

}
