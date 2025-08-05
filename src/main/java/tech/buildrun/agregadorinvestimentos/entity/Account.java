// Em: agregadorinvestimentos/entity/Account.java

package tech.buildrun.agregadorinvestimentos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID accountId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    // O cascade = CascadeType.ALL garante que o BillingAddress seja salvo junto com a Account.
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private BillingAddress billingAddress;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountStock> accountStocks = new ArrayList<>();


    public Account() {
    }

    // Construtor, Getters e Setters... (sem alterações)

    public void setBillingAddress(BillingAddress billingAddress) {
        // Importante: garantir a consistência nos dois lados da relação
        if (billingAddress != null) {
            billingAddress.setAccount(this);
        }
        this.billingAddress = billingAddress;
    }

    public Account(UUID accountId, User user, BillingAddress billingAddress, String description, List<AccountStock> accountStocks) {
        this.accountId = accountId;
        this.user = user;
        this.billingAddress = billingAddress;
        this.description = description;
        this.accountStocks = accountStocks;

    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AccountStock> getAccountStocks() {
        return accountStocks;
    }

    public void setAccountStocks(List<AccountStock> accountStocks) {
        this.accountStocks = accountStocks;
    }
}