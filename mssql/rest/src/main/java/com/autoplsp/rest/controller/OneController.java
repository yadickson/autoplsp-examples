package com.autoplsp.rest.controller;

import com.autoplsp.rest.domain.NumericTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autoplsp.rest.domain.OneTO;
import com.autoplsp.rest.domain.TablaTO;
import com.autoplsp.rest.exception.BusinessException;
import com.autoplsp.rest.service.OneService;

@RestController
@RequestMapping(value = "/one")
public final class OneController {

    @Autowired
    private OneService oneService;

    @RequestMapping(value = "/toDo/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String toDoText(@PathVariable(value = "text") String text) {
        return oneService.toDo(text);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public OneTO json() {
        OneTO to = new OneTO();
        to.setNumber(10);
        to.setText("text");
        return to;
    }

    @RequestMapping(value = "/crud/{id}/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String crud(@PathVariable(value = "id") Long id, @PathVariable(value = "text") String text) throws BusinessException {
        oneService.crud(id, text);
        return "ok";
    }

    @RequestMapping(value = "/object/{id}/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String object(@PathVariable(value = "id") Long id, @PathVariable(value = "text") String text) throws BusinessException {
        oneService.object(id, text);
        return "ok";
    }

    @RequestMapping(value = "/array/{id}/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String array(@PathVariable(value = "id") Long id, @PathVariable(value = "text") String text) throws BusinessException {
        oneService.array(id, text);
        return "ok";
    }

    @RequestMapping(value = "/metodoPost", method = RequestMethod.POST)
    @ResponseBody
    public String reasignaSolicitud(
            @RequestBody OneTO input,
            @RequestParam(name = "idFuncionario") String idFuncionario,
            @RequestParam(name = "idSolicitud") Number idSolicitud)
            throws BusinessException {
        return "ok";
    }

    @RequestMapping(value = "/string", method = RequestMethod.GET)
    @ResponseBody
    public String getString() throws BusinessException {
        return oneService.getString();
    }

    @RequestMapping(value = "/string/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String getString(@PathVariable(value = "text") String text) throws BusinessException {
        return oneService.getString(text);
    }

    @RequestMapping(value = "/resultSet", method = RequestMethod.GET)
    @ResponseBody
    public java.util.List<TablaTO> getCursor() throws BusinessException {
        return oneService.getResultSet();
    }

    @RequestMapping(value = "/resultTable", method = RequestMethod.GET)
    @ResponseBody
    public java.util.List<TablaTO> getResultTable() throws BusinessException {
        return oneService.getResultTable();
    }

    @RequestMapping(value = "/insertNumericTypes", method = RequestMethod.PUT)
    @ResponseBody
    public Long insertNumericTypes() throws BusinessException {
        return oneService.insertNumericTypes();
    }

    @RequestMapping(value = "/readNumericTypes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public NumericTO readNumericTypes(@PathVariable(value = "id") Long id) throws BusinessException {
        return oneService.readNumericTypes(id);
    }

    @RequestMapping(value = "/getNumericResultSet", method = RequestMethod.GET)
    @ResponseBody
    public java.util.List<NumericTO> getNumericResultSet() throws BusinessException {
        return oneService.getNumericResultSet();
    }

}
