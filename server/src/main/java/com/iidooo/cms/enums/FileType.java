package com.iidooo.cms.enums;

public enum FileType {
    UserPhoto("1"),

    NewsPicture("2"),
    
    ContentPicture("3");

    private FileType(String code) {
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
