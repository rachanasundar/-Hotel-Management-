package com.surabi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabi.bean.Menu;
import com.surabi.dao.MenuDao;

@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;

	// to get all menu from database
	public List<Menu> getAllMenu() {
		return menuDao.findAll();
	}

	// to add new menu to the database
	public String addNewMenu(Menu menu) {
		if (menuDao.existsById(menu.getItemId())) {
			return "Item ID must be unique ";
		} else {
			menuDao.save(menu);
			return "Item Stored Successfully";
		}

	}

	// to change item name in the database
	public String updateItemName(Menu menu) {
		if (!menuDao.existsById(menu.getItemId())) {
			return "Item details not present.Failed to Update";
		} else {
			Menu m = menuDao.getById(menu.getItemId());
			m.setItemName(menu.getItemName());
			menuDao.saveAndFlush(m);
			return "Item Name Updated SuccessFully";
		}
	}

	// to change item price in the database
	public String updateItemPrice(Menu menu) {
		if (!menuDao.existsById(menu.getItemId())) {
			return "Item details not present.Failed to Update";
		} else {
			Menu m = menuDao.getById(menu.getItemId());
			m.setItemPrice(menu.getItemPrice());
			menuDao.saveAndFlush(m);
			return "Item Price Updated SuccessFully";
		}
	}

	// to detele a item with given item id in the database
	public String deleteItem(int id) {
		if (!menuDao.existsById(id)) {
			return "Item details not present.Failed to Update";
		} else {
			menuDao.deleteById(id);
			return "Item Deleted Successfully from the Menu";
		}

	}

}
