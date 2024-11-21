package ma.graphql.test;

import ma.graphql.test.entities.Compte;
import ma.graphql.test.entities.Transaction;
import ma.graphql.test.entities.TypeCompte;
import ma.graphql.test.entities.TypeTransaction;
import ma.graphql.test.repositories.CompteRepository;
import ma.graphql.test.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
		return args -> {
			Compte compte1 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, null));
			Compte compte2 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, null));
			Compte compte3 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, null));

			transactionRepository.save(new Transaction(null, 2000, new Date(), TypeTransaction.RETRAIT, compte1));
			transactionRepository.save(new Transaction(null, 1000, new Date(), TypeTransaction.DEPOT, compte2));
			transactionRepository.save(new Transaction(null, 500, new Date(), TypeTransaction.RETRAIT, compte3));
		};
	}
}