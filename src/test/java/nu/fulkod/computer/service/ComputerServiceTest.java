package nu.fulkod.computer.service;

import java.util.ArrayList;
import java.util.List;
import nu.fulkod.computer.dao.ComputerDAO;
import nu.fulkod.model.Computer;
import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ComputerServiceTest {
	private ComputerDAO computerDAO;
	private ComputerService computerService;

	@Before
	public void doSetup() {
		computerDAO = mock(ComputerDAO.class);
		computerService = new ComputerService();
		computerService.setComputerDAO(computerDAO);
	}

	@Test
	public void AddComputerTest() {
		Computer computer = new Computer();
		computer.setIpAddress("127.0.0.1");
		computer.setName("Batman");
		computer.setOperatingSystem("BatOS");
		computer.setServices("Justice");
		List<Computer> computerList = new ArrayList<Computer>();
		computerList.add(computer);

		doNothing().when(computerDAO).addComputer(any(Computer.class));
		when(computerDAO.getComputerById(1)).thenReturn(computer);
		when(computerDAO.getComputers()).thenReturn(computerList);
		assertNotNull(computerService.getComputerById(1));
		assertEquals(computer, computerService.getComputerById(1));
		assertNotNull(computerService.getComputers());
		assertNotNull(computerService.getComputerDAO());
	}
}
