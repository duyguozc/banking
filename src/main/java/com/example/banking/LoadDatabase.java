package com.example.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MemberRepository repository, AccountRepository accountRepository, LoanRepository loanRepository) {

        return args -> {
            Member member1 = new Member("Pam", "55555555");
            log.info("Preloading " + repository.save(member1));
            Account account1 = new Account("saving", 100, 0.4, "2022-01-02", member1);
            Loan loan1 = new Loan(1000, 4.5, 3, "2024-06-01", "2025-06-01", "paid off", member1);
            accountRepository.save(account1);
            loanRepository.save(loan1);


            Member member2 = repository.save(new Member("Jim", "55555555"));
            log.info("Preloading " + member2);
            Account account2 = new Account("saving", 150, 0.4, "2022-01-02", member2);
            Loan loan2 = new Loan(2000, 4.5, 3, "2024-06-01", "2025-06-01", "active", member2);
            accountRepository.save(account2);
            loanRepository.save(loan2);

            Member member3 = repository.save(new Member("Duygu", "7777777"));
            log.info("Preloading " + member3);
            Account account3 = new Account("saving", 150, 0.4, "2022-01-02", member3);
            Account account31 = new Account("checking", 50, 0.1, "2022-01-02", member3);
            Account account32 = new Account("checking", 2000, 0.1, "2022-01-02", member3);
            Loan loan3 = new Loan(2000, 4.5, 3, "2024-06-01", "2025-06-01", "paid off", member3);
            Loan loanDuygu = new Loan(3000, 1.5, 6, "2024-06-01", "2025-06-01", "active", member3);
            accountRepository.save(account3);
            accountRepository.save(account31);
            accountRepository.save(account32);
            loanRepository.save(loan3);
            loanRepository.save(loanDuygu);

            Member member4 = repository.save(new Member("Ugur", "7777777"));
            log.info("Preloading " + member4);
            Account account4 = new Account("saving", 150, 0.4, "2022-01-02", member4);
            Account accountUgur = new Account("saving", 1500, 0.5, "2022-01-02", member4);
            Loan loan4 = new Loan(2000, 4.5, 3, "2024-06-01", "2025-06-01", "paid off", member4);
            accountRepository.save(account4);
            accountRepository.save(accountUgur);
            loanRepository.save(loan4);


            Member member5 = repository.save(new Member("Michael", "8888888"));
            log.info("Preloading " + member5);
            Account account5 = new Account("saving", 150, 0.4, "2022-01-02", member5);
            Loan loan5 = new Loan(2000, 4.5, 3, "2024-06-01", "2025-06-01", "paid off", member5);
            accountRepository.save(account5);
            loanRepository.save(loan5);

            log.info("All Loans ");
            loanRepository.findAll().forEach(account -> {
                log.info(account.toString());
            });

/*            log.info("Member found with findById(1L):");
            Optional<Member> m = repository.findById(1L);
            if(m.isPresent())
                log.info(m.get().toString());
            else
                log.info("not found");*/
        };
    }
}