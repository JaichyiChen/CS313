import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hw4 {
	static SinglyLinkedList<Name> p = new SinglyLinkedList<Name>();
	static SinglyLinkedList<Name> sorted = new SinglyLinkedList<Name>();

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		String y, gen, eth, name, count;
		boolean done = false;
		while (!done) {
			System.out.print("Year of Birth(2011-2017, yyyy): ");
			Scanner in = new Scanner(System.in);
			int year = in.nextInt();

			System.out.print("Gender(boy/girl): ");
			in = new Scanner(System.in);
			String gender = in.nextLine();

			System.out.print("Ethnicity(asian/black/hispanic/white): ");
			in = new Scanner(System.in);
			String ethnicity = in.nextLine();
			// closing scanner
			//in.close();
			Scanner sc = new Scanner(new File("D:/Popular_Baby_Names.csv")); // Remember to change the file path
			while (sc.hasNext()) {
				String skip = sc.nextLine();
				String line = sc.nextLine();
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					y = st.nextToken();
					gen = st.nextToken();
					eth = st.nextToken();
					name = st.nextToken();
					count = st.nextToken();
					int countnum = Integer.valueOf(count);
					Name person = new Name(y, gen, eth, name, countnum);
					Node<Name> unsorted = new Node<Name>(person, null);
					p.addFirst((unsorted.getData()));
				}
			}
			sort();
			System.out.println("Popular baby " + gender + " names in " + ethnicity + " in " + year + ":");
			//add code to print out the popular baby names by year of birth, gender and ethnic group
			String boy = "boy";
			Node<Name> curr = sorted.head;
			while(curr.getNext()!=null) {
				int years = Integer.valueOf(curr.getData().getYear());
				if(gender.equalsIgnoreCase(boy)) {
					gender = "male";
				}
				else {
					gender = "female";
				}
				if(curr.getData().getGender().toLowerCase().contains(gender) && curr.getData().getEthnicity().toLowerCase().contains(ethnicity) && years==year) {
					System.out.println(curr.getData());
				}
					curr = curr.getNext();
			}
			System.out.print("Interested in more(yes/no): ");
			in = new Scanner(System.in);
			String more = in.nextLine();
			if (more.equalsIgnoreCase("no")) {
				in.close();
				done = true;
			}
		}
	}
	
	private static void sort() {
		while (p.head != null) {
			Node<Name> preMin = null;
			Node<Name> curr = p.head;
			int minVal = curr.getData().getCount();
			Node<Name> minNode = curr;
			Node<Name> next = null;
			while (curr.getNext() != null) {
				next = curr.getNext();
				if (minVal > next.getData().getCount()) {
					preMin = curr;
					minVal = next.getData().getCount();
					minNode = next;
				}
				
				curr = curr.getNext();
			}
			sorted.addFirst(minNode.getData());
			System.out.println(" ");
			if (preMin == null)

				p.removeFirst();
			else {
				preMin.setNext(minNode.getNext());
			}

		}
	
	}
}