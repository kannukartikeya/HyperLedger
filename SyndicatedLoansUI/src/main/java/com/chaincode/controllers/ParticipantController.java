package com.chaincode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaincode.services.SyndicateParticipantsService;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class ParticipantController {
	
    private SyndicateParticipantsService syndicatedParticipantsService;

    @Autowired
    public void setProductService(SyndicateParticipantsService syndicatedParticipantsService) {
        this.syndicatedParticipantsService = syndicatedParticipantsService;
    }


	@RequestMapping("/participant/{id}")
	public String getParticipantDetails(@PathVariable String id, Model model) {
		model.addAttribute("participant", syndicatedParticipantsService.getParticipantDetails(id));
		return "participantshow";
	}
	
	
}
