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

import com.iidooo.passport.dto.generate.SecurityResource;

/**
 * @author Ethan
 * 
 */
public class SecurityResourceDto extends SecurityResource {

    // The children resource of this SecurityResourceDto
    private List<SecurityResourceDto> children;

    private List<SecurityResourceDto> offspring;
    
    private boolean isSelected;

    public List<SecurityResourceDto> getChildren() {
        if (children == null) {
            children = new ArrayList<SecurityResourceDto>();
        }
        return children;
    }

    public void setChildren(List<SecurityResourceDto> children) {
        this.children = children;
    }

    public List<SecurityResourceDto> getOffspring() {
        if (offspring == null) {
            offspring = new ArrayList<SecurityResourceDto>();
        }
        return offspring;
    }

    public void setOffspring(List<SecurityResourceDto> offspring) {
        this.offspring = offspring;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
