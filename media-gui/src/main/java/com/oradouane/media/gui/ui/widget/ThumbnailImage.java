package com.oradouane.media.gui.ui.widget;

import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

public class ThumbnailImage extends VerticalLayout {

    private Image image;

    public ThumbnailImage(String imageName) {
        setSizeUndefined();
        createImage(imageName);
        addComponent(image);
        addComponent(getCheckBox());
        align();
    }

    public ThumbnailImage(String imageName, Resource icon) {
        this(imageName);
        setImageSource(icon);
    }


    private void createImage(String caption) {
        image = new Image(caption);
        image.setSizeUndefined();
    }

    public void setImageSource(Resource icon) {
        image.setSource(icon);
    }

    private CheckBox getCheckBox() {
        final CheckBox checkBox = new CheckBox();
        checkBox.setValue(false);
        return checkBox;
    }

    private void align() {
        for (int i = 0; i < getComponentCount(); i++) {
            setComponentAlignment(getComponent(i), Alignment.TOP_CENTER);
        }
    }
}
