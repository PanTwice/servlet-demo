package com.pantwice.servlet;

import java.io.IOException;

public class HelloSelfServlet implements SelfServlet {

    @Override
    public void doGet(SelfRequest request, SelfResponse response) {
        try {
            response.write("hello do-get");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(SelfRequest request, SelfResponse response) {
        try {
            response.write("hello do-post");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
