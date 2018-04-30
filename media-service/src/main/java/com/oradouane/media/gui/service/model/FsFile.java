package com.oradouane.media.gui.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document
public class FsFile extends FsElement {

    private Long size;
    private String description;
    private String originalFileName;
    private Media.Extension extension;
    private String link;

    public FsFile() {
        setType(Type.FILE);
    }
}