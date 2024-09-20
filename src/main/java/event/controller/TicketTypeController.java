package event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import event.object.po.TicketTypesPO;
import event.service.TicketTypeService;

@Controller
public class TicketTypeController {

	@Autowired
	private TicketTypeService ticketTypeService;
	
	
	@GetMapping("/event/TicketType")
	public String readAllTicketTypes(Model model) {
		List<TicketTypesPO> ticketTypeslist = ticketTypeService.readAllTicketTypes();
		model.addAttribute("ticketTypes", ticketTypeslist);
		return "ReadAllTicketTypes";
	}
	
	@GetMapping("/event/TicketType/{ticketTypeID}")
	public String readOneTicketType(@PathVariable("ticketTypeID") Integer ticketTypeID, Model model) {
		
    	// 取得該票種資料
		TicketTypesPO ticketType = ticketTypeService.readOneTicketType(ticketTypeID);
		model.addAttribute("ticketType", ticketType);
		
		// 取得該票種是否為該場次的唯一票種
//		Boolean isOnly = ticketTypeService.searchIfOnlyTicketTypeByPO(ticketType);
		Boolean isOnly = true;
		model.addAttribute("isOnly", isOnly);
		
		return "TicketType";
	}
	
	@DeleteMapping("/event/TicketType/{ticketTypeID}")
	public String deleteTicketType() {
		// TODO
		return "DeleteTicketTypeResult";
	}
}
