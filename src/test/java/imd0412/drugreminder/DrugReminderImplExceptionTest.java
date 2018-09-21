package imd0412.drugreminder;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DrugReminderImplExceptionTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { { "10/09/18 12:30", Frequency.TWELVE_HOURS, 31, IllegalArgumentException.class },
								 { "10/09/18 12:30", Frequency.TWELVE_HOURS, -1, IllegalArgumentException.class },
								 { "10/09/2018 12:30", Frequency.TWELVE_HOURS, 3, IllegalArgumentException.class },
								 { "10/09/18 12:30 ", Frequency.TWELVE_HOURS, 3, IllegalArgumentException.class },
								 { "10-09/18 12:30", Frequency.TWELVE_HOURS, 3, IllegalArgumentException.class },
								 { "10-09-18 12:30", Frequency.TWELVE_HOURS, 5, IllegalArgumentException.class },
								 { "10/09-18 12:30", Frequency.TWELVE_HOURS, 6, IllegalArgumentException.class },
								 { "10/09/18 12h30", Frequency.TWELVE_HOURS, 7, IllegalArgumentException.class },
								 { "10/09/1812:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "10/09/17 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "10/09/02 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "32/09/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "00/09/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "10/00/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "10/09/00 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "31/09/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "31/04/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "31/06/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "31/11/18 12:30", Frequency.TWELVE_HOURS, 11, IllegalArgumentException.class },
								 { "29/02/18 12:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "30/02/20 12:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "30/00/20 12:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "30/13/20 12:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "31/13/20 12:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "01/12/20 24:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "01/12/20 20:60", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "01/12/20 -1:30", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { "01/12/20 14:-2", Frequency.TWELVE_HOURS, 21, IllegalArgumentException.class },
								 { null, Frequency.TWELVE_HOURS, 21, NullPointerException.class },
								 { "29/02/20 12:30", null, 21, NullPointerException.class },
								 { "28/02/19 12:30", Frequency.TWELVE_HOURS, null, NullPointerException.class },});
	}

	@Parameter(0)
	public String startTime;
	@Parameter(1)
	public Frequency frequency;
	@Parameter(2)
	public Integer duration;
	@Parameter(3)
	public Class<? extends Exception> expectedException;
	
	@Test
	public void testList() throws Exception {
		thrown.expect(expectedException);
		new DrugReminderImpl().createReminders(startTime, frequency, duration);
	}

}
