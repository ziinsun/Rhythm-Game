package dynamic_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread { // 게임을 하나의 단위로 진행하게 하는 ,,어쩌구
//	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}

	public void screenDraw(Graphics2D g) {

		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null); // 노트 판정 라인
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY()>620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		} // 객체지향 클래스화

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// 안티에이징 적용 -> 글자 깨짐 방지
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SPACE BAR", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setFont(new Font("D2coding", Font.BOLD, 30));
		g.drawString("0000000", 565, 702);
		g.drawImage(blueFlareImage, 500, 430, null);
		g.drawImage(judgeImage,455,420,null);

	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		// 한 번 눌렀을때 반복하지 않도록 false를 넣어줌
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("Easy")) {
			int startTime = 4460-Main.REACT_TIME*1000;
			int gap=125;
			beats = new Beat[] {
					new Beat(startTime + gap *1,"S"),
					new Beat(startTime + gap *3,"D"),
					new Beat(startTime + gap *5,"S"),
					new Beat(startTime + gap *7,"D"),
					new Beat(startTime + gap *9,"S"),
					new Beat(startTime + gap *11,"D"),
					new Beat(startTime + gap *13,"S"),
					new Beat(startTime + gap *15,"D"),
					new Beat(startTime + gap *18,"J"),
					new Beat(startTime + gap *20,"K"),
					new Beat(startTime + gap *22,"J"),
					new Beat(startTime + gap *24,"K"),
					new Beat(startTime + gap *26,"J"),
					new Beat(startTime + gap *28,"K"),
					new Beat(startTime + gap *30,"J"),
					new Beat(startTime + gap *32,"K"),
					new Beat(startTime + gap *35,"S"),
					new Beat(startTime + gap *37,"D"),
					new Beat(startTime + gap *39,"S"),
					new Beat(startTime + gap *41,"D"),
					new Beat(startTime + gap *43,"S"),
					new Beat(startTime + gap *45,"D"),
					new Beat(startTime + gap *48,"J"),
					new Beat(startTime + gap *49,"K"),
					new Beat(startTime + gap *50,"L"),
					new Beat(startTime + gap *52,"F"),
					new Beat(startTime + gap *52,"Space"),
					new Beat(startTime + gap *52,"J"),
					new Beat(startTime + gap *54,"S"),
					new Beat(startTime + gap *56,"D"),
					new Beat(startTime + gap *59,"F"),
					new Beat(startTime + gap *59,"Space"),
					new Beat(startTime + gap *59,"J"),
					new Beat(startTime + gap *61,"L"),
					new Beat(startTime + gap *63,"K"),
					new Beat(startTime + gap *65,"F"),
					new Beat(startTime + gap *65,"Space"),
					new Beat(startTime + gap *65,"J"),
					new Beat(startTime + gap *70,"S"),
					new Beat(startTime + gap *72,"S"),
					new Beat(startTime + gap *74,"S"),
					new Beat(startTime + gap *78,"J"),
					new Beat(startTime + gap *79,"K"),
					new Beat(startTime + gap *80,"L"),
					new Beat(startTime + gap *83,"Space"),
					new Beat(startTime + gap *85,"S"),
					new Beat(startTime + gap *87,"D"),
					new Beat(startTime + gap *89,"S"),
					new Beat(startTime + gap *91,"D"),
					new Beat(startTime + gap *93,"F"),
					new Beat(startTime + gap *96,"Space"),
					new Beat(startTime + gap *98,"L"),
					new Beat(startTime + gap *100,"Space"),
					new Beat(startTime + gap *102,"S"),
					new Beat(startTime + gap *104,"D"),
					new Beat(startTime + gap *106,"Space"),
					new Beat(startTime + gap *109,"Space"),
					new Beat(startTime + gap *112,"Space"),
					new Beat(startTime + gap *118,"Space"),
			};
		}
		else if(titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
		};
		}
		else if(titleName.equals("Joakim Karud - Wild Flower")&& difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
		};
		}else if(titleName.equals("Joakim Karud - Wild Flower")&& difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
		};
		}
		else if(titleName.equals("Bensound - Energy")&& difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
		};
		}
		else if(titleName.equals("Bensound - Energy")&& difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
		};
		}
		int i = 0;
		gameMusic.start();
		while (i<beats.length&&!isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped=true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
			
					e.printStackTrace();
				}
			}
		}
	}
	public void judge(String input) { // queue
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
	}

}
