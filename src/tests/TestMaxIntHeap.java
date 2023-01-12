package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import bin_packing.*;

class TestMaxIntHeap {
	private MaxIntHeap<Disk> h = new MaxIntHeap<Disk>(10);

	@BeforeAll
	public static void setUp() {
		System.out.println("[Running MaxIntHeap Tests]");
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("[Successfully ran MaxIntHeap Tests]");
	}

	@Test
	public void test_constructor() {
		System.out.println("constructor");
		MaxIntHeap<Disk> temp = new MaxIntHeap<Disk>(2);
		assertTrue(temp.getCapacity() == 2);
		temp.insert(new Disk());
		temp.insert(new Disk());
		temp.insert(new Disk());
		assertTrue(temp.getCapacity() == 4);
	}

	@Test
	public void test_is_empty() {
		System.out.println("isEmpty");
		assertTrue(h.isEmpty());
	}

	@Test
	public void test_is_empty_2() {
		System.out.println("isEmpty");
		h.insert(new Disk());
		assertFalse(h.isEmpty());
	}

	@Test
	public void test_insert() {
		System.out.println("insert");
		h.insert(new Disk());
		h.insert(new Disk());
		assertTrue(h.getSize() == 2);
		h.insert(new Disk());
		h.insert(new Disk());
		assertTrue(h.getSize() == 4);
	}

	@Test
	public void test_get_max() {
		System.out.println("peek");
		Disk d1 = new Disk();
		d1.insertFolder(500);
		Disk d2 = new Disk();
		d2.insertFolder(300);
		h.insert(d1);
		assertTrue(h.peek().getAvailableMemory() == 999500);
		h.insert(d2);
		assertTrue(h.peek().getAvailableMemory() == 999700);
	}

	@Test
	public void test_peek_exception() {
		System.out.println("peek");
		assertThrows(NoSuchElementException.class, () -> h.peek());
	}

	@Test
	public void test_delete_max() {
		System.out.println("deleteMax");
		Disk d1 = new Disk();
		d1.insertFolder(500);
		Disk d2 = new Disk();
		d2.insertFolder(300);
		h.insert(d1);
		h.insert(d2);
		assertTrue(h.deleteMax().getAvailableMemory() == 999700);
		assertTrue(h.deleteMax().getAvailableMemory() == 999500);
	}

	@Test
	public void test_deleteMax_exception() {
		System.out.println("deleteMax");
		assertThrows(NoSuchElementException.class, () -> h.deleteMax());
	}
}
