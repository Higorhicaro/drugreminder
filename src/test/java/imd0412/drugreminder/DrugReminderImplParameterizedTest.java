package imd0412.drugreminder;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DrugReminderImplParameterizedTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] { { "10/09/18 12:30", Frequency.TWELVE_HOURS, 7, Arrays.asList("10/09/18 12:30", "11/09/18 00:30", "11/09/18 12:30", "12/09/18 00:30", "12/09/18 12:30", "13/09/18 00:30", "13/09/18 12:30", "14/09/18 00:30", "14/09/18 12:30", "15/09/18 00:30", "15/09/18 12:30", "16/09/18 00:30", "16/09/18 12:30", "17/09/18 00:30") },
								 { "10/09/18 12:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("10/09/18 12:30", "11/09/18 00:30") },
								 { "30/09/18 12:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("30/09/18 12:30", "01/10/18 00:30") },
								 { "30/04/18 12:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("30/04/18 12:30", "01/05/18 00:30") },
								 { "30/06/18 12:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("30/06/18 12:30", "01/07/18 00:30") },
								 { "30/11/18 12:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("30/11/18 12:30", "01/12/18 00:30") },
								 { "10/09/18 06:00", Frequency.SIX_HOURS, 1, Arrays.asList("10/09/18 06:00", "10/09/18 12:00", "10/09/18 18:00", "11/09/18 00:00") },
								 { "28/02/18 12:30", Frequency.SIX_HOURS, 1, Arrays.asList("28/02/18 12:30", "28/02/18 18:30", "01/03/18 00:30", "01/03/18 06:30") },
								 { "28/02/20 12:30", Frequency.EIGHT_HOURS, 2, Arrays.asList("28/02/20 12:30", "28/02/20 20:30", "29/02/20 04:30", "29/02/20 12:30", "29/02/20 20:30", "01/03/20 04:30") },
								 { "10/09/18 12:30", Frequency.TWENTYFOUR_HOURS, 1, Arrays.asList("10/09/18 12:30") },
								 { "30/10/18 12:30", Frequency.TWENTYFOUR_HOURS, 3, Arrays.asList("30/10/18 12:30", "31/10/18 12:30", "01/11/18 12:30") },
								 { "27/10/18 12:30", Frequency.TWENTYFOUR_HOURS, 4, Arrays.asList("27/10/18 12:30", "28/10/18 12:30", "29/10/18 12:30", "30/10/18 12:30") },
								 { "27/02/20 12:30", Frequency.TWENTYFOUR_HOURS, 4, Arrays.asList("27/02/20 12:30", "28/02/20 12:30", "29/02/20 12:30", "01/03/20 12:30") },
								 { "10/09/18 12:30", Frequency.TWENTYFOUR_HOURS, 2, Arrays.asList("10/09/18 12:30", "11/09/18 12:30") },
								 { "31/12/18 12:30", Frequency.EIGHT_HOURS, 1, Arrays.asList("31/12/18 12:30", "31/12/18 20:30", "01/01/19 04:30") },
								 { "28/02/20 12:30", Frequency.EIGHT_HOURS, 2, Arrays.asList("28/02/20 12:30", "28/02/20 20:30", "29/02/20 04:30", "29/02/20 12:30", "29/02/20 20:30", "01/03/20 04:30") },
								 { "11/02/20 12:30", Frequency.EIGHT_HOURS, 1, Arrays.asList("11/02/20 12:30", "11/02/20 20:30", "12/02/20 04:30") },});
	}

	@Parameter(0)
	public String startTime;
	@Parameter(1)
	public Frequency frequency;
	@Parameter(2)
	public Integer duration;
	@Parameter(3)
	public List<String> expectedList;

	@Test
	public void testList() throws Exception {
		List<String> returnedList = new DrugReminderImpl().createReminders(startTime, frequency, duration);
		assertEquals(expectedList, returnedList);
	}

}
