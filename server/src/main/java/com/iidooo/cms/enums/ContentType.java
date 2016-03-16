package com.iidooo.cms.enums;

public enum ContentType {
    Default("Default", "1"),

    News("News", "2"),

    Blog("Blog", "3");

    private ContentType(String name, String value) {
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
