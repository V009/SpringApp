package org.vignesh.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//Note: Do not going to independently exist in the container, so do not use it for IOC
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
		
	}

}
