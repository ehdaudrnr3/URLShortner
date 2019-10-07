package com.spring.boot.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.urlshortner.models.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, Long>{

	public URL findByKey(String key);
}
