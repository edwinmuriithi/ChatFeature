package com.example.chatfeature;

public class ModelClass {

    public static final int SENDER_MESSAGE=1;
    public static final int RECEIVER_MESSAGE=2;
    public static final int SENDER_IMAGE=3;
    public static final int RECEIVER_IMAGE=4;

    private final int viewType;
    private String message;
    private int image;

    public ModelClass(int viewType, String message) {
        this.viewType = viewType;
        this.message = message;
    }

    public ModelClass(int viewType, int image) {
        this.viewType = viewType;
        this.image = image;
    }

    public int getViewType() {
        return viewType;
    }

    public String getMessage() {
        return message;
    }

    public int getImage() {
        return image;
    }
}
