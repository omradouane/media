package com.oradouane.media.gui.service.services.store;

/**
 * Signals that a failure is occurred while manipulating file into the data store.
 */
public class StorageException extends RuntimeException {

    public StorageException() {
        super();
    }

    public StorageException(String message) {
        super(message);
    }
}
