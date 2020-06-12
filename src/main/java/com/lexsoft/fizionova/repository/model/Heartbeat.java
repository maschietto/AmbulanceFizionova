package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Heartbeat {

 private Integer id;
    private String heartbeatCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeartbeatCheck() {
        return heartbeatCheck;
    }

    public void setHeartbeatCheck(String heartbeatCheck) {
        this.heartbeatCheck = heartbeatCheck;
    }
}
