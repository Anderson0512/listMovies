package com.nttdataEstudos.nttEstudos.repository;

import com.nttdataEstudos.nttEstudos.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
