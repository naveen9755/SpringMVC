package com.spr.service;

import java.util.List;

import com.spr.exception.MarksheetNotFound;
import com.spr.model.Marksheet;

public interface MarksheetService {
	
	public Marksheet create(Marksheet marksheet);
	public Marksheet delete(int id) throws MarksheetNotFound;
	public List<Marksheet> findAll();
	public Marksheet update(Marksheet marksheet) throws MarksheetNotFound;
	public Marksheet findById(int id);

}
