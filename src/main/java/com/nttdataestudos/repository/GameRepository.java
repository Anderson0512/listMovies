package com.nttdataestudos.repository;

import com.nttdataestudos.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
