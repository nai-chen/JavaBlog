package com.blog.demo.design.state;

public class PauseState implements State {
	private MediaPlayer mediaPlayer;
	
	public PauseState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
	@Override
	public void start() {
		System.out.println("视频已经开始播放了");
	}

	@Override
	public void pause() {		
		System.out.println("视频暂停中，无效操作");
	}
	
	@Override
	public void play() {
		System.out.println("视频播放");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void stop() {
		System.out.println("视频结束播放");
		mediaPlayer.setState(mediaPlayer.stopState);
	}

}
