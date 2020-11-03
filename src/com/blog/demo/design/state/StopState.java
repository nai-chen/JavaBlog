package com.blog.demo.design.state;

public class StopState implements State {
	private MediaPlayer mediaPlayer;
	
	public StopState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void start() {
		System.out.println("视频已经开始播放了");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void pause() {
		System.out.println("视频已经停止播放了");
	}
	
	@Override
	public void play() {
		System.out.println("视频已经停止播放了");		
	}

	@Override
	public void stop() {
		System.out.println("视频停止播放中，无效操作");		
	}

}
