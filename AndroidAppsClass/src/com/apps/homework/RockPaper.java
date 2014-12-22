package com.apps.homework;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import java.util.Random;

public class RockPaper extends Activity {

	private TextView tvRoundResult;
	private TextView tvScore;
	private ImageView ivAiChoose;
	private ImageView ivMyChoose;
	private TextView tvVS;

	private Context context;

	int myScore = 0;
	int aiScore = 0;

	enum Choose {
		rock, paper, scissors
	};

	enum Result {
		win, draw, loose
	};

	MediaPlayer _player;
	private SharedPreferences _prefs;
	private boolean _isMusicOn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getApplicationContext();

		tvRoundResult = (TextView) findViewById(R.id.tvRoundResult);
		ivAiChoose = (ImageView) findViewById(R.id.ivAiDecision);
		ivMyChoose = (ImageView) findViewById(R.id.ivMyDecision);
		tvVS = (TextView) findViewById(R.id.tvVS);

		tvScore = (TextView) findViewById(R.id.tvScore);
		SetTextScore();

		_prefs = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());

		_isMusicOn = _prefs.getBoolean(Constans.OPTIONS_SOUND, true);
		if (_isMusicOn) {
			_player = MediaPlayer.create(this, R.raw.sound);
			_player.start();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onPause() {
		super.onPause();

		if (_isMusicOn) {
			_player.stop();
		}

		int myBestScore = _prefs.getInt(Constans.MY_BEST_SCORE, 0);
		int aiBestScore = _prefs.getInt(Constans.AI_BEST_SCORE, 0);

		if ((myScore - aiScore) > (myBestScore - aiBestScore)) {
			Toast.makeText(
					getApplicationContext(),
					"Congratulations! You made record!\nYour score is "
							+ myScore + ": " + aiScore, Toast.LENGTH_SHORT)
					.show();
			Editor editor = _prefs.edit();
			editor.putInt(Constans.AI_BEST_SCORE, aiScore);
			editor.putInt(Constans.MY_BEST_SCORE, myScore);
			editor.commit();
		} else {
			Toast.makeText(getApplicationContext(),
					"Your score is " + myScore + ": " + aiScore,
					Toast.LENGTH_SHORT).show();
		}
	}

	public void PaperOnClick(View v) {
		SetAllStatement(Choose.paper);
	}

	public void RockOnClick(View v) {
		SetAllStatement(Choose.rock);
	}

	public void ScissorsOnClick(View v) {
		SetAllStatement(Choose.scissors);
	}

	private void SetAllStatement(Choose myChoose) {
		SetMyChoose(myChoose);
		tvVS.setText(context.getString(R.string.vs));

		Choose aiChoose = GetAiChoose();
		ivAiChoose.setImageResource(ConvertChooseToImg(aiChoose));

		Result roundResult = GetResult(myChoose, aiChoose);
		SetScore(roundResult);
		SetTextScore();

		tvRoundResult.setText(ConvertResultToString(roundResult));
		SetTextColor(roundResult);
	}

	public Choose GetAiChoose() {
		Random randomGenerator = new Random();
		return Choose.values()[randomGenerator.nextInt(99) % 3];
	}

	public Result GetResult(Choose myChoose, Choose aiChoose) {
		switch (aiChoose) {
		case rock:
			if (myChoose == Choose.rock)
				return Result.draw;
			else if (myChoose == Choose.paper)
				return Result.win;
			else
				return Result.loose;
		case paper:
			if (myChoose == Choose.rock)
				return Result.loose;
			else if (myChoose == Choose.paper)
				return Result.draw;
			else
				return Result.win;
		case scissors:
			if (myChoose == Choose.rock)
				return Result.win;
			else if (myChoose == Choose.paper)
				return Result.loose;
			else
				return Result.draw;
		}

		return Result.draw;
	}

	public String ConvertResultToString(Result res) {
		switch (res) {
		case win:
			return context.getString(R.string.win);
		case loose:
			return context.getString(R.string.lose);
		default:
			return context.getString(R.string.draw);

		}
	}

	public int ConvertChooseToImg(Choose choose) {
		switch (choose) {
		case paper:
			return R.drawable.paper;
		case rock:
			return R.drawable.rock;
		case scissors:
			return R.drawable.scissors;
		default:
			return 0;
		}
	}

	public void SetScore(Result res) {
		if (res == Result.win)
			myScore++;
		else if (res == Result.loose) {
			aiScore++;
		}
	}

	public void SetTextScore() {
		tvScore.setText(String.format("%d:%d", myScore, aiScore));
	}

	private void SetMyChoose(Choose choose) {
		ivMyChoose.setImageResource(ConvertChooseToImg(choose));
	}

	private void SetTextColor(Result res) {
		switch (res) {
		case win:
			tvRoundResult.setTextColor(Color.GREEN);
			break;
		case loose:
			tvRoundResult.setTextColor(Color.RED);
			break;
		case draw:
			tvRoundResult.setTextColor(Color.BLUE);
			break;
		}
	}

}