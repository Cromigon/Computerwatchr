package nu.fulkod.computer.dao;

import java.util.List;

import nu.fulkod.model.Computer;
import org.hibernate.SessionFactory;

public class ComputerDAO implements IComputerDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addComputer(Computer computer) {
		getSessionFactory().getCurrentSession().save(computer);
	}

	public void updateComputer(Computer computer) {
		getSessionFactory().getCurrentSession().update(computer);
	}

	public void deleteComputer(Computer computer) {
		getSessionFactory().getCurrentSession().delete(computer);
	}

	public Computer getComputerById(int id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from computers where id=?").setParameter(0, id).list();
		return (Computer)list.get(0);
	}

	public List<Computer> getComputers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Computer").list();
		return list;
	}
}
