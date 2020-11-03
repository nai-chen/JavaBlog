package com.blog.demo.design.state;

public class PrepareState implements State {
	private MediaPlayer mediaPlayer;
	
	public PrepareState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void start() {
		System.out.println("��ʼ������Ƶ");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void pause() {
		System.out.println("��Ƶ��û��ʼ����");
	}
	
	@Override
	public void play() {
		System.out.println("��Ƶ��û��ʼ����");		
	}

	@Override
	public void stop() {
		System.out.println("��Ƶ��û��ʼ����");
	}
	
}
