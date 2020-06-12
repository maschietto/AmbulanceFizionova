package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.service.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/heartbeat")
public class HeartbeatController {

    @Autowired
    HeartbeatService heartbeatService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getHeartbeat() throws BussinesException, ParseException {
        return heartbeatService.checkHeartbeat();
    }

    @ExceptionHandler({BussinesException.class, ParseException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
