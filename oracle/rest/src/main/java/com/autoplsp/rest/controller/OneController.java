package com.autoplsp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autoplsp.rest.domain.OneTO;
import com.autoplsp.rest.domain.CursorTO;
import com.autoplsp.rest.exception.BusinessException;
import com.autoplsp.rest.service.OneService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(value = "idFuncionario") String idFuncionario,
            @RequestParam(value = "idSolicitud") Number idSolicitud)
            throws BusinessException {
        return "ok";
    }

    @RequestMapping(value = "/cursor", method = RequestMethod.GET)
    @ResponseBody
    public java.util.List<CursorTO> getCursor() throws BusinessException {
        return oneService.getCursor();
    }
}
