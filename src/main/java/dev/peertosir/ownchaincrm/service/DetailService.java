package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Detail;

import java.util.List;

public interface DetailService {
    List<Detail> getAllDetails();

    Detail getDetailById(int id);

    int createDetail(Detail detail);

    int updateDetail(Detail updatedDetail, int id);

    void deleteDetail(int id);
}
