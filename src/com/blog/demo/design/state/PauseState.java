package com.blog.demo.design.state;

public class PauseState implements State {
	private MediaPlayer mediaPlayer;
	
	public PauseState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
	public void start() {
		System.out.println("��Ƶ�Ѿ���ʼ������");
	}

	@Override
	public void pause() {		
		System.out.println("��Ƶ��ͣ�У���Ч����");
	}
	
	@Override
	public void play() {
		System.out.println("��Ƶ����");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void stop() {
		System.out.println("��Ƶ��������");
		mediaPlayer.setState(mediaPlayer.stopState);
	}

}
