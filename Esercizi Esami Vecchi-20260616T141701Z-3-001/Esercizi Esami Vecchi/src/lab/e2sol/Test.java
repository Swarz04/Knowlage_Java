package lab.e2sol;

import static org.junit.Assert.*;

/*
 * Implementare l'interfaccia TodayTasks fornita che modella i task da eseguire in una giornata,
 * con una classe TodayTaskImpl con costruttore vuoto e nessun task presente inizialmente.
 * Si assuma una giornata che va dalle 8:00 alle 19:00, e che un task cominci ad un ora precisa 
 * (8:00, 9:00,.. fino alle 18:00) e possa durare un numero intero di ore (concludendosi però 
 * al massimo alle 19:00). 
 * L'implementazione soddisfi i seguenti test (da scommentare) 
 */

public class Test {
	
	@org.junit.Test
	public void test() throws Exception{
		TodayTasks tt = new TodayTasksImpl(); 
		tt.addTask(8,1,"Colazione");
		tt.addTask(9,3,"Lezione");
		tt.addTask(13,1,"Pranzo");
		tt.addTask(14,3,"Riunione");
		// check ora per ora
		assertEquals(tt.getTaskDescription(8),"Colazione");
		assertEquals(tt.getTaskDescription(9),"Lezione");
		assertEquals(tt.getTaskDescription(10),"Lezione");
		assertEquals(tt.getTaskDescription(11),"Lezione");
		assertNull(tt.getTaskDescription(12));
		assertEquals(tt.getTaskDescription(13),"Pranzo");
		assertEquals(tt.getTaskDescription(14),"Riunione");
		assertEquals(tt.getTaskDescription(15),"Riunione");
		assertEquals(tt.getTaskDescription(16),"Riunione");
		assertNull(tt.getTaskDescription(17));
		assertNull(tt.getTaskDescription(18));
		assertFalse(tt.addTask(12,2,"Pausa")); // deve dare false
		assertNull(tt.getTaskDescription(12)); // quindi l'istruzione sopra non deve avere effetto
			
	}
	
	@org.junit.Test
	public void test2() throws Exception{
		// casi che devono generare eccezione
		TodayTasks tt = new TodayTasksImpl();
		try { 
			tt.addTask(8,2,null);
			fail("Cannot accept null descriptions");
		} catch (Exception e) {}
		try { 
			tt.addTask(18,2,"Aperitivo");
			fail("Cannot work after 19:00");
		} catch (Exception e) {}
		assertNull(tt.getTaskDescription(18));
		tt.addTask(9,3,"Lezione");
	}

	
}
