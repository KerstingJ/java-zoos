package com.lambda.zoos.services;

import com.lambda.zoos.daos.TelephoneDao;
import com.lambda.zoos.daos.ZooDao;
import com.lambda.zoos.models.Telephone;
import com.lambda.zoos.models.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value="zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    ZooDao zooDao;

    @Autowired
    TelephoneDao phoneDao;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> zoos = new ArrayList<>();
        zooDao.findAll().iterator().forEachRemaining(zoos::add);
        return zoos;
    }

    @Override
    public Zoo findByName(String name)
    {
        Zoo zoo = zooDao.findZooByZooname(name);
        return zoo;
    }

    @Override
    @Transactional
    public Zoo update(Zoo zoo, long id)
    {
        Zoo current = zooDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (zoo.getZooname() == null) {
            current.setZooname(zoo.getZooname());
        }

        if (zoo.getPhones().size() > 0) {

            ArrayList<Telephone> ZooPhones = new ArrayList<>();
            current.getPhones().iterator().forEachRemaining(ZooPhones::add);

            ArrayList<Telephone> newZooPhones = new ArrayList<>();
            zoo.getPhones().iterator().forEachRemaining(newZooPhones::add);
            ArrayList<Telephone> diff = new ArrayList<>();

            for (Telephone p: newZooPhones) {
                if (!ZooPhones.contains(p)) {
                    p.setZoo(current);
                    diff.add(p);
                }
            }

            ZooPhones.addAll(diff);
            current.setPhones(ZooPhones);
        }

        return zooDao.save(current);
    }

    @Override
    @Transactional
    public Zoo save(Zoo zoo)
    {
        return zooDao.save(zoo);
    }

    @Override
    public ArrayList<Zoo> delete(long id)
    {
        Zoo zoo = zooDao.findById(id).get();
        if (zoo != null) {
            zooDao.delete(zoo);
        }

        return findAll();
    }
}
