package za.ac.nwu.ac.repo.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ac.domain.persistence.AccountType;
import org.springframework.stereotype.Repository;

import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>
{

}
