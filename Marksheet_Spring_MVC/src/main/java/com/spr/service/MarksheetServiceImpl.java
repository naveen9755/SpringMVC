package com.spr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spr.exception.MarksheetNotFound;
import com.spr.model.Marksheet;
import com.spr.repository.MarksheetRepository;

@Service
public class MarksheetServiceImpl implements MarksheetService {
	
	@Resource
	private MarksheetRepository marksheetRepository;

	@Override
	@Transactional
	public Marksheet create(Marksheet marksheet) {
		Marksheet createdMarksheet = marksheet;
		return marksheetRepository.save(createdMarksheet);
	}
	
	@Override
	@Transactional
	public Marksheet findById(int id) {
		return marksheetRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=MarksheetNotFound.class)
	public Marksheet delete(int id) throws MarksheetNotFound {
		Marksheet deletedMarksheet = marksheetRepository.findOne(id);
		
		if (deletedMarksheet == null)
			throw new MarksheetNotFound();
		
		marksheetRepository.delete(deletedMarksheet);
		return deletedMarksheet;
	}

	@Override
	@Transactional
	public List<Marksheet> findAll() {
		return marksheetRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=MarksheetNotFound.class)
	public Marksheet update(Marksheet marksheet) throws MarksheetNotFound {
		Marksheet updatedMarksheet = marksheetRepository.findOne(marksheet.getId());
		
		if (updatedMarksheet == null)
			throw new MarksheetNotFound();
		
		updatedMarksheet.setName(marksheet.getName());
		updatedMarksheet.setRollno(marksheet.getRollno());
		return updatedMarksheet;
	}

}
