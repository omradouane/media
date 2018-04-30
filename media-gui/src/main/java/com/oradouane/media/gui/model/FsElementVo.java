package com.oradouane.media.gui.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class FsElementVo {

    private String id;
    private String name;
    private Type type;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String fsDirectoryId;
    private String userId;

    // FsFile
    private Long size;
    private String description;
    private String originalFileName;
    private MediaVo.Extension extension;
    private String link;

}
