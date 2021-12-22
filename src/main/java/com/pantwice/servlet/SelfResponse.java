package com.pantwice.servlet;

import java.io.IOException;
import java.io.OutputStream;

public class SelfResponse {

    private OutputStream os;

    public SelfResponse(OutputStream os) {
        this.os = os;
    }

    public void write(String content) throws IOException {
        StringBuilder sbd = new StringBuilder(128);
        String tailPad = "\r\n";
        sbd.append("HTTP/1.1 200 ")
                .append(tailPad)
                .append("Content-Type:text/html").append(tailPad)
                .append(tailPad)
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        os.write(sbd.toString().getBytes());
    }

    public void close() throws IOException {
        os.close();
    }

}
