package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<Whisky> findWhiskyOfParticularYear(int year) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Whisky> findWhiskyBasedOnId(Long id) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
//            cr.createAlias("Favourite_Whisky", "Fav_whisky");
            cr.add(Restrictions.eq("id", id));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }

        return result;
    }

    @Transactional
    public List<Whisky> findWhiskyBasedOnDistilleryAndAge(int age){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distilleries", "distillery");

            cr.add(Restrictions.eq("distillery.age", age));
            cr.add(Restrictions.eq("age", 12));
//            cr.add(Restrictions.eq("distillery_id", 1));
            result = cr.list();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        return result;
    }
}
