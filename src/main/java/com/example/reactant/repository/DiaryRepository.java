package com.example.reactant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reactant.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary,Integer>{
    // select * from diary where id=:id
    Diary findById(int id);
    void deleteById(int id);
}