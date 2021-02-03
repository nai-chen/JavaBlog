package com.blog.demo.design.state;

public class PrepareState implements State {
	private MediaPlayer mediaPlayer;
	
	public PrepareState(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void start() {
		System.out.println("开始播放视频");
		mediaPlayer.setState(mediaPlayer.playState);
	}

	@Override
	public void pause() {
		System.out.println("视频还没开始播放");
	}
	
	@Override
	public void play() {
		System.out.println("视频还没开始播放");		
	}

	@Override
	public void stop() {
		System.out.println("视频还没开始播放");
	}
	
}
