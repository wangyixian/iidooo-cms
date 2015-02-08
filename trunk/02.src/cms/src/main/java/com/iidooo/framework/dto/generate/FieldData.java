package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class FieldData extends BaseDto{
    private Integer dataID;

    private Integer fieldID;

    private Integer tableDataID;

    private String fieldValue;

    public Integer getDataID() {
        return dataID;
    }

    public void setDataID(Integer dataID) {
        this.dataID = dataID;
    }

    public Integer getFieldID() {
        return fieldID;
    }

    public void setFieldID(Integer fieldID) {
        this.fieldID = fieldID;
    }

    public Integer getTableDataID() {
        return tableDataID;
    }

    public void setTableDataID(Integer tableDataID) {
        this.tableDataID = tableDataID;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue == null ? null : fieldValue.trim();
    }
}