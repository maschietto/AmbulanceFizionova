package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.HeartbeatRepository;
import com.lexsoft.fizionova.repository.model.Heartbeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Maschietto on 2/16/17.
 */
@Service
public class HeartbeatService {

    @Autowired
    HeartbeatRepository heartbeatRepository;

    public ResponseEntity checkHeartbeat() throws BussinesException {
        Heartbeat heartbeat = heartbeatRepository.getHeartbeat();
           if(heartbeat != null){
               return ResponseEntity.ok(heartbeat);
           } else {

               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Connection to database is not established!");
           }

    }

}
