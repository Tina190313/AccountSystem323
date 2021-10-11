package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_TYPE",schema = "HR")

public class AccountType implements Serializable {
    @Id
    @SequenceGenerator (name = "SEQ_ACCOUNT_ID", sequenceName = "HR.SEQ_ACCOUNT_ID",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT_ID")

    private static final long serialVersionUID = -2282337104058330818L;

    private Long accountTypeID;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;


    public AccountType(Long accountTypeID, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeID = accountTypeID;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;

    }

    public AccountType() {
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
    }


    @Column(name = "ACCOUNT_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }
    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    @Column(name = "ACC_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }
    @Column(name = "CREATE_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }
    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction>getAccountTransactions()
    {
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction>accountTransactions)
    {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }


    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }


    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }


    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {


        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

