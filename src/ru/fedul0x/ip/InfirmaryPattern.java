/*
 * Copyright 2012 Ivashin Alexey <ivashin.alexei@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.fedul0x.ip;

import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ru.fedul0x.ip.dataaccess.dataobject.Agent;
import ru.fedul0x.ip.dataaccess.HibernateUtil;
import org.hibernate.classic.Session;
import org.slf4j.LoggerFactory;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.dataobject.Patient;
import ru.fedul0x.ip.dataaccess.dataobject.Staff;
import ru.fedul0x.ip.dataaccess.dataobject.StaffPosition;
import ru.fedul0x.ip.view.PatienAddFrame;
import ru.fedul0x.ip.view.StaffPositionAddFrame;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class InfirmaryPattern {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(StaffPositionAddFrame.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        StaffPosition staffPositionChiefDoctor = new StaffPosition(100L, "Главный врач", "Главный врач");
//        DataSourceHibernate<StaffPosition> sf = new DataSourceHibernate<StaffPosition>();
//        sf.makePersistent(staffPositionChiefDoctor);
//        sf.makeTransient(staffPositionChiefDoctor);

//        DataSourceHibernate<Staff> dsh = new DataSourceHibernate<Staff>();
//        List<Staff> list = dsh.findAll();
//        System.out.println("---------------------------------");
//        for(Staff staff: list) {
//            System.out.println(staff.getLastName());
//        }
//        System.out.println(list.size());

//        DataSourceHibernate<Patient> dsh1 = new DataSourceHibernate<>();
//        List<Patient> list1 = dsh1.findAll();
//        System.out.println("---------------------------------");
//        for(Patient patient: list1) {
//            System.out.println(patient.getLastName());
//        }
//        System.out.println(list1.size());

        String lookAndFeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.error("Can't install {} look and feel class", lookAndFeel);
        }

        PatienAddFrame frame = new PatienAddFrame();
        frame.setVisible(true);
        StaffPositionAddFrame frame2 = new StaffPositionAddFrame();
        frame2.setVisible(true);
    }
}
