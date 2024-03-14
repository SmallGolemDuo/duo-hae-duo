package com.deux.duohaeduo.repository;

import com.deux.duohaeduo.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

    List<Champion> findByChampionType(String championType);

}
