package walk;

public class DubStep {
	public static void main(String[] arts) {

		System.out.println(SongDecoder("WUBWUBABCWUB"));
		System.out.println(SongDecoder("RWUBWUBWUBWUBWUBWUBWUBLWUBWUB[WUBXWUBVWUB]WUBX"));
	}

	public static String SongDecoder(String song) {
		String s = song;
		while (s.contains("WUB")) {
			s = s.replaceFirst("WUB", " ");
		}

		s = s.trim();

		while(s.contains("  ")){
			s = s.replaceFirst("  ", " ");
		}
		
		System.out.println(s);
		s = s.replaceAll("%col%", "");
		return s;
	}

}
