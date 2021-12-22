package com.pantwice.servlet;

import java.io.IOException;
import java.io.InputStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelfRequest {
    private String url;
    private SelfHttpMethod method;

    public SelfRequest(InputStream is) throws IOException {
        byte[] content = new byte[64];
        int readLen = is.read(content);
        if (readLen > 0) {
            String s = new String(content, 0, readLen);
            String[] ss = s.split("\\s");
            url = ss[1];
            switch (ss[0]) {
                case "get":
                case "GET": {
                    method = SelfHttpMethod.GET;
                    break;
                }
                case "post":
                case "POST": {
                    method = SelfHttpMethod.POST;
                    break;
                }
                default: {
                    method = SelfHttpMethod.OTHER;
                }
            }
            System.out.println(this);
        }
    }

}
