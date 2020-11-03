package com.blog.demo.design.state;

public class MediaPlayer {
	State prepareState;
	State playState;
	State pauseState;
	State stopState;	
	
	private State state;
	
	public MediaPlayer() {
		prepareState = new PrepareState(this);
		playState = new PlayState(this);
		pauseState = new PauseState(this);
		stopState = new StopState(this);
		
		state = prepareState;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void start() {
		state.start();
	}
	
	public void pause() {
		state.pause();
	}
	
	public void play() {
		state.play();
	}
	
	public void stop() {
		state.stop();
	}
	
	public static void main(String[] args) {
		MediaPlayer mediaPlayer = new MediaPlayer();		
		mediaPlayer.start();		
		mediaPlayer.pause();
		mediaPlayer.play();
		mediaPlayer.stop();		
	}
	
}
