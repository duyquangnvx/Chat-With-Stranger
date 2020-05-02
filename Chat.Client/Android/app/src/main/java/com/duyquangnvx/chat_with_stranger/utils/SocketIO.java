package com.duyquangnvx.chat_with_stranger.utils;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketIO {
    private static final String URI = "http://192.168.43.72:3000/";
    private static SocketIO instance;

    private static com.github.nkzawa.socketio.client.Socket socket;

    private SocketIO() {
        try {
            socket = IO.socket(URI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static SocketIO getInstance() {
        if (instance == null) {
            instance = new SocketIO();
        }

        return instance;
    }

    public Socket getSocket() {
        return socket;
    }
}
