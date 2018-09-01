package com.ssm.service;
import java.util.List;

import com.ssm.domain.Items;

public interface ItemsService {

	List<Items> findAll();

	Items findByID(Integer id);

	void saveOrUpdate(Items items);

	void deleteByID(Integer id);

}