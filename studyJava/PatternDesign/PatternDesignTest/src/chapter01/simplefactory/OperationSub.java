package chapter01.simplefactory;

public class OperationSub extends Operation {

	@Override
	public double getResult() {

		double numberA = super.get_numberA();
		double numberB = super.get_numberB();
		return numberA - numberB;
	}

}