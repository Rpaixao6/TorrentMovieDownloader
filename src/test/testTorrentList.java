package test;

import java.io.File;
import java.util.LinkedList;

import torrent.Torrent;
import torrent.TorrentIO;

public class testTorrentList {
	
	public static void main(String args[]){
		new testTorrentList().test();
	}

	private void test() {
		// TODO Auto-generated method stub
		TorrentIO tIO = new TorrentIO();
		LinkedList<Torrent> tList = tIO.getList(new File("201.xml"));
		
		for (int i=0;i!=tList.size();i++){
		System.out.println("Torrent in list number "+i+" url:"+tList.get(i).getURL());
		}
	}
}
