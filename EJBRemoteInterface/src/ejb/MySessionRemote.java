/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author chinaglia
 */
@Remote
public interface MySessionRemote {

    String getResult();

    double getSoma(double param1, double param2);

    double getProduto(double param1, double param2);

}
