package com.example.byself.repositories;

import com.example.byself.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositories extends JpaRepository<Image, Long> {
}
