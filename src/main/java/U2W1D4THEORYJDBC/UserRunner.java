package U2W1D4THEORYJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import U2W1D4THEORYJDBC.dao.UserDAOImpl;
import U2W1D4THEORYJDBC.entities.User;

@Component
public class UserRunner implements CommandLineRunner {
	@Autowired
	UserDAOImpl uDao;

	@Override
	public void run(String... args) throws Exception {
		User aldo = User.builder().name("Giovanni").surname("Storti").email("giovanni@storti.it").build();

		uDao.save(aldo);

		System.out.println("***************** FIND ALL ***************");
		uDao.findAll().forEach(user -> System.out.println(user));

		System.out.println("***************** FIND BY ID ***************");
		System.out.println(uDao.findById(1));

		System.out.println("***************** FIND BY ID AND UPDATE ***************");
		User ajeje = User.builder().name("Ajeje").surname("Brazorf").email("ajeje@multina.it").build();

		int updatedRows = uDao.findByIdAndUpdate(0, ajeje);
		if (updatedRows == 0) {
			System.out.println("Utente non trovato");
		} else {
			System.out.println(uDao.findById(1));

		}

		System.out.println("***************** FIND BY ID AND DELETE ***************");
		int deletedRows = uDao.findByIdAndDelete(2);
		if (deletedRows == 0) {
			System.out.println("Utente non trovato");
		} else {
			uDao.findAll().forEach(user -> System.out.println(user));

		}

		System.out.println("***************** COUNT ***************");
		System.out.println("Numero utenti in db: " + uDao.count());

	}

}
