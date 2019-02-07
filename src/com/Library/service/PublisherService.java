package com.Library.service;

import com.Library.dao.PublisherDao;
import com.Library.model.Publisher;
import com.Library.util.ConnectDatabase;

public class PublisherService {

	PublisherDao publisherDao = new PublisherDao();
	
	public Publisher getAllPublisher() {
		
		return publisherDao.getAllPublishers(ConnectDatabase.getConnection());
	}
}
