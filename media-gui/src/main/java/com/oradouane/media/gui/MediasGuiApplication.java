package com.oradouane.media.gui;

import com.oradouane.media.gui.ui.NavigationManager;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringNavigator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


@SpringBootApplication
public class MediasGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediasGuiApplication.class, args);
    }

    @Bean
    @Primary
    public VaadinServlet vaadinServlet() {
        return new CustomVaadinServlet();
    }


    @Bean
    @Primary
    @UIScope
    public SpringNavigator vaadinNavigator() {
        return new NavigationManager();
    }
}
