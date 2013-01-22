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
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.dataobject.Staff;
import ru.fedul0x.ip.view.PatienAddFrame;
import ru.fedul0x.ip.view.StaffPositionAddFrame;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class InfirmaryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfirmaryPattern.class.getName()).
                    log(java.util.logging.Level.WARNING, "Can't install look and feel class", ex);

        }

        DataSourceHibernate<Staff> dsh= new DataSourceHibernate<>(Staff.class);
        List<Staff> list = dsh.findAll();
        for (Staff item: list)
        {
            System.out.println(item.getLastName());
        }
        PatienAddFrame frame = new PatienAddFrame();
        frame.setVisible(true);
        StaffPositionAddFrame frame2 = new StaffPositionAddFrame();
        frame2.setVisible(true);
    }
}
