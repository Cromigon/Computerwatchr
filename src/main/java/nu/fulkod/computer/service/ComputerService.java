package nu.fulkod.computer.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import nu.fulkod.computer.dao.IComputerDAO;
import nu.fulkod.model.Computer;

@Transactional(readOnly = true)
public class ComputerService implements IComputerService {

	IComputerDAO computerDAO;

	@Transactional(readOnly = false)
	public void addComputer(Computer computer) {
		getComputerDAO().addComputer(computer);
	}

	@Transactional(readOnly = false)
	public void updateComputer(Computer computer) {
		getComputerDAO().updateComputer(computer);
	}

	@Transactional(readOnly = false)
	public void deleteComputer(Computer computer) {
		getComputerDAO().deleteComputer(computer);
	}

	public Computer getComputerById(int id) {
		return getComputerDAO().getComputerById(id);
	}

	public List<Computer> getComputers() {
		return getComputerDAO().getComputers();
	}

	public IComputerDAO getComputerDAO() {
		return computerDAO;
	}

	public void setComputerDAO(IComputerDAO computerDAO) {
		this.computerDAO = computerDAO;
	}

}
