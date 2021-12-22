package com.pantwice.servlet;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ServeConfig serveConfig = new ServeConfig("127.0.0.1", 8080, 10);

        PathMapping pathMapping = new PathMapping();
        pathMapping.addMapping("/hello", "com.pantwice.servlet.HelloSelfServlet");

        SelfServer selfServer = new SelfServer();
        selfServer.init(serveConfig, pathMapping);
        selfServer.start();

    }

}
