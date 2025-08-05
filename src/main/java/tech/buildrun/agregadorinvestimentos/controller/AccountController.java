package tech.buildrun.agregadorinvestimentos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.agregadorinvestimentos.controller.dto.AccountResponseDto;
import tech.buildrun.agregadorinvestimentos.controller.dto.AccountStockDto;
import tech.buildrun.agregadorinvestimentos.controller.dto.AccountStockResponseDto;
import tech.buildrun.agregadorinvestimentos.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStock(@PathVariable("accountId") String accountId,
                                               @RequestBody AccountStockDto accountStockDto) {
        accountService.associateStock(accountId, accountStockDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDto>> listStocks(@PathVariable("accountId") String accountId) {
        var stocks = accountService.listStocks(accountId);
        return ResponseEntity.ok(stocks);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> listAccounts() {
        var accounts = accountService.listAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}