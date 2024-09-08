package com.khantwal.wiki.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khantwal.wiki.entities.WikiEntity;

public interface WikiRepository extends JpaRepository<WikiEntity, Long> {

}
