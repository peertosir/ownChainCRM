package dev.peertosir.ownchaincrm.service.impl;

import dev.peertosir.ownchaincrm.domain.Detail;
import dev.peertosir.ownchaincrm.repository.DetailRepository;
import dev.peertosir.ownchaincrm.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;

    @Autowired
    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Detail> getAllDetails() {
        return detailRepository.findAll();
    }

    @Override
    public Detail getDetailById(int id) {
        Optional<Detail> detail = detailRepository.findById(id);
        if (detail.isPresent()) {
            return detail.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Detail with id: " + id);
    }

    @Override
    public int createDetail(Detail detail) {
         detail = detailRepository.save(detail);
         return detail.getId();
    }

    @Override
    public int updateDetail(Detail updatedDetail, int id) {
        Detail detail = getDetailById(id).updateWith(updatedDetail);
        detailRepository.save(detail);
        return id;
    }


    @Override
    public void deleteDetail(int id) {
        Detail detail = detailRepository.getById(id);
        detailRepository.delete(detail);
    }
}
