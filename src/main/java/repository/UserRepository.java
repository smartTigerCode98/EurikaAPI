package repository;

import entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findById(int id);

}
