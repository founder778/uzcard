package com.company.UzCard;

import com.company.UzCard.dto.CardDTO;
import com.company.UzCard.dto.ProfileDTO;
import com.company.UzCard.entity.CardEntity;
import com.company.UzCard.entity.ProfileEntity;
import com.company.UzCard.service.CardService;
import com.company.UzCard.service.ProfileService;
import com.company.UzCard.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class UzCardApplicationTests {
@Autowired
private ProfileService profileService;
@Autowired
private CardService cardService;
@Autowired
private TransactionService transactionService;

	@Test
	void contextLoads() {

//		ProfileDTO profile = new ProfileDTO();
RestTemplate restTemplate = new RestTemplate();
	}

}
