package br.com.project.helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.project.helpdesk.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {

	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
