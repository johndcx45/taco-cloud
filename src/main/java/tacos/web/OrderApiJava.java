package tacos.web;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tacos.TacoOrder;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.messaging.OrderMessagingService;

@RestController
@RequestMapping("/order")
public class OrderApiJava {

	private OrderRepository orderRepo;

	private OrderProps props;

	private OrderMessagingService messageService;

	public OrderApiJava(OrderRepository orderRepo,
			OrderProps props, OrderMessagingService messageService) {
		this.orderRepo = orderRepo;
		this.props = props;
		this.messageService = messageService;
	}

	@GetMapping
	public String ordersForUser(
			@AuthenticationPrincipal User user, Model model) {

		Pageable pageable = PageRequest.of(0, props.getPageSize());
		model.addAttribute("orders",
				orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));

		return "orderList";
	}

	@DeleteMapping("/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		try {
			orderRepo.deleteById(orderId);
		} catch (EmptyResultDataAccessException e) {}
	}


	@GetMapping(produces="application/json")
	public Iterable<TacoOrder> allOrders() {
		return orderRepo.findAll();	
	}

	@PostMapping("new")
	@ResponseStatus(HttpStatus.CREATED)
	public TacoOrder postOrder(@RequestBody TacoOrder order) {
		messageService.send(order);

		return orderRepo.save(order);
	}

	@PutMapping(path="/{orderId}", consumes="application/json")
	public TacoOrder putOrder(
			@PathVariable("orderId") Long orderId,
			@RequestBody TacoOrder order) {
		order.setOrderId(orderId);
		return orderRepo.save(order);
	}
}
