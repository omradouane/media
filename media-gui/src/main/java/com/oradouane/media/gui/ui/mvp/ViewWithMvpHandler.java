package com.oradouane.media.gui.ui.mvp;

import com.vaadin.ui.VerticalLayout;

import java.util.logging.Logger;

public abstract class ViewWithMvpHandler<H extends MvpHandler> extends VerticalLayout implements HasMpvHandler<H> {

    private static final Logger logger = Logger.getLogger(ViewWithMvpHandler.class.getName());

    private H mvpHandler;

    protected H getMvpHandler() {
        if (mvpHandler == null) {
            logger.severe("mvpHandler are not set.  Did you forget to call setMvpHandler() from your view's constructor ?");
        }
        return mvpHandler;
    }

    @Override
    public void setMvpHandler(H mvpHandler) {
        this.mvpHandler = mvpHandler;
    }

}
