package com.iidooo.framework.dto.generate;

import com.iidooo.framework.dto.base.BaseDto;

public class DictClass extends BaseDto{
    private Integer dictClassID;

    private String dictTypeCode;

    private String dictClassCode;

    private String dictClassName;

    private Integer sequence;

    public Integer getDictClassID() {
        return dictClassID;
    }

    public void setDictClassID(Integer dictClassID) {
        this.dictClassID = dictClassID;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    public String getDictClassCode() {
        return dictClassCode;
    }

    public void setDictClassCode(String dictClassCode) {
        this.dictClassCode = dictClassCode == null ? null : dictClassCode.trim();
    }

    public String getDictClassName() {
        return dictClassName;
    }

    public void setDictClassName(String dictClassName) {
        this.dictClassName = dictClassName == null ? null : dictClassName.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}