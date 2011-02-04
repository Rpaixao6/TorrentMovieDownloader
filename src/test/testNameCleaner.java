package test;

import cleaner.NameCleaner;

public class testNameCleaner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] names = {
				"Faster DVDRip 2010 XviD-ARROW",
				"Due Date BDRip XviD-ARROW",
				"The.Green.Hornet.2010.TS.XViD-T0XiC-iNK",
				"Inception (2010) DVDRip XviD-MAX",
				"Tangled 2010 PPVRip LiNE XviD-TiMPE",
				"The Tourist[2010]R5 Line XviD-ExtraTorrentRG",
				"The Kings.Speech.2010.DVDSCR.XviD.AC3-NYDIC",
				"127.Hours.2010.DVDSCR.AC3.XViD-T0XiC-iNK",
				"The.Mechanic.2011.TS.XViD-T0XiC-iNK",
				"Black.Swan.2010.DVDSCR.XviD-TiMKY",
				"Megamind (2010) SCR XViD AC3 - IMAGiNE",
				"The Social Network 2010 DVDSCR XViD-WBZ",
				"Unstoppable (2010) DVDRip",
				"Despicable Me DVDRip XviD-iMBT",
				"The Fighter 2010 SCR XViD - IMAGiNE",
				"TRON Legacy 2010 TS XViD - IMAGiNE(READ NOTES)",
				"Little Fockers TS XViD v2 - IMAGiNE(READ NOTES)",
				"Machete.R5.LINE.XviD-TWiZTED",
				"Machete (2010) R5 XviD-MAX",
				"Machete R5 (2010)  XviD-MAX",
				"Machete-_-R5-_-[2010]-_-Xvid-Max",
				"Machete-_-R5-_-{2010}-_-Xvid-Max",
				"Machete-_-R5-_-Xvid-Max",
				"Manchete.R5.2010.Xvid.Max"
		};
		
			for(int i = 0 ; i != names.length;i++){
			NameCleaner nc = new NameCleaner();
			nc.clean(names[i], false);
			System.out.println("------------------------------------------------");
			System.out.println("Ficheiro: "+names[i]);
			System.out.println("Name: "+nc.name);
			System.out.println("Release Quality: "+nc.releaseQuality);
			System.out.println("Year: "+nc.year);
			System.out.println("-------terminou--------------------------------\n\n");
			}
	}

}
