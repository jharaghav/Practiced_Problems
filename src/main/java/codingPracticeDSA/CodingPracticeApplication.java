package codingPracticeDSA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingPracticeApplication.class, args);

		System.out.println("square value "+ fastSquare(2,4));
	}

	private static int fastSquare(int a, int b)
	{
		int res = 1;

		while(b > 0)
		{
			if((b&1) != 0)
				res = res * a;
			a = a * a;
			b = b>>1;
		}


		return res;
	}

}
