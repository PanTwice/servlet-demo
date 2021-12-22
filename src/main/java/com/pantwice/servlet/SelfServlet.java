package com.pantwice.servlet;

public interface SelfServlet {

    public void doGet(SelfRequest request, SelfResponse response);

    public void doPost(SelfRequest request, SelfResponse response);

    default void service(SelfRequest request, SelfResponse response) {
        SelfHttpMethod method = request.getMethod();
        switch (method) {
            case GET:
                doGet(request, response);
                break;

            case POST:
                doPost(request, response);
                break;
            default:
                break;
        }
    }

}
