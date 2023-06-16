package useCase;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class EfeitosSonorosEMusicas {
	
	public static Clip cena1, cena2, cena3, disparo, alinMorreu, pegarMunicao, recarregou, armaVazia, boss, cenaPerdido, somRazor, cena4, bossMorto;
	
	public static void efeitoSonoroAlienAbatido(String nomeArquivo) {
		try {
			File file = new File(nomeArquivo);
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			  alinMorreu = AudioSystem.getClip();
			  alinMorreu.open(audioStream);
			  alinMorreu.start();
			  alinMorreu.setMicrosecondPosition(0);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
	
	public static void efeitoSonoroTiro() {
		try {
		File file = new File("Sound-Effect-Glock-17-pronto.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  disparo = AudioSystem.getClip();
		  disparo.open(audioStream);
		  disparo.start();
		  disparo.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	public static void efeitoSonoroPegouMunicao() {
		try {
		File file = new File("Item-Pick-up.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  pegarMunicao = AudioSystem.getClip();
		  pegarMunicao.open(audioStream);
		  pegarMunicao.start();
		  pegarMunicao.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void efeitoSonoroRecarregou() {
		try {
		File file = new File("Revolver-Reload-Sound-Effects.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  recarregou = AudioSystem.getClip();
		  recarregou.open(audioStream);
		  recarregou.start();
		  recarregou.setMicrosecondPosition(0);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
		public static void efeitoSonoroPenteVazio() {
			try {
			File file = new File("Empty gun shot.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			  armaVazia = AudioSystem.getClip();
			  armaVazia.open(audioStream);
			  armaVazia.start();
			  armaVazia.setMicrosecondPosition(0);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
		
		public static void efeitoSonoroBossDerrotado() {
			try {
			File file = new File("Demon_s-Crest-OST_-A-Treasure-Recovered.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			  bossMorto = AudioSystem.getClip();
			  bossMorto.open(audioStream);
			  bossMorto.start();
			  bossMorto.setMicrosecondPosition(0);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
		
		public static void efeitoSonoroRazorClaw() {
			try {
			File file = new File("alien_breathing_steady_01.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			  somRazor = AudioSystem.getClip();
			  somRazor.open(audioStream);
			  FloatControl gainControl = (FloatControl) somRazor.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(-3.0f);
			  somRazor.loop(-1);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
		public static void efeitoSonoroRazorClawParar() {
				somRazor.stop();
	}
		
		public static void musicaJogoPerdido() {
			try {
				 File fileAudio = new File("Demon_s-Crest-OST_-Challenge-of-Devils-_Intro.wav");
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
				  cenaPerdido = AudioSystem.getClip();
				  cenaPerdido.open(audioStream);
				  cenaPerdido.loop(-1);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
		}
	public static void musicaCena1() {
		try {
			 File fileAudio = new File("Alien-vs-Predator-City-.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  cena1 = AudioSystem.getClip();
			  cena1.open(audioStream);
			  cena1.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaCena1() {
			 cena1.stop();
	}
	
	public static void musicaCena2() {
		try {
			 File fileAudio = new File("Demon_s-Crest-OST_-Metropolis-of-Ruin-.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  cena2 = AudioSystem.getClip();
			  cena2.open(audioStream);
			  cena2.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaCena2() {
		 cena2.stop();
}
	
	public static void musicaCena3() {
		try {
			 File fileAudio = new File("Alien-vs-Predator-Space-Port.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  cena3 = AudioSystem.getClip();
			  cena3.open(audioStream);
			  FloatControl gainControl = (FloatControl) cena3.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(+6.0f);
			  cena3.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaCena3() {
		 cena3.stop();
}
	
	public static void musicaCena4() {
		try {
			 File fileAudio = new File("Castlevania-Dracula-X-OST-Picture-of-the-Ghost-Ship.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  cena4 = AudioSystem.getClip();
			  cena4.open(audioStream);
			  FloatControl gainControl = (FloatControl) cena4.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(+6.0f);
			  cena4.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaCena4() {
		 cena4.stop();
}
	public static void musicaBoss() {
		try {
			 File fileAudio = new File("08-Battle-Alien-vs.-Predator-OST-SNES.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  boss = AudioSystem.getClip();
			  boss.open(audioStream);
			  FloatControl gainControl = (FloatControl) boss.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(+6.0f);
			  boss.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaBoss() {
		 boss.stop();
}

}
