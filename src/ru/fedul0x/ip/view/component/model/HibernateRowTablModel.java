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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import ru.fedul0x.ip.dataaccess.DataEntity;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.TitledColumn;

/**
 * Model for JTable with hibernate data source
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class HibernateRowTablModel<T extends DataEntity> extends RowTableModel<T> {

    private List<Method> methods = new ArrayList<>();

    public HibernateRowTablModel(Class rowClass) throws NoSuchMethodException {
        super(rowClass);
        List<String> columns = new ArrayList<>();
        DataSourceHibernate<T> dsh = new DataSourceHibernate<>(rowClass);
        ArrayList<T> data = (ArrayList<T>) dsh.findAll();

        for (Field field : getFields(rowClass)) {
            Method method = getMethod(field);
            TitledColumn col = field.getAnnotation(TitledColumn.class);
            if (col == null) {
                col = getMethod(field).getAnnotation(TitledColumn.class);
            }
            if (col != null) {
                methods.add(method);
//                columns.add(field.getName());
                columns.add(col.title());
            }
        }
        setDataAndColumnNames(data, columns);
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        String result = "";
        try {
            result = (String)methods.get(columnIndex).invoke(modelData.get(rowIndex));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private List<Map> createTable(List<T> queryResults) {
        List<Map> r = new LinkedList<>();
        for (T o : queryResults) {
            try {
                r.add(entityMap(o));
                System.out.println(entityMap(o));
            } catch (Throwable ex) {
                Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }

    private Map entityMap(T obj) throws Throwable {
        Map m = new HashMap();
        for (Field field : getFields(obj.getClass())) {
            Method method = getMethod(field);
            Object value = method.invoke(obj);
            m.put(field, value);
        }
        return m;
    }

    private List<Field> getFields(Class<?> clazz) {
        List<Field> fields = new LinkedList<>();
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("=====================");
            System.out.println(field);
            TitledColumn col = field.getAnnotation(TitledColumn.class);
//            col.
            if (col == null) {
                try {
                    col = getMethod(field).getAnnotation(TitledColumn.class);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(col);
            if (col != null) {
                fields.add(field);
            }
        }
        return fields;
    }

    private Method getMethod(Field field) throws NoSuchMethodException {
        Class<?> clazz = field.getDeclaringClass();
        String name = "get" + uppercase(field.getName());
        Method method = clazz.getMethod(name);
        return method;
    }

    private String uppercase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
