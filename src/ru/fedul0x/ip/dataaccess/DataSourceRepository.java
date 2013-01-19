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

package ru.fedul0x.ip.dataaccess;

import ru.fedul0x.ip.dataaccess.dataobject.Patient;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class DataSourceRepository {

//    private DataSourceRepository INSTANCE = new DataSourceRepository();
//
//    public DataSourceRepository getInstance() {
//        return INSTANCE;
//    }
    
    public static DataSourceHibernate<? extends DataEntity> getDataSource(Class type){
        System.out.println(type.getGenericInterfaces()[0]);
//        DataSourceHibernate<type> dsh = new DataSourceHibernate<type>();
        DataSourceHibernate<Patient> dsh = new DataSourceHibernate<Patient>(Patient.class);
        return (DataSourceHibernate<Patient>)dsh;
    }
    
    private DataSourceRepository() {
    }

}
