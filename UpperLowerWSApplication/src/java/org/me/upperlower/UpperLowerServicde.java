/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package org.me.upperlower;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author chinaglia
 */
@WebService(serviceName = "UpperLowerServicde")
@Stateless()
public class UpperLowerServicde {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "paraUpper")
    public String paraUpper(@WebParam(name = "texto") String texto) {
        return texto.toUpperCase();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "paraLower")
    public String paraLower(@WebParam(name = "texto") String texto) {
        return texto.toLowerCase();
    }

}
