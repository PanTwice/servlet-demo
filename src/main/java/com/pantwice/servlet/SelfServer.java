package com.pantwice.servlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SelfServer {

    private ServerSocket serverSocket;
    private PathMapping pathMapping;

    public void init(SelfServeConfig serveConfig, PathMapping pathMapping) throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(serveConfig.getHost(), serveConfig.getPort()),
                serveConfig.getBacklog());
        this.pathMapping = pathMapping;
    }

    public void start() throws IOException {
        while (true) {
            Socket client = serverSocket.accept();
            disptach(new SelfRequest(client.getInputStream()), new SelfResponse(client.getOutputStream()));
            client.close();
        }
    }

    public void disptach(SelfRequest request, SelfResponse response) {
        String className = pathMapping.fetchMapping(request.getUrl());
        if (className != null) {
            try {
                Class cls = Class.forName(className);
                SelfServlet selfServlet = (SelfServlet) cls.newInstance();
                selfServlet.service(request, response);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

}
