package org.serratec.exercicio05.repository;

import org.serratec.exercicio05.domain.ClienteVip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteVipRepository extends JpaRepository<ClienteVip, Long> {
}