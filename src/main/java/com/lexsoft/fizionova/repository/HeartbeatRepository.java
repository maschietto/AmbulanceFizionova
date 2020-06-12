package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.HeartbeatMapper;
import com.lexsoft.fizionova.repository.model.Heartbeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public class HeartbeatRepository {

    @Autowired
    HeartbeatMapper heartbeatMapper;

    public Heartbeat getHeartbeat() {
        Heartbeat heartbeat = heartbeatMapper.checkHeartbeat(1);
        return heartbeat;
    }
}