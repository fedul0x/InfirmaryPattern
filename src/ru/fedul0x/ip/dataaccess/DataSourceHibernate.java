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
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.reflection.ReflectionUtil;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import ru.fedul0x.ip.dataaccess.dataobject.StaffPosition;

/**
 * Impelementation of DataSource for work with Hibernate
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class DataSourceHibernate<T extends DataEntity> extends DataSource<T> {
    private Session session;
    private Transaction transaction;
    protected Class<T> persistentClass;
    
    
    public DataSourceHibernate(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    public Class<T> getPersistentClass() {
        return persistentClass;
    }
    
    protected Session getSession() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
    
    @Override
    public T findById(Long id, boolean lock) {
        T entity;
        beginTransaction();
        if (lock) {
            entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }
        commitTransaction();
        return entity;
    }
    
    @Override
    public List<T> findAll() {
        return findByCriteria();
    }
    
    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        beginTransaction();
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        commitTransaction();
        return crit.list();
    }
    
    protected List<T> findByCriteria(Criterion... criterion) {
        beginTransaction();
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        List<T> result = crit.list();
        commitTransaction();
        return result;
    }
    
    public Long findMaxId() {
        beginTransaction();
        
        commitTransaction();
        return 0L;
    }
    
    @Override
    public T makePersistent(T entity) {
        beginTransaction();
        getSession().saveOrUpdate(entity);
        commitTransaction();
        return entity;
    }
    
    @Override
    public void makeTransient(T entity) {
        beginTransaction();
        getSession().delete(entity);
        commitTransaction();
    }
    
    public void flush() {
        beginTransaction();
        getSession().flush();
        commitTransaction();
    }
    
    public void clear() {
        beginTransaction();
        getSession().clear();
        commitTransaction();
    }
    
    private void beginTransaction() {
        transaction = getSession().beginTransaction();
    }
    
    private void commitTransaction() {
        transaction.commit();
    }
}
