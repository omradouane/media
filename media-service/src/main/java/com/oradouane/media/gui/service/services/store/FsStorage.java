package com.oradouane.media.gui.service.services.store;

public interface FsStorage {

    /**
     * Save the given file into the store
     *
     * @param bytes the bytes to save.
     * @param name  the file name.
     * @return the path.
     */
    String save(byte[] bytes, String name) throws StorageException;

    /**
     * Load the data bytes using the given file name.
     *
     * @param fileName the file name.
     * @return the data bytes
     * @throws FsFileNotFoundException if file not found
     */
    byte[] load(String fileName) throws FsFileNotFoundException;

    /**
     * Returns the length of the file denoted by the given file name.
     *
     * @param fileName the file name
     * @return the file length
     * @throws FsFileNotFoundException if file not found
     */
    long length(String fileName) throws FsFileNotFoundException;

    /**
     * Tests whether the file denoted by the given file name
     * exists.
     *
     * @return <code>true</code> if and only if the file denoted
     * by the given file name exists; <code>false</code> otherwise
     */
    boolean exists(String fileName);

    /**
     * Delete the file denoted by the given file name.
     *
     * @return <code>true</code> if and only if the file is deleted, <code>false</code> otherwise
     */
    boolean delete(String fileName) throws StorageException;

    /**
     * Creates the directory named by the given directory name.
     *
     * @return  <code>true</code> if and only if the directory was
     *          created; <code>false</code> otherwise
     *
     */
    boolean makeDir(String dirName);

    /**
     * Tests whether the file denoted by the given file name is a
     * directory.
     *
     */
    //boolean isDirectory(String fileName);

}
