package useCase;

import java.io.IOException;
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream(nomeArquivo));
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Sound-Effect-Glock-17-pronto.wav"));
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Item-Pick-up.wav"));
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Revolver-Reload-Sound-Effects.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Empty gun shot.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Demon_s-Crest-OST_-A-Treasure-Recovered.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/alien_breathing_steady_01.wav"));
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
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Demon_s-Crest-OST_-Challenge-of-Devils-_Intro.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Alien-vs-Predator-City-.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Demon_s-Crest-OST_-Metropolis-of-Ruin-.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Alien-vs-Predator-Space-Port.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/Castlevania-Dracula-X-OST-Picture-of-the-Ghost-Ship.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResourceAsStream("/musics/08-Battle-Alien-vs.-Predator-OST-SNES.wav"));
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
