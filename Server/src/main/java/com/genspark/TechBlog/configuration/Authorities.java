package com.genspark.TechBlog.configuration;

public enum Authorities {
    WRITE_ARTICLE("WRITE_ARTICLE"),
    DELETE_ARTICLE("DELETE_ARTICLE"),
    DELETE_COMMENT("DELETE_COMMENT"),
    WRITE_USER("WRITE_USER"),
    DELETE_USER("DELETE_USER");

    private final String authority;
    Authorities(final String text) {
        this.authority = text;
    }

    @Override
    public String toString() {
        return this.authority;
    }
}
