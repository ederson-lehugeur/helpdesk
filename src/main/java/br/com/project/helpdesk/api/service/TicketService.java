package br.com.project.helpdesk.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.project.helpdesk.api.entity.ChangeStatus;
import br.com.project.helpdesk.api.entity.Ticket;
import br.com.project.helpdesk.api.repository.ChangeStatusRepository;
import br.com.project.helpdesk.api.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ChangeStatusRepository changeStatusRepository;

	public Ticket createOrUpdate(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Optional<Ticket> findById(String id) {
		return ticketRepository.findById(id);
	}

	public void delete(String id) {
		ticketRepository.deleteById(id);
	}

	public Page<Ticket> listTicket(int page, int count) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findAll(pageRequest);
	}

	public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
		return changeStatusRepository.save(changeStatus);
	}

	public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
		return changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
	}

	public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findByUserIdOrderByDateDesc(pageRequest, userId);
	}

	public Page<Ticket> findByParameters(int page, int count, String title, String status, String priority) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(title, status,
				priority, pageRequest);
	}

	public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status,
			String priority, String userId) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(title,
				status, priority, userId, pageRequest);
	}

	public Page<Ticket> findByNumber(int page, int count, Integer number) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findByNumber(number, pageRequest);
	}

	public Iterable<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	public Page<Ticket> findByParameterAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUser) {
		PageRequest pageRequest = PageRequest.of(page, count);

		return ticketRepository.findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
				title, status, priority, assignedUser, pageRequest);
	}
}
