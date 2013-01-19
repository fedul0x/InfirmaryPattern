/*
 * Copyright 2013 Ivashin Alexey <ivashin.alexei@gmail.com>.
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
package ru.fedul0x.ip.view.component.model;

import java.util.List;
import ru.fedul0x.ip.dataaccess.DataEntity;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.dataobject.StaffPosition;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class HibernateRowTablModel<T extends DataEntity> extends RowTableModel<T> {

    public HibernateRowTablModel(List<T> modelData, List<String> columnNames, Class rowClass) {
        super(modelData, columnNames, rowClass);
//        DataSourceHibernate<StaffPosition> dsh = new DataSourceHibernate<>(StaffPosition.class);
//        List<StaffPosition> modelData1 = dsh.findAll();
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        String result = "";
        if (columnIndex == 0) {
            result = ((StaffPosition) modelData.get(rowIndex)).getId().toString();
        }
        if (columnIndex == 1) {
            result = ((StaffPosition) modelData.get(rowIndex)).getStaffPositionName();
        }
        if (columnIndex == 2) {
            result = ((StaffPosition) modelData.get(rowIndex)).getDescription();
        }
        return result;
    }
}
