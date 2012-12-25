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
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class DataSourceHibernate<T extends DataEntity> implements DataSource<T> {

    private Class<T> persistentClass;
    private Session session;

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public DataSourceHibernate() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getClass();
    }

    protected Session getSession() {
          session=HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    @Override
    public T findById(Long id, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }

        return entity;
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public T makePersistent(T entity) {
        Transaction tx = getSession().beginTransaction();
        getSession().saveOrUpdate(entity);
        tx.commit();
        return entity;
    }

    @Override
    public void makeTransient(T entity) {
        Transaction tx = getSession().beginTransaction();
        getSession().delete(entity);
        tx.commit();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
}
