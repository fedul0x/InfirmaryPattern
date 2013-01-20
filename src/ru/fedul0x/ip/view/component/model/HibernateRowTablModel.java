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
import ru.fedul0x.ip.dataaccess.DataEntity;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.TitledColumn;
import ru.fedul0x.ip.dataaccess.TitledId;

/**
 * Model for JTable with hibernate data source
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class HibernateRowTablModel<T extends DataEntity> extends RowTableModel<T> {

    private ArrayList<Method> methods = new ArrayList<>();

    public HibernateRowTablModel(Class rowClass) {
        super(rowClass);
        List<String> columns = new ArrayList<>();
        DataSourceHibernate<T> dsh = new DataSourceHibernate<>(rowClass);
        ArrayList<T> data = (ArrayList<T>) dsh.findAll();
        HashMap<Field, Method> titleAndMethods = (HashMap<Field, Method>) getFieldsAndMethods(rowClass);
        List<String> alts = new ArrayList<>();
        for (Field key : titleAndMethods.keySet()) {
            alts.clear();
            if (null != key.getAnnotation(TitledColumn.class)) {
                alts.add(key.getAnnotation(TitledColumn.class).table());
            }
            if (null != key.getAnnotation(TitledId.class)) {
                alts.add(key.getAnnotation(TitledId.class).title());
            }
            try {
                if (null != getMethod(key).getAnnotation(TitledColumn.class)) {
                    alts.add(getMethod(key).getAnnotation(TitledColumn.class).title());
                }
                if (null != getMethod(key).getAnnotation(TitledId.class)) {
                    alts.add(getMethod(key).getAnnotation(TitledId.class).title());
                }
            } catch (NoSuchMethodException ex) {
                continue;
            }
            String column = "";
            for (String item : alts) {
                if ((item != null) && (!item.isEmpty())) {
                    column = item;
                }
            }
            columns.add(column);
            try {
                methods.add(getMethod(key));
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setDataAndColumnNames(data, columns);
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        String result = "";
        try {
            result = (String) methods.get(columnIndex).invoke(modelData.get(rowIndex));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(HibernateRowTablModel.class.getName()).log(Level.WARNING, null, ex);
        }
        return result;
    }

    private Map<Field, Method> getFieldsAndMethods(Class<?> clazz) {
        Map<Field, Method> result = new HashMap<>();
        Method method;
        ArrayList<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        try {
            fields.add(clazz.getSuperclass().getDeclaredField("id"));
        } catch (NoSuchFieldException | SecurityException ex) {
            
        }
        for (Field field : fields){
//        for (Field field : clazz.getFields()){
            try {
                method = getMethod(field);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
                continue;
            }
//            if (field.getAnnotation(TitledColumn.class) != null
//                    || field.getAnnotation(TitledId.class) != null
//                    || method.getAnnotation(TitledColumn.class) != null
//                    || method.getAnnotation(TitledId.class) != null) {
//                
//            }
            result.put(field, method);
        }
        return result;
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
