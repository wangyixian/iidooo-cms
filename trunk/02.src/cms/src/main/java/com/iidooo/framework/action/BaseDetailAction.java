package com.iidooo.framework.action;


public abstract class BaseDetailAction extends BaseAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public abstract String init();
    
    public  abstract  String create();

    public abstract String update();

    public abstract String delete();
}
