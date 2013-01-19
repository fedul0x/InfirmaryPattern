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

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Methods for data manipulation with persistent and transient data objects 
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public abstract class DataSource<T extends DataEntity> {

    public abstract T findById(Long id, boolean lock);

    public abstract List<T> findAll();

    public abstract List<T> findByExample(T exampleInstance, String[] excludeProperty);

    public abstract T makePersistent(T entity);

    public abstract void makeTransient(T entity);

}
