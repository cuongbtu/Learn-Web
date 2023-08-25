package com.demo1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo1.dto.NewDTO;
import com.demo1.respository.CategoryRepository;
import com.demo1.service.INewService;

@Service
public class NewService implements INewService{



	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		return null;
	}
}
