package com.oradouane.media.gui.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class FsElement {

    private String id;
    private String name;
    private Type type;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime updated;
    private String fsDirectoryId;
    private String userId;

    public enum Type {
        DIR, FILE;
    }
}
