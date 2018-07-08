package org.vignesh.capp.dao;

import java.util.List;

import org.vignesh.capp.domain.Contact;
import org.vignesh.capp.domain.User;

public interface ContactDAO {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactId);
	public Contact findbyId(Integer contactId);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String porpName, Object propvalue);
}
