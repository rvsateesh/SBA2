package com.eval.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	public KitDetail addKitItem(KitDetail kitItem) {
		// TODO Auto-generated method stub
		return repository.save(kitItem);
	}

	@Override
	public KitDetail getKitItemById(int itemId) {
		// TODO Auto-generated method stub
		return repository.getOne(itemId);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public List<KitDetail> getAllKitItems(){
		return repository.findAll();
	}
}
