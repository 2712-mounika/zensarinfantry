package com.instagram.service;

import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramEmployee;

public class InstagramService implements InstagramServiceInterface{
private InstagramService() {}

public static InstagramServiceInterface createServiceObject() {
	// TODO Auto-generated method stub
	return new InstagramService();
}

@Override
public int createProfile(InstagramEmployee ie) {
	// TODO Auto-generated method stub
	InstagramDAOInterface id = InstagramDAO.createDaoObject();
	return  id.createProfileDAO(ie);
}

}
