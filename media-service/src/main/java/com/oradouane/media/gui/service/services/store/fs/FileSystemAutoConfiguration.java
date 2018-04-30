package com.oradouane.media.gui.service.services.store.fs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "media", name = "path")
@EnableConfigurationProperties(FileSystemProperties.class)
public class FileSystemAutoConfiguration {

    private final FileSystemProperties fileSystemProperties;

    @Autowired
    public FileSystemAutoConfiguration(FileSystemProperties fileSystemProperties) {
        this.fileSystemProperties = fileSystemProperties;
    }

    /**
     * Gets the root path.
     *
     * @return the root path.
     */
    public String getRootPath() {
        return fileSystemProperties.getPath();
    }

}
