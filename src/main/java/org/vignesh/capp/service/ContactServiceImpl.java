package org.vignesh.capp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vignesh.capp.dao.BaseDAO;
import org.vignesh.capp.dao.ContactDAO;
import org.vignesh.capp.domain.Contact;
import org.vignesh.capp.rm.ContactRowMapper;
import org.vignesh.capp.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	 @Autowired
	 private ContactDAO contactDAO;
	 
	public void save(Contact c) {
		 contactDAO.save(c);// TODO Auto-generated method stub
		
	}

	public void update(Contact c) {
		contactDAO.update(c);// TODO Auto-generated method stub
		
	}

	public void delete(Integer cotactId) {
		contactDAO.delete(cotactId);// TODO Auto-generated method stub
		
	}

	public void delete(Integer[] cotactIds) {
		String ids = StringUtil.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);// TODO Auto-generated method stub
		
	}

	public Contact findById(Integer cotactId) {
		return contactDAO.findbyId(cotactId);
	}

	public List<Contact> findUserContact(Integer userId) {

		return contactDAO.findByProperty("UserId", userId);
		
	}

	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
	}

}
