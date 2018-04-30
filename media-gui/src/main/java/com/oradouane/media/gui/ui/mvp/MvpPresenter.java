package com.oradouane.media.gui.ui.mvp;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Component;

public abstract class MvpPresenter<V extends MvpView> implements View {

    private final V view;

    public MvpPresenter(V view) {
        final SpringComponent springComponent = view.getClass().getAnnotation(SpringComponent.class);
        if (springComponent == null) {
            throw new IllegalArgumentException("The View class should be annotated with @SpringComponent");
        }
        this.view = view;
    }

    protected V getView() {
        return view;
    }

    public Component getViewComponent() {
        return (Component) getView();
    }

}
