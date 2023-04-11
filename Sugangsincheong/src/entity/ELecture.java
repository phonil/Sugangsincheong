package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class ELecture {

	public Vector<VLecture> getLectures(String fileName) { // Vector<VLecture> 만들어서 반환해야함
		Vector<VLecture> vLectures = new Vector<VLecture>();
		try {
			Scanner scanner = new Scanner(new File("directory/" + fileName));
			while (scanner.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.read(scanner);
				vLectures.add(vLecture);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectures;
	}

	public Vector<VLecture> getLectures(String fileName, int a) { // Vector<VLecture> 만들어서 반환해야함 / a는 구분용..
		Vector<VLecture> vLectures = new Vector<VLecture>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.read(scanner);
				vLectures.add(vLecture);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectures;
	}

}
