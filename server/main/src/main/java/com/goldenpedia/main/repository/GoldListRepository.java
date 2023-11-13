package com.goldenpedia.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.goldenpedia.main.domain.GoldList;
import com.goldenpedia.main.domain.Word;

public interface GoldListRepository extends CrudRepository<GoldList, Long> {
    @Query("SELECT p FROM GoldList gl JOIN gl.words p WHERE gl.id = :goldListId AND p.status = :status")
    List<Word> buscarPalavrasPorGListEStatus(Long goldListId,String status);
}
