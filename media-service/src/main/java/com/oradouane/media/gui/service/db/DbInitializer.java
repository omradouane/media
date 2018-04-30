package com.oradouane.media.gui.service.db;

import com.oradouane.media.gui.service.model.FsDirectory;
import com.oradouane.media.gui.service.model.FsElement;
import com.oradouane.media.gui.service.model.FsFile;
import com.oradouane.media.gui.service.model.Media;
import com.oradouane.media.gui.service.repos.FsElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@Component
public class DbInitializer {


    private final FsElementRepository fsElementRepository;
    private final String USER_ID = "5ae2d9db81d43e31503c6aaa";

    @Autowired
    public DbInitializer(FsElementRepository fsElementRepository) {
        this.fsElementRepository = fsElementRepository;
    }


    @PostConstruct
    public void init(){
        fsElementRepository.deleteAll();
        // save a file
        File logo = null;
        try {
            logo = ResourceUtils.getFile("classpath:" + "logo.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FsFile fsFile = new FsFile();
        fsFile.setName("File 1");
        fsFile.setOriginalFileName(logo.getName());
        fsFile.setDescription("The logo image");
        fsFile.setSize(logo.length());
        fsFile.setExtension(Media.Extension.JPG);
        fsFile.setCreated(LocalDateTime.now());
        fsFile.setUserId(USER_ID);
        fsElementRepository.save((FsElement)fsFile);
        // save a directory
        final FsDirectory directory = new FsDirectory();
        directory.setName("Direc");
        directory.setCreated(LocalDateTime.now());
        directory.setUserId(USER_ID);
        fsElementRepository.save(directory);
        // FsFile2
        fsFile = new FsFile();
        fsFile.setName("Video 1");
        fsFile.setOriginalFileName(logo.getName());
        fsFile.setDescription("The logo image");
        fsFile.setSize(logo.length());
        fsFile.setExtension(Media.Extension.AVI);
        fsFile.setCreated(LocalDateTime.now());
        fsFile.setUserId(USER_ID);
        fsElementRepository.save(fsFile);
    }
}
