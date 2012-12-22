/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import ip.dataaccess.Agent;
import ip.dataaccess.HibernateUtil;
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
        StaffPosition sp = new StaffPosition(4);
        StaffPosition sp1 = new StaffPosition(5);
        StaffPosition sp2 = new StaffPosition(6);
        
        Session openSession = HibernateUtil.getSessionFactory().openSession();
        openSession.beginTransaction();
        openSession.save(sp);
        openSession.save(sp1);
        openSession.save(sp2);
        openSession.getTransaction().commit();
    }
}
