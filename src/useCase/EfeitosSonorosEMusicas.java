package useCase;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class EfeitosSonorosEMusicas {
	
	public static Clip cena1, cena2, cena3, disparo, alienMorreu, royal1, royal2, royalWalking, pegarMunicao, recarregou, armaVazia, boss, cenaPerdido, somRazor, cena4, bossMorto, cena5, somRoyal1;
	
	public static void efeitoSonoroAlienAbatido(String nomeArquivo) {
		try {
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource(nomeArquivo));
			  alienMorreu = AudioSystem.getClip();
			  alienMorreu.open(audioStream);
			  alienMorreu.start();
			  alienMorreu.setMicrosecondPosition(0);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
	
	public static void efeitoSonoroRoyalWalking1() {
		try {
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/royalWalking.wav"));
			  royal1 = AudioSystem.getClip();
			  royal1.open(audioStream);
			  FloatControl gainControl = (FloatControl) royal1.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(+4.0f);
			  royal1.start();
			  royal1.setMicrosecondPosition(0);
		
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
	public static void efeitoSonoroRoyalWalking2() {
		try {
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/royalWalking.wav"));
			  royal2 = AudioSystem.getClip();
			  royal2.open(audioStream);
			  FloatControl gainControl = (FloatControl) royal2.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(+4.0f);
			  royal2.start();
			  royal2.setMicrosecondPosition(0);
		
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
	
	public static void efeitoSonoroRoyalWalkingParar1() {
		if(royal1.isActive()) {
		royal1.stop();
		}
	}
	public static void efeitoSonoroRoyalWalkingParar2() {
		if(royal2.isActive()) {
			royal2.stop();
		}
	}
	
	public static void efeitoSonoroRoyalsIntro() {
		try {
//			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/aln_death_scream_23.wav"));
//			  royal1 = AudioSystem.getClip();
//			  royal1.open(audioStream);
//			  royal1.start();
//			  royal1.setMicrosecondPosition(0);
			  
			  AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/aln_death_scream_26.wav"));
			  royal2 = AudioSystem.getClip();
			  royal2.open(audioStream2);
			  royal2.start();
			  royal2.setMicrosecondPosition(0);
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Sound-Effect-Glock-17-pronto.wav"));
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Item-Pick-up.wav"));
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
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Revolver-Reload-Sound-Effects.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Empty gun shot.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Demon_s-Crest-OST_-A-Treasure-Recovered.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/alien_breathing_steady_01.wav"));
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
		public static void efeitoSonoroGrayRoyalGuard() {
			try {
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/alien_breathing_steady_01.wav"));
			  somRoyal1 = AudioSystem.getClip();
			  somRoyal1.open(audioStream);
			  FloatControl gainControl = (FloatControl) somRoyal1.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(-3.0f);
			  somRoyal1.loop(-1);
			  }catch (UnsupportedAudioFileException ex){
	             ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
	             ea.printStackTrace();       
		}
	}
		public static void efeitoSonoroGrayRoyalGuardParar() {
			somRoyal1.stop();
	}
		
		public static void musicaJogoPerdido() {
			try {
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Demon_s-Crest-OST_-Challenge-of-Devils-_Intro.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Alien-vs-Predator-City-.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Demon_s-Crest-OST_-Metropolis-of-Ruin-.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Alien-vs-Predator-Space-Port.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Castlevania-Dracula-X-OST-Picture-of-the-Ghost-Ship.wav"));
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
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/08-Battle-Alien-vs.-Predator-OST-SNES.wav"));
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

	public static void musicaCena5() {
		try {
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(EfeitosSonorosEMusicas.class.getResource("/musics/Castlevania-Rondo-of-Blood-Music-Bloody-Tears-_Stage-3b.wav"));
			  cena5 = AudioSystem.getClip();
			  cena5.open(audioStream);
			  FloatControl gainControl = (FloatControl) cena5.getControl(FloatControl.Type.MASTER_GAIN);
			  gainControl.setValue(-3.0f);
			  cena5.loop(-1);
		  }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
	
	public static void pararMusicaCena5() {
		cena5.stop();
}
}
