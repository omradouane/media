package com.oradouane.media.gui.service.services.store;

/**
 * Signals that an attempt to access the fsFile
 * has failed.
 */
public class FsFileNotFoundException extends Exception {

    public FsFileNotFoundException() {
        this("FsFile Not Found !");
    }

    public FsFileNotFoundException(String message) {
        super(message);
    }
}
