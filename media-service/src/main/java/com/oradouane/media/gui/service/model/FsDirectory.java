package com.oradouane.media.gui.service.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FsDirectory extends FsElement {

    public FsDirectory() {
        setType(Type.DIR);
    }
}
