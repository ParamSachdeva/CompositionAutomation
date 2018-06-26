package BasicUtilities;
import java.io.IOException;
import autoitx4java.AutoItX;


public class AutoItInbuilt {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Execution Started");
		AutoItX AIdriver = new AutoItX();

		AIdriver.run("calc.exe");
		AIdriver.winActivate("Calculator");
		AIdriver.winWaitActive("Calculator");
		//Enter 3
		AIdriver.controlClick("Calculator", "", "133") ;
		Thread.sleep(1000);
		//Enter +
		AIdriver.controlClick("Calculator", "", "93") ;
		Thread.sleep(1000);
		//Enter 3
		AIdriver.controlClick("Calculator", "", "133") ;
		Thread.sleep(1000);
		//Enter =
		AIdriver.controlClick("Calculator", "", "121") ;
		AIdriver.winClose("Calculator");
	}
}