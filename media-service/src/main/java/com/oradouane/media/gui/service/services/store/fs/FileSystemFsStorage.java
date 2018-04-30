package com.oradouane.media.gui.service.services.store.fs;

import com.oradouane.media.gui.service.services.store.FsFileNotFoundException;
import com.oradouane.media.gui.service.services.store.FsStorage;
import com.oradouane.media.gui.service.services.store.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@ConditionalOnBean(FileSystemAutoConfiguration.class)
@Service("fileSystemFsStorage")
public class FileSystemFsStorage implements FsStorage {

    private final FileSystemAutoConfiguration fileSystemAutoConfiguration;
    private final String rootPath;
    private final File rootDir;

    @Autowired
    public FileSystemFsStorage(FileSystemAutoConfiguration fileSystemAutoConfiguration) {
        this.fileSystemAutoConfiguration = fileSystemAutoConfiguration;
        this.rootPath = this.fileSystemAutoConfiguration.getRootPath();
        rootDir = new File(rootPath);

        validateRootDir();
    }

    @Override
    public String save(byte[] bytes, String name) throws StorageException {
        String path;
        final File file = new File(rootPath, name);
        if (file.exists()) {
            throw new StorageException("File already exists !");
        }
        try {
            final Path p = Files.write(file.toPath(), bytes);
            path = p.toFile().getPath();
        } catch (IOException e) {
            e.printStackTrace();
            throw new StorageException(e.getMessage());
        }
        return path;
    }

    @Override
    public byte[] load(String fileName) throws FsFileNotFoundException {
        byte[] result;
        final File file = new File(rootPath, fileName);
        checkFileExists(file);
        try {
            result = Files.readAllBytes(Paths.get(file.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FsFileNotFoundException(e.getMessage());
        }
        return result;
    }

    @Override
    public long length(String fileName) throws FsFileNotFoundException {
        final File file = new File(rootPath, fileName);
        checkFileExists(file);
        return file.length();
    }

    @Override
    public boolean exists(String fileName) {
        return new File(rootPath, fileName).exists();
    }

    @Override
    public boolean delete(String fileName) throws StorageException {
        if (!exists(fileName)) {
            return true;
        }
        final File file = new File(rootPath, fileName);
        return file.delete();
    }


    @Override
    public boolean makeDir(String dirName) {
        validateRootDir();
        final File file = new File(rootPath, dirName);
        if (!file.exists()) {
            return file.mkdir();
        } else {
            return true;
        }
    }

    private void validateRootDir() {
        if (!rootDir.exists()) {
            log.debug("Root directory not exist. Create it");
            if (!rootDir.mkdirs()) {
                throw new StorageException(String.format("Root directory '%s' not created ", rootDir));
            }
        }
    }

    private void checkFileExists(File file) throws FsFileNotFoundException {
        if (!file.exists()) {
            throw new FsFileNotFoundException(String.format("File '%s' not found ", file.getPath()));
        }
    }
}
