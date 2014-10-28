package nu.fulkod.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import nu.fulkod.computer.service.IComputerService;
import nu.fulkod.model.Computer;

import org.primefaces.event.FlowEvent;
import org.springframework.dao.DataAccessException;

@ManagedBean(name="computerMB")
@ViewScoped
public class ComputerMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@ManagedProperty(value="#{ComputerService}")
	IComputerService computerService;
	
	List<Computer> computerList = null;

	private int id;
	private String name;
	private String services;
	private String ipAddress;
	private String operatingSystem;
	
	public String addComputer(){
		try {
			Computer computer = new Computer();
			computer.setId(getId());
			computer.setName(getName());
			computer.setServices(getServices());
			computer.setIpAddress(getIpAddress());
			computer.setOperatingSystem(getOperatingSystem());
			getComputerService().addComputer(computer);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public List<Computer> getComputerList() {
		if (computerList == null) {
			computerList = new ArrayList<Computer>();
			computerList.addAll(getComputerService().getComputers());
		}
		return computerList;
	}

	public ComputerMBean() {

	}

	@PostConstruct
	public void init() {
		computerList = getComputerList();
	}

	public int getId() {
		return id;
	}

	public IComputerService getComputerService() {
		return computerService;
	}

	public void setComputerService(IComputerService computerService) {
		this.computerService = computerService;
	}

	public void setComputerList(List<Computer> computerList) {
		this.computerList = computerList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}
}
