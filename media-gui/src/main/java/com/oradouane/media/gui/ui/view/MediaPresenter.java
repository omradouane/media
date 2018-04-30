package com.oradouane.media.gui.ui.view;

import com.oradouane.media.gui.model.FsElementVo;
import com.oradouane.media.gui.service.ElementService;
import com.oradouane.media.gui.ui.mvp.HasMpvHandler;
import com.oradouane.media.gui.ui.mvp.MvpPresenter;
import com.oradouane.media.gui.ui.mvp.MvpView;
import com.vaadin.spring.annotation.SpringView;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Consumer;

@SpringView(name = "media")
public class MediaPresenter extends MvpPresenter<MediaPresenter.MediaView> implements MediaHandler {

    private FsElementVo[] fsElementVos;
    private ElementService elementService;

    public MediaPresenter(MediaView mediaView, ElementService elementService) {
        super(mediaView);
        this.elementService = elementService;
        this.fsElementVos = new FsElementVo[0];
        getView().setMvpHandler(this);
        fetchMedia();
    }

    @Override
    public void filter(String value) {
        if (value != null && !value.isEmpty()) {
            final FsElementVo[] newArray = Arrays.stream(this.fsElementVos)
                    .filter(e -> e.getName().toLowerCase().contains(value.toLowerCase()))
                    .toArray(FsElementVo[]::new);
            getView().updateView(newArray);
        } else {
            getView().updateView(this.fsElementVos);
        }
    }

    @Override
    public void fetchMedia() {
        final Consumer<FsElementVo> cns = ele -> {
            Runnable r = () -> {
                FsElementVo[] arr = {ele};
                getView().updateView(arr);
            };
            getViewComponent().getUI().access(r);
        };
        final Flux<FsElementVo> elementVoFlux = elementService.finAll();
        elementVoFlux.subscribe(cns);
        //this.fsElementVos = this.mediaService.findByUserId("5ae2d9db81d43e31503c6aaa");
        //getView().updateView(this.fsElementVos);
    }

    public interface MediaView extends HasMpvHandler<MediaHandler>, MvpView {
        void updateView(FsElementVo[] fsElementVos);
    }

}
