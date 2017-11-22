package metier;

import java.util.ArrayList;
import java.util.List;

public class OperationModel {
	private	String motCle ;
	private List<Operation> operations=new ArrayList<Operation>();
	public OperationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationModel(List<Operation> operations) {
		super();
		this.operations = operations;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	

}
