package br.com.project.helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.project.helpdesk.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
