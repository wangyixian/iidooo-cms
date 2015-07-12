/**
 * <p>Title: SecurityResourceDto.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: www.izhangheng.com</p>
 * @author Ethan
 * @date 2015年3月26日
 * @version 1.0
 */
package com.iidooo.passport.dto.extend;

import java.util.ArrayList;
import java.util.List;

import com.iidooo.passport.dto.generate.Resource;

/**
 * @author Ethan
 * 
 */
public class ResourceDto extends Resource {

    // The children resource of this SecurityResourceDto
    private List<ResourceDto> children;

    private List<ResourceDto> offspring;
    
    private boolean isSelected;

    public List<ResourceDto> getChildren() {
        if (children == null) {
            children = new ArrayList<ResourceDto>();
        }
        return children;
    }

    public void setChildren(List<ResourceDto> children) {
        this.children = children;
    }

    public List<ResourceDto> getOffspring() {
        if (offspring == null) {
            offspring = new ArrayList<ResourceDto>();
        }
        return offspring;
    }

    public void setOffspring(List<ResourceDto> offspring) {
        this.offspring = offspring;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
