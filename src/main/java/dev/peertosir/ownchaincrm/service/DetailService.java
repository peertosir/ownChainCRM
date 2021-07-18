package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Detail;

import java.util.List;

public interface DetailService {
    List<Detail> getAllDetails();

    Detail getDetailById(long id);

    long createDetail(Detail detail);

    long updateDetail(Detail updatedDetail, long id);

    void deleteDetail(long id);
}
