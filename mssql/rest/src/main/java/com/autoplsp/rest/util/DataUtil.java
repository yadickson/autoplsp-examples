/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoplsp.rest.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;

/**
 *
 * @author Yadickson Soto
 */
public class DataUtil {

    /**
     * Usar refleccion para pasar valores de un objeto a otro.
     *
     * @param objOrig objeto origen
     * @param objDest objeto destino
     */

    public Object parseObject(final Object objOrig,
            final Object objDest) {
        Object obj = objDest;

        if (objDest == null) {
            return null;
        }

        try {
            BeanUtils.copyProperties(objDest, objOrig);
        } catch (IllegalAccessException ex) {
            obj = null;
        } catch (InvocationTargetException ex) {
            obj = null;
        } catch (ConversionException ex) {
            obj = null;
        }

        return obj;
    }

}
