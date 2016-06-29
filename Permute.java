import java.util.*;

public class Permute
{
	public static void testA(ArrayList<String> res)
	{
		// a should just have 1 element with "a"
		assert(res.get(0).equals("a"));
		System.out.println("A passed with: " + res.get(0));
	}

	public static void testB(ArrayList<String> res)
	{
		// ab and ba
		assert(res.get(0).equals("ab"));
		assert(res.get(1).equals("ba"));
		System.out.println("B passed with: " + res.get(0) + " " + res.get(1));
	}

	public static void testC(ArrayList<String> res)
	{
		assert(res.get(0).equals(""));
		System.out.println("C passed with: " + res.get(0));
	}

	public static void testD(ArrayList<String> res)
	{
		assert(res.get(0).equals("dog"));
		assert(res.get(1).equals("dgo"));
		assert(res.get(2).equals("odg"));
		assert(res.get(3).equals("ogd"));
		assert(res.get(4).equals("god"));
		assert(res.get(5).equals("gdo"));
		System.out.print("D passed with: "); 
		for (int i = 0; i < res.size(); i++)
		{
			System.out.print(res.get(i) + " ");
		}
		System.out.println();
	}


	public static void main(String[] args)
	{
		// test cases
		String a = "a";
		String b = "ab";
		String c = "";
		String d = "dog";
		ArrayList<String> result = new ArrayList<String>();

		permute(result, a, 0, a.length());
		testA(result);
		result.clear();

		permute(result, b, 0, b.length());
		testB(result);
		result.clear();

		permute(result, c, 0, c.length());
		testC(result);
		result.clear();

		permute(result, d, 0, d.length());
		testD(result);
		result.clear();
	}

	public static String swap(String s, int i, int j)
	{
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(i, s.charAt(j));
		sb.setCharAt(j, s.charAt(i));
		return sb.toString();
	}

	public static void permute(ArrayList<String> list, String str, int l, int r)
	{
		// base case
		if (l >= r-1)
		{
			list.add(str);	
		}
		else 
		{
			for (int i = l; i < r; i++)
			{
				String permutation = swap(str, i, l);
				permute(list, permutation, l+1, r);
			}
		}
	}
}
