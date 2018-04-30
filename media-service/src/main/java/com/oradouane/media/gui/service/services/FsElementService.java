package com.oradouane.media.gui.service.services;

import com.oradouane.media.gui.service.model.FsElement;
import com.oradouane.media.gui.service.repos.FsElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FsElementService {

    private final FsElementRepository fsElementRepository;

    @Autowired
    public FsElementService(FsElementRepository fsElementRepository) {
        this.fsElementRepository = fsElementRepository;
    }

    public List<FsElement> findAll() {
        return fsElementRepository.findAll();
    }

}
