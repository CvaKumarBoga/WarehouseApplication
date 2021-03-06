package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	public HibernateTemplate ht;
	@Override
	public Integer saveItem(Item it) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(it);
	}

	@Override
	public void updateItem(Item it) {
		// TODO Auto-generated method stub
		ht.update(it);
	}

	@Override
	public void deleteItem(Integer id) {
		// TODO Auto-generated method stub
		Item i=new Item();
		i.setId(id);
		ht.delete(i);
	}

	@Override
	public Item getOneItem(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return ht.loadAll(Item.class);
	}

}
