package com.iidooo.cms.enums;

public enum ContentType {
    Default("1"),

    News("2"),

    Blog("3");

    private ContentType(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
