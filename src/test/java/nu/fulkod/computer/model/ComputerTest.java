package nu.fulkod.computer.model;

import nu.fulkod.model.Computer;

import org.junit.*;

import static org.junit.Assert.*;

public class ComputerTest {

	private Computer testComputer;

	@Before
	public void doSetup() {
		testComputer = new Computer();
		testComputer.setId(1);
		testComputer.setIpAddress("192.168.0.123");
		testComputer.setName("Legion");
		testComputer.setOperatingSystem("Debian");
		testComputer.setServices("Nothing");
	}

	@Test
	public void getIdTest() {
		assertNotNull(testComputer.getId());
		assertEquals(testComputer.getId(), 1);
	}

	@Test
	public void getNameTest() {
		assertNotNull(testComputer.getName());
		assertEquals(testComputer.getName(), "Legion");
	}

	@Test
	public void getIpAddressTest() {
		assertNotNull(testComputer.getIpAddress());
		assertEquals(testComputer.getIpAddress(), "192.168.0.123");
	}
	
	@Test
	public void getServicesTest() {
		assertNotNull(testComputer.getServices());
		assertEquals(testComputer.getServices(), "Nothing");
	}
	
	@Test
	public void getOperatingSystemTest() {
		assertNotNull(testComputer.getOperatingSystem());
		assertEquals(testComputer.getOperatingSystem(), "Debian");
	}
	
	@Test
	public void setIdTest() {
		testComputer.setId(1337);
		assertNotNull(testComputer.getId());
		assertNotEquals(testComputer.getId(), 1);
		assertEquals(testComputer.getId(), 1337);
	}

	@Test
	public void setNameTest() {
		testComputer.setName("Batman");
		assertNotNull(testComputer.getName());
		assertNotEquals(testComputer.getName(), "Legion");
		assertEquals(testComputer.getName(), "Batman");
	}

	@Test
	public void setIpAddressTest() {
		testComputer.setIpAddress("127.0.0.1");
		assertNotNull(testComputer.getIpAddress());
		assertNotEquals(testComputer.getIpAddress(), "192.168.0.123");
		assertEquals(testComputer.getIpAddress(), "127.0.0.1");
	}
	
	@Test
	public void setServicesTest() {
		testComputer.setServices("Justice");
		assertNotNull(testComputer.getServices());
		assertNotEquals(testComputer.getServices(), "Nothing");
		assertEquals(testComputer.getServices(), "Justice");
	}
	
	@Test
	public void setOperatingSystemTest() {
		testComputer.setOperatingSystem("BatOS");
		assertNotNull(testComputer.getOperatingSystem());
		assertNotEquals(testComputer.getOperatingSystem(), "Debian");
		assertEquals(testComputer.getOperatingSystem(), "BatOS");
	}
}
