package com.oradouane.media.gui.ui.view;

import com.oradouane.media.gui.ui.mvp.MvpHandler;

public interface MediaHandler extends MvpHandler {

    void filter(String value);

    void fetchMedia();
}
