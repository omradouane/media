package com.oradouane.media.gui.service.model;

public enum Media {

    VIDEO("VIDEO"), IMAGE("IMAGE");

    private String label;

    Media(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public enum Extension {
        JPEG(Media.IMAGE, ".jpeg"), JPG(Media.IMAGE, ".jpg"), AVI(Media.VIDEO, ".avi"), MPEG(Media.VIDEO, ".mpeg");

        private final Media  type;
        private final String extension;

        Extension(Media type, String extension) {
            this.type = type;
            this.extension = extension;
        }

        public Media getType() {
            return type;
        }

        public String getExtension() {
            return extension;
        }
    }

}