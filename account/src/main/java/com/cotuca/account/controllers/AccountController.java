package com.cotuca.account.controllers;

import com.cotuca.account.models.Account;
import com.cotuca.account.models.Transaction;
import com.cotuca.account.repositories.AccountRepository;
import com.cotuca.account.repositories.TransactionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(accounts);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable Integer number) {
        return accountRepository.findById(number)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Integer number) {
        return (accountRepository.findById(number)
                .map(__account -> {
                   __account.setNumber(account.getNumber());
                   __account.setOwner(account.getOwner());
                   __account.setBalance(account.getBalance());
                   return ResponseEntity.ok(accountRepository.save(__account));
                })
                .orElseGet(() -> {
                    return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(account));
                }));
    }

    @GetMapping("/{number}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Integer number) {
        List<Transaction> transactions_list = transactionRepository.findByAccountNumber(number);
        return transactions_list.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(transactions_list);
    }

    @PostMapping("/{number}/deposit")
    public ResponseEntity<Transaction> makeDeposit(@PathVariable Integer number, @RequestBody Transaction transaction) {
        return accountRepository.findById(number)
                .map(account -> {
                    account.setBalance(account.getBalance() + transaction.getAmount());
                    accountRepository.save(account);
                    transaction.setAccount(account);
                    Transaction savedTransaction = transactionRepository.save(transaction);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{number}/withdrawal")
    public ResponseEntity<?> makeWithdrawal(@PathVariable Integer number, @RequestBody Transaction transaction) {
        return accountRepository.findById(number)
                .map(account -> {
                    if (account.getBalance() < transaction.getAmount()) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O saldo da conta é insuficiente");
                    }
                    account.setBalance(account.getBalance() - transaction.getAmount());
                    accountRepository.save(account);
                    transaction.setAccount(account);
                    Transaction savedTransaction = transactionRepository.save(transaction);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
