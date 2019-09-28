package com.mitutor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitutor.entities.TutoringOffer;
import com.mitutor.repository.ITutoringOfferRepository;
import com.mitutor.service.ITutoringOfferService;

@Service
public class TutoringOfferServiceImpl implements ITutoringOfferService {

	@Autowired
	private ITutoringOfferRepository tutoringOfferRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<TutoringOffer> findById(Integer id) throws Exception {
		return tutoringOfferRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TutoringOffer> findAll() throws Exception {
		return tutoringOfferRepository.findAll();
	}

	@Transactional()
	@Override
	public TutoringOffer save(TutoringOffer t) throws Exception {
		return tutoringOfferRepository.save(t);
	}

	@Transactional()
	@Override
	public void deleteById(Integer id) throws Exception {
		tutoringOfferRepository.deleteById(id);
	}

}
