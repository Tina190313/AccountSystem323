package za.ac.nwu.ac.repo.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>
{
    @Query(value = "Select " +
            "           ACCOUNT_ID,"+
            "           ACC_TYPE_NAME, "+
            "           MNEMONIC, "+
            "           CREATE_DATE"+
            " FROM " +
            "HR" +
            ".ACCOUNT_TYPE "+
            "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT"+
            "           at "+
            "           FROM "+
            "           AccountType at "+
            "           WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);


    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( "+
            "       at.mnemonic, "+
            "       at.accountTypeName," +
            "       at.creationDate )" +
            "       FROM "+
            "       AccountType at "+
            "   WHERE at.mnemonic= :mnemonic")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


}

