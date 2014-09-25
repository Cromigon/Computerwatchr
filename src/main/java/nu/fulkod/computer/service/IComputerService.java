package nu.fulkod.computer.service;

import java.util.List;

import nu.fulkod.model.Computer;

public interface IComputerService {
		public void addComputer(Computer computer);
		public void updateComputer(Computer computer);
		public void deleteComputer(Computer computer);
		public Computer getComputerById(int id);
		public List<Computer> getComputers();
}
