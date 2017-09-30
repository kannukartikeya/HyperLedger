package com.chaincode.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaincode.services.RegulatorService;
import com.chaincode.services.SyndicateParticipantsService;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class RegulatorController {
	
    private RegulatorService regulatorService;

    @Autowired
    public void setProductService(RegulatorService regulatorService) {
        this.regulatorService = regulatorService;
    }


	@RequestMapping("/regulator")
	public String getChain(Model model){
		model.addAttribute("blockchainTxns", regulatorService.getChain());
		return "blockChainTransactions";
	}
	
	
}
