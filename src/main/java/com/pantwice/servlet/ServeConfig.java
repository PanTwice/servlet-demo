package com.pantwice.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServeConfig {

    private String host;

    private Integer port;

    private Integer backlog;

    public String getHost() {
        return null == host || host.trim().length() == 0 ? "127.0.0.1" : host.trim();
    }

    public Integer getPort() {
        return null == port ? 8080 : this.port;
    }

    public Integer getBacklog() {
        return null == backlog ? Integer.MAX_VALUE : backlog;
    }
}
