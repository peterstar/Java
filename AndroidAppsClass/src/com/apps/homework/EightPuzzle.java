package com.apps.homework;

//import Board;
//import Solver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.apps.R;

public class EightPuzzle extends Fragment {
	private TextView mSelectedTextView;
	private TextView mWorkingTextView;
	private Board b;
	private Solver solver;
	TableLayout tableLayout;

	public interface OnRefreshSelected {
		public void refreshFragment(boolean flag);
	}

	// private OnRefreshSelected onRefreshSelected;
	private AudioPlayer mPlayer = new AudioPlayer();

	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_puzzle, parent, false);
		// int initial_board[][] = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6 }};
		// b = new Board(initial_board);
		b = new Board(Board.generate_board());
		mSelectedTextView = (TextView) v
				.findViewById(R.id.fragment_puzzle_textView1);
		mWorkingTextView = (TextView) v
				.findViewById(R.id.fragment_puzzle_textView2);
		OnClickListener puzzleButtonListener = new PuzzleButtonListener();
		tableLayout = (TableLayout) v
				.findViewById(R.id.fragment_puzzle_tableLayout);
		Button restart = (Button) v.findViewById(R.id.play_again_button);
		restart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				b = new Board(Board.generate_board());
				updateBoard(0, 0, false);
			}
		});
		Button sendSolutionButton = (Button) v
				.findViewById(R.id.send_solution_button);
		sendSolutionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri
						.fromParts("mailto", "", null));
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, "8 Puzzle solution");
				Solver solver = new Solver(b);

				String body = "";
				// print solution to standard output
				if (!solver.isSolvable()) {
					body = "No solution possible";
				} else {
					body = "Minimum number of moves = " + solver.moves() + "\n";
					for (Board board : solver.solution())
						body += board.toString() + "\n";
				}

				emailIntent.putExtra(Intent.EXTRA_TEXT, body);
				startActivity(Intent
						.createChooser(emailIntent, "Send email..."));
			}
		});
		Button quit = (Button) v.findViewById(R.id.quit_button);
		quit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().finish();
			}
		});
		for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
			TableRow row = (TableRow) tableLayout.getChildAt(i);
			for (int j = 0; j < row.getChildCount(); j++) {
				Button button = (Button) row.getChildAt(j);
				button.setOnClickListener(puzzleButtonListener);
				button.setOnTouchListener(new View.OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						return false;
					}
				});
			}
		}
		updateBoard(0, 0, false);
		return v;
	}

	protected void updateBoard(int r, int c, boolean needAnimation) {
		// TableLayout tableLayout = (TableLayout)
		// v.findViewById(R.id.fragment_puzzle_tableLayout);
		for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
			TableRow row = (TableRow) tableLayout.getChildAt(i);
			for (int j = 0; j < row.getChildCount(); j++) {
				Button button = (Button) row.getChildAt(j);
				int val = b.get(i - 2, j); /* If val is zero -- Text is empty */
				if ((i - 2 == r) && (j == c) && (needAnimation == true)) {
					// Animation anim =
					// AnimationUtils.makeOutAnimation(getActivity(), true);
					// button.startAnimation(anim);
				}
				String text = (val == 0) ? "" : "" + val;
				if (text.equals("")) {
					button.setVisibility(View.INVISIBLE);
				} else {
					button.setVisibility(View.VISIBLE);
				}
				button.setText(text);
				/*
				 * Tag is for identifying a button: For example button 00 has
				 * tag 00, Button 21 has tag 21 etc
				 */
				button.setTag(String.valueOf(i - 2) + String.valueOf(j));
			}
		}
	}

	class PuzzleButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			int i = Integer.valueOf(((String) v.getTag()).substring(0, 1));
			int j = Integer.valueOf(((String) v.getTag()).substring(1));
			TextView textView = (TextView) v;
			String text = textView.getText().toString();
			mWorkingTextView.setText(text);
			if (b.move(i, j) == true) {
				updateBoard(i, j, true);
				if (b.isGoal()) {
					mWorkingTextView.setText("SOLVED!");
					mPlayer.play(getActivity(), R.raw.applause);
				}
			}
		}
	};
}