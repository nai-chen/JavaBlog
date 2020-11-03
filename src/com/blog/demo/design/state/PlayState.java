package com.blog.demo.design.state;

public class PlayState implements State {
	private MediaPlayer mediaPlayer;
	
	public PlayState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void start() {
		System.out.println("��Ƶ�Ѿ���ʼ������");
	}

	@Override
	public void pause() {
		System.out.println("��Ƶ��ͣ");
		mediaPlayer.setState(mediaPlayer.pauseState);
	}
	
	@Override
	public void play() {
		System.out.println("��Ƶ�����У���Ч����");
	}

	@Override
	public void stop() {
		System.out.println("��Ƶ��������");
		mediaPlayer.setState(mediaPlayer.stopState);
	}

}
