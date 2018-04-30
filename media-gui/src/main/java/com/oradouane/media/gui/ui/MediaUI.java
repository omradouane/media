package com.oradouane.media.gui.ui;

import com.oradouane.media.gui.ui.view.MainView;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("media")
@SpringUI(path = "/media")
@Title("Medias management")
@Push
public class MediaUI extends UI {

    private final MainView mainView;

    @Autowired
    public MediaUI(MainView mainView) {
        this.mainView = mainView;
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setContent(mainView);
    }
}
