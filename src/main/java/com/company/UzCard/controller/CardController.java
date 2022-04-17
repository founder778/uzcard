package com.company.UzCard.controller;

import com.company.UzCard.dto.CardDTO;
import com.company.UzCard.entity.CardEntity;
import com.company.UzCard.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/card")
@Api(tags = "Card Control")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    @ApiOperation(value = "Creating new Card")
    public ResponseEntity<CardDTO> create(@RequestBody CardDTO dto) {
        log.warn("new card edded {} ", dto);
        CardDTO response = cardService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @ApiOperation(value = "Increasing balance of Card")
    public ResponseEntity increaseBalance(@RequestParam("number") String number, @RequestParam("amount") long amount) {
        log.warn(" card increasing ");
        cardService.increaseBalance(number, amount);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test/param")
    public ResponseEntity<String> test(@RequestParam("size") int size,
                                       @RequestParam("page") int page) {
        log.info("new request param : size:{}, page:{}", size, page);
        return ResponseEntity.ok("test method");
    }

    @GetMapping("/test/str")
    public ResponseEntity<String> testresponse() {
        return ResponseEntity.ok("test method");
    }







}
