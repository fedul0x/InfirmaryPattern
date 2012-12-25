/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fedul0x.ip;

import ru.fedul0x.ip.dataaccess.dataobject.Agent;
import ru.fedul0x.ip.dataaccess.HibernateUtil;
import org.hibernate.classic.Session;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.dataobject.StaffPosition;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class InfirmaryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StaffPosition staffPositionChiefDoctor = new StaffPosition(100L, "Главный врач", "Главный врач");
        DataSourceHibernate<StaffPosition> sf = new DataSourceHibernate<StaffPosition>();
        sf.makePersistent(staffPositionChiefDoctor);
        sf.makeTransient(staffPositionChiefDoctor);
        
//
//        Session openSession = HibernateUtil.getSessionFactory().openSession();
//        openSession.beginTransaction();
//        for (StaffPosition staffPosition : StaffPosition.AllStaffPositions) {
//            openSession.saveOrUpdate(staffPosition);
//        }
//        openSession.getTransaction().commit();
    }
}
