/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fedul0x.ip;

import ru.fedul0x.ip.dataaccess.dataobject.Agent;
import ru.fedul0x.ip.dataaccess.HibernateUtil;
import ip.dataaccess.StaffPosition;
import org.hibernate.classic.Session;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class InfirmaryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Agent agent = new Agent(0, "Last", "Get", "Get", "Get", null)
//        agent.setId(0);
        StaffPosition sp = new StaffPosition(7L);

        Session openSession = HibernateUtil.getSessionFactory().openSession();
        openSession.beginTransaction();
        for (StaffPosition staffPosition : StaffPosition.AllStaffPositions) {
            openSession.saveOrUpdate(staffPosition);
        }
        openSession.getTransaction().commit();
    }
}
