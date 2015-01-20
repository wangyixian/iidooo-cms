package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class DictType extends BaseDto{
    private Integer dictTypeID;

    private String dictTypeCode;

    private String dictTypeName;

    private Integer sequence;

    public Integer getDictTypeID() {
        return dictTypeID;
    }

    public void setDictTypeID(Integer dictTypeID) {
        this.dictTypeID = dictTypeID;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}