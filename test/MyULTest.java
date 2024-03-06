import static org.junit.Assert.*;

import org.junit.Test;

public class MyULTest {
	//Coverage MyUnsortedList.java : 99,3%

		@Test
		public void testOf() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			assertTrue("new list", list.isEmpty());
		}
		
		@Test
		public void testSizeEmpty() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			assertEquals("new list size must be 0", 0, list.size());
		}
		
		@Test
		public void testSizeOneAdd() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			list.append(123);
			assertEquals("list after one add", 1, list.size());
		}
		
		@Test
		public void testSizeFiveAdd() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			list.append(123);
			list.append(6);
			list.append(5);
			list.append(4);
			list.append(3);
			assertEquals("list after four more add", 5, list.size());
		}
		
		@Test
		public void testPrepend() {
			UnsortedList<Integer> list = MyUnsortedList.of(7,8,9);
			list.prepend(6);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(6,7,8,9);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test
		public void testAppend() {
			UnsortedList<Integer> list = MyUnsortedList.of(7,8,9);
			list.append(10);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(7,8,9,10);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		
		@Test
		public void testInsertAtHead() {
			UnsortedList<Integer> list = MyUnsortedList.of(1,3);
			list.insert(0, 0);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(0,1,3);
			assertEquals("comparison between expected and list", expectedList, list);
			
		}
		
		@Test
		public void testInsertBetween() {
			UnsortedList<Integer> list = MyUnsortedList.of(0,1,3);

			list.insert(2, 2);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(0,1,2,3);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void testInsertOutOfBoundsNeg() {
			UnsortedList<Integer> list = MyUnsortedList.of(0,1,2,3);

			list.insert(5, -1);
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void testInsertOutOfBoundsPos() {
			UnsortedList<Integer> list = MyUnsortedList.of(0,1,2,3);

			list.insert(5, 5);
		}
		
		@Test
		public void testPopMultValuesLeft() {
			UnsortedList<Integer> list = MyUnsortedList.of(1,2);
			int elem = list.pop();
			UnsortedList<Integer> expectedList = MyUnsortedList.of(2);
			assertEquals("comparison between elem pop and expected", 1, elem);
			assertEquals("comparison between expected and list", expectedList, list);
			
		}
		
		@Test
		public void testPopOneValueLeft() {
			UnsortedList<Integer> list = MyUnsortedList.of(2);
			int elem = list.pop();
			UnsortedList<Integer> expectedList = MyUnsortedList.of();
			assertEquals("comparison between elem pop and expected", 2, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test(expected = EmptyListException.class)
		public void testPopEmpty() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			
			list.pop(); //should fail
		}
		
		@Test
		public void testPopLastMultValuesLeft() {
			UnsortedList<Integer> list = MyUnsortedList.of(1,2);
			int elem = list.popLast();
			UnsortedList<Integer> expectedList = MyUnsortedList.of(1);
			assertEquals("comparison between elem pop and expected", 2, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test
		public void testPopLastOneValueLeft() {
			UnsortedList<Integer> list = MyUnsortedList.of(1);
			int elem = list.popLast();
			UnsortedList<Integer> expectedList = MyUnsortedList.of();
			assertEquals("comparison between elem pop and expected", 1, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test(expected = EmptyListException.class)
		public void testPopLastEmpty() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			
			list.popLast(); //should fail
		}
		
		@Test
		public void testRemoveAtHead() {
			UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
			int elem = list.remove(0);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(2,3,4);
			assertEquals("comparison between elem pop and expected", 1, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test
		public void testRemoveBetween() {
			UnsortedList<Integer> list = MyUnsortedList.of(2,3,4);
			int elem = list.remove(1);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(2,4);
			assertEquals("comparison between elem pop and expected", 3, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}
		
		@Test
		public void testRemoveLast() {
			UnsortedList<Integer> list = MyUnsortedList.of(2,3,4);
			int elem = list.remove(2);
			UnsortedList<Integer> expectedList = MyUnsortedList.of(2,3);
			assertEquals("comparison between elem pop and expected", 4, elem);
			assertEquals("comparison between expected and list", expectedList, list);
		}

		@Test(expected = IndexOutOfBoundsException.class)
		public void testRemoveOutOfBoundsNeg() {
			UnsortedList<Integer> list = MyUnsortedList.of(2,4);
			
			list.remove(-1); //should fail
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void testRemoveOutOfBoundsPos() {
			UnsortedList<Integer> list = MyUnsortedList.of(2,4);
			
			list.remove(5); //should fail
		}
		
		
		@Test
		public void testIsEmpty() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			assertTrue("new list", list.isEmpty());
			list.append(123);
			assertFalse("list after one add", list.isEmpty());
			list.remove(0);
			assertTrue("list after one add+remove", list.isEmpty());
		}
		
		@Test
		public void testEqualsNewList() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			UnsortedList<Integer> list2 = MyUnsortedList.of();
			assertTrue("new list must be equal", list.equals(list2));

		}
		
		@Test
		public void testEqualsListAndString() {
			UnsortedList<Integer> list = MyUnsortedList.of();
		
			assertFalse("list and string",list.equals("String"));
		}
		
		@Test
		public void testEqualsSameContentAndLen() {
			UnsortedList<Integer> list = MyUnsortedList.of();
			UnsortedList<Integer> list2 = MyUnsortedList.of();
			
			list.append(6);
			list.append(5);
			
			list2.append(6);
			list2.append(5);
			assertTrue("equal after append same content", list.equals(list2));
		}
		
		@Test
		public void testEqualsDiffLen() {
			UnsortedList<Integer> list = MyUnsortedList.of(6,5);
			UnsortedList<Integer> list2 = MyUnsortedList.of(6,5);
			
			list2.append(1);
			assertFalse("not equal after append", list.equals(list2));
		}
		
		@Test
		public void testEqualsDiffContentSameLen() {
			UnsortedList<Integer> list = MyUnsortedList.of(6,5);
			UnsortedList<Integer> list2 = MyUnsortedList.of(6,5,1);
			
			list.append(3);
			assertFalse("not equal after append", list.equals(list2));
		}
		
		@Test
		public void testEqualsPopAll() {
			UnsortedList<Integer> list = MyUnsortedList.of(6,5);
			UnsortedList<Integer> list2 = MyUnsortedList.of(6,5,1);
			
			list.pop();
			list.pop();
			
			list2.pop();
			list2.pop();
			list2.pop();
			assertTrue("equal after remove all", list.equals(list2));
		}
			
		@Test
		public void testToString() {
			UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
			String stringList = list.toString();
			String expected = "MyUnsortedList { size = 4, [1, 2, 3, 4] }";
			assertEquals("comparison string", expected, stringList);
		}

}
