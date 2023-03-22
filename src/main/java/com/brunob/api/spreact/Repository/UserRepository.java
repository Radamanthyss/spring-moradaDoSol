package com.brunob.api.spreact.Repository;

import com.brunob.api.spreact.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
