package com.oradouane.media.gui.ui.view;

import com.oradouane.media.gui.model.FsElementVo;
import com.oradouane.media.gui.model.MediaVo;
import com.oradouane.media.gui.ui.mvp.ViewWithMvpHandler;
import com.oradouane.media.gui.ui.widget.ThumbnailImage;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@UIScope
@SpringComponent
public class MediaViewImpl extends ViewWithMvpHandler<MediaHandler> implements MediaPresenter.MediaView {

    private CssLayout mediaContainer;
    private final ThemeResource folder = new ThemeResource("img/folder.png");
    private final ThemeResource image = new ThemeResource("img/image.png");
    private final ThemeResource video = new ThemeResource("img/video.png");

    public MediaViewImpl() {
        setSizeFull();
        setMargin(true);
        addStyleName("content-common");

        final Label h1 = new Label("Media Gallery");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        addComponent(getMediaPanel());

        for (int i = 0; i < getComponentCount(); i++) {
            setComponentAlignment(getComponent(i), Alignment.TOP_CENTER);
        }
    }

    private Panel getMediaPanel() {
        final Panel mediaPanel = new Panel("Manage medias");
        //mediaPanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        mediaPanel.addStyleName(ValoTheme.PANEL_SCROLL_INDICATOR);
        mediaPanel.setSizeUndefined();


        final VerticalLayout content = new VerticalLayout();
        content.setSpacing(true);
        content.setMargin(true);
        content.setSizeUndefined();

        final TextField searchInput = new TextField();
        searchInput.setPlaceholder("Search");
        searchInput.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        searchInput.setIcon(VaadinIcons.SEARCH);
        searchInput.setValueChangeMode(ValueChangeMode.LAZY);
        searchInput.addValueChangeListener(event -> getMvpHandler().filter(event.getValue()));
        content.addComponent(searchInput);

        mediaContainer = new CssLayout();
        mediaContainer.setSizeFull();

        content.addComponent(mediaContainer);

        mediaPanel.setContent(content);

        return mediaPanel;
    }

    private ThumbnailImage getThumbnailImage(FsElementVo fsElementVo) {
        final ThumbnailImage img = new ThumbnailImage(fsElementVo.getName());
        switch (fsElementVo.getType()) {
            case DIR:
                img.setImageSource(folder);
                break;
            case FILE:
                if (MediaVo.IMAGE.equals(fsElementVo.getExtension().getType())) {
                    img.setImageSource(image);
                } else {
                    img.setImageSource(video);
                }
                break;
        }
        return img;
    }


    @Override
    public void updateView(FsElementVo[] fsElementVos) {
        //mediaContainer.removeAllComponents();
        for (final FsElementVo fsElementVo : fsElementVos) {
            mediaContainer.addComponent(getThumbnailImage(fsElementVo));
        }
    }

}
