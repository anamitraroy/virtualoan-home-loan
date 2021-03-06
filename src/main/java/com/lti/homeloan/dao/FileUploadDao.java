package com.lti.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.homeloan.entity.FileUploadEntity;
import com.lti.homeloan.entity.UserEntity;

@Repository
public class FileUploadDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addFiles(FileUploadEntity fileUploadEntity) {
		/*FileUploadEntity fil = entityManager.merge(fileUploadEntity);*/
		entityManager.persist(fileUploadEntity);
	}
	
	public List<FileUploadEntity> fetchAll() {
		return entityManager.createQuery("select f from FileUploadEntity f").getResultList();
	}

	public FileUploadEntity fetch(UserEntity user) {
		return entityManager.find(FileUploadEntity.class, user);
	}
}
