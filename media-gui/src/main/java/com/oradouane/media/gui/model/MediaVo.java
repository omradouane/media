package com.oradouane.media.gui.model;

public enum MediaVo {

    VIDEO("VIDEO"), IMAGE("IMAGE");

    private String label;

    MediaVo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public enum Extension {
        JPEG(MediaVo.IMAGE, ".jpeg"), JPG(MediaVo.IMAGE, ".jpg"), AVI(MediaVo.VIDEO, ".avi"), MPEG(MediaVo.VIDEO, ".mpeg");

        private final MediaVo type;
        private final String extension;

        Extension(MediaVo type, String extension) {
            this.type = type;
            this.extension = extension;
        }

        public MediaVo getType() {
            return type;
        }

        public String getExtension() {
            return extension;
        }
    }

}