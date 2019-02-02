package br.com.project.helpdesk.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.project.helpdesk.api.entity.User;
import br.com.project.helpdesk.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findById(String id) {
		return userRepository.findById(id);
	}

	public void delete(String id) {
		userRepository.deleteById(id);
	}

	public Page<User> findAll(int page, int count) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return userRepository.findAll(pageRequest);
	}
}
