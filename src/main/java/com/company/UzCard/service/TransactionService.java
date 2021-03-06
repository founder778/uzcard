package com.company.UzCard.service;

import com.company.UzCard.dto.TransactionDTO;
import com.company.UzCard.entity.CardEntity;
import com.company.UzCard.entity.TransactionEntity;
import com.company.UzCard.repository.CardRepository;
import com.company.UzCard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    @Lazy
    private CardService cardService;
    @Autowired
    private CardRepository cardRepository;

    public Boolean makeTransaction(String fromCardNumber, String toCardNUmber, Long amount) {
        CardEntity fromCard = cardService.get(fromCardNumber); // 1213
        CardEntity toCard = cardService.get(toCardNUmber);
        return doTransaction(fromCard, toCard, amount);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean doTransaction(CardEntity fromCard, CardEntity toCard, Long amount) {
        Long balance = cardRepository.getCardBalance(fromCard.getNumber());
        if (balance == null || balance < amount) {
            throw new RuntimeException("Not enough balance.");
        }

        cardService.update_balance(fromCard.getNumber(), amount * -1);
        cardService.update_balance(toCard.getNumber(), amount);

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setFromCard(fromCard);
        transactionEntity.setToCard(toCard);
        transactionEntity.setAmount(amount);
        transactionEntity.setCreatedDate(LocalDateTime.now());
        transactionRepository.save(transactionEntity);
        return null;
    }


    public List<TransactionDTO> getTransactionByPid(Integer profileId){
        return transactionRepository.getTransactionByPid(profileId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getDebitByPid(Integer profileId){
        return transactionRepository.getDebitByPid(profileId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getCreditByPid(Integer profileId){
        return transactionRepository.getCreditByPid(profileId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionByCid(Integer cardId){
        return transactionRepository.getTransactionByCid(cardId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getCreditByCid(Integer cardId){
        return transactionRepository.getByFromCardId(cardId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getDebitByCid(Integer cardId){
        return transactionRepository.getByToCardId(cardId).stream().
                map(this::toDTO).collect(Collectors.toList());
    }





    @Transactional(propagation = Propagation.NEVER)
    public boolean get() {
        transactionRepository.findAll();
        return true;
    }

    public TransactionDTO toDTO(TransactionEntity entity){
        TransactionDTO dto = new TransactionDTO();
        dto.setId(entity.getId());
        dto.setFromCard(entity.getFromCard().getId());
        dto.setToCard(entity.getToCard().getId());
        dto.setAmount(entity.getAmount());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;

    }

}
