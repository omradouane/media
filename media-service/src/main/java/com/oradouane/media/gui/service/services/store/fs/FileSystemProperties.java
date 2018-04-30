package com.oradouane.media.gui.service.services.store.fs;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("media")
public class FileSystemProperties {
    /**
     * The root path for all files
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
