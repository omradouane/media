package com.oradouane.media.gui.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

@UIScope
@SpringViewDisplay
public class MainView extends HorizontalLayout implements ViewDisplay {

    private VerticalLayout content;

    public MainView() {
        setSizeFull();

        final HorizontalLayout header = new HorizontalLayout();
        header.setMargin(false);
        header.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
        header.addComponent(buildHeader());

        content = new VerticalLayout();
        content.setMargin(false);
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponents(header);
        mainLayout.addComponents(content);
        mainLayout.setMargin(false);
        mainLayout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        addComponent(mainLayout);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
    }



    private Component buildHeader() {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        MenuBar.MenuItem settingsItem = settings.addItem("", new ThemeResource("profile.jpg"), null);
        settingsItem.setText("Radouane ");
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", this::signOut);
        return settings;
    }

    private void signOut(MenuBar.MenuItem menuItem) {
        Notification.show("Logout ");
    }

    @Override
    public void showView(View view) {
        content.removeAllComponents();
        content.addComponent(view.getViewComponent());
    }
}
