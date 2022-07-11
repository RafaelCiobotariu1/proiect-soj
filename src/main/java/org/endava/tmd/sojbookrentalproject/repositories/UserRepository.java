package org.endava.tmd.sojbookrentalproject.repositories;

import org.endava.tmd.sojbookrentalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
