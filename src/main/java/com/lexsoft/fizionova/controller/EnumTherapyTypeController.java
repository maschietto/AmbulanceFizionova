package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import com.lexsoft.fizionova.service.EnumTherapyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/enums")
public class EnumTherapyTypeController {

    @Autowired
    EnumTherapyTypeService enumTherapyTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getEnumTherapyTypeByParam(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "id", required = false) Integer id) throws BussinesException {
        return enumTherapyTypeService.findTherapyByParam(id, name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveEnumTherapyType(@RequestBody EnumTherapyType enumTherapyType) throws BussinesException {
        return enumTherapyTypeService.insertEnumtherapyType(enumTherapyType);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateEnumTherapyType(@RequestBody EnumTherapyType enumTherapyType) throws BussinesException {
        return enumTherapyTypeService.updateTherapyType(enumTherapyType);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public ResponseEntity deleteEnumTherapyType(@PathVariable(value = "id") Integer id) throws BussinesException {
        return enumTherapyTypeService.deleteEnumTherapyType(id);
    }

    @ExceptionHandler({BussinesException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
