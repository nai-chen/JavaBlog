package com.blog.demo.design.state;

public class StopState implements State {
	private MediaPlayer mediaPlayer;
	
	public StopState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void start() {
		System.out.println("��Ƶ�Ѿ���ʼ������");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void pause() {
		System.out.println("��Ƶ�Ѿ�ֹͣ������");
	}
	
	@Override
	public void play() {
		System.out.println("��Ƶ�Ѿ�ֹͣ������");		
	}

	@Override
	public void stop() {
		System.out.println("��Ƶֹͣ�����У���Ч����");		
	}

}
