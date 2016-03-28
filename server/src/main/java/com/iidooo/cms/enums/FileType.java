package com.iidooo.cms.enums;

public enum FileType {
    UserPhoto("UserPhoto", "1"),

    ContentPicture("ContentPicture", "2");

    private FileType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
