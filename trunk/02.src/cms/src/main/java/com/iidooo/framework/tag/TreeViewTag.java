package com.iidooo.framework.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.iidooo.framework.tag.component.TreeNode;
import com.iidooo.framework.utility.StringUtil;

public class TreeViewTag extends SimpleTagSupport {

    private static final Logger logger = Logger.getLogger(TreeViewTag.class);

    private final String FILE_TREE_NODE = "<span class='file'><a href={0}>{1}</a></span>";

    private final String FOLD_TREE_NODE = "<span class='folder'><a href={0}>{1}</a></span>";

    private TreeNode root;

    private boolean recursion = true;

    private String title;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public boolean isRecursion() {
        return recursion;
    }

    public void setRecursion(boolean recursion) {
        this.recursion = recursion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspCtx = null;
        JspWriter out = null;
        try {
            jspCtx = getJspContext();
            out = jspCtx.getOut();

            out.println("<div class='tree_wrap'>");
            if (!StringUtil.isEmpty(this.title)) {
                out.println("<div class='title'>");
                out.println(this.title);
                out.println("</div>");
            }
            out.println("<ul class='filetree' id='tree'>");
            String folder = StringUtil.replace(FOLD_TREE_NODE, root.getUrl(), root.getName());
            out.println("<li>" + folder);

            List<TreeNode> children = root.getChildren();
            if (children.size() > 0) {
                out.println("<ul>");
                for (TreeNode treeNode : children) {
                    printHTML(out, treeNode);
                }
                out.println("</ul>");
            } else {
                logger.warn("The root tree node has not any child.");
            }
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private void printHTML(JspWriter out, TreeNode treeNode) throws JspException, IOException {
        try {

            // If has children, the node class should be set
            if (treeNode.getChildren().size() > 0) {
                String folder = StringUtil.replace(FOLD_TREE_NODE, treeNode.getUrl(), treeNode.getName());
                out.println("<li class='closed'>" + folder);

                // If the flag of recursion is true, should show the sub children tree node.
                if (recursion) {
                    List<TreeNode> children = treeNode.getChildren();
                    out.println("<ul>");
                    for (TreeNode child : children) {
                        this.printHTML(out, child);
                    }
                    out.println("</ul>");
                }
                out.println(" </li>");
            } else {
                String file = StringUtil.replace(FILE_TREE_NODE, treeNode.getUrl(), treeNode.getName());
                out.println("<li>" + file + "</li>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

}
