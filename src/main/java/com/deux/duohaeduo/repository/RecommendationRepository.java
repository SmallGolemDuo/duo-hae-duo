package com.deux.duohaeduo.repository;

import com.deux.duohaeduo.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Recommendation, Long> {

}
