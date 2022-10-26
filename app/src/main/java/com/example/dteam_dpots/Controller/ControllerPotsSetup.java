package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Model.*;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.dteam_dpots.Beans.*;

import kotlin.random.Random;

import com.example.dteam_dpots.ItemView.*;


public class ControllerPotsSetup extends AppCompatActivity {
    //model db control
    ModelPotsSetup _model = new ModelPotsSetup();

    //data
    public final int[] potNames = new int[]{R.string.POT_NEC_NAME, R.string.POT_LTS_NAME, R.string.POT_EDU_NAME, R.string.POT_PLAY_NAME, R.string.POT_FFA_NAME, R.string.POT_GIVE_NAME};
    public final int[] PotNamesFull = new int[]{R.string.POT_NEC_NAME_FULL, R.string.POT_LTS_NAME_FULL, R.string.POT_EDU_NAME_FULL, R.string.POT_PLAY_NAME_FULL, R.string.POT_FFA_NAME_FULL, R.string.POT_GIVE_NAME_FULL};
    public final int[] potDes = new int[]{R.string.POT_NEC_DESCRIPTION, R.string.POT_LTS_DESCRIPTION, R.string.POT_EDU_DESCRIPTION, R.string.POT_PLAY_DESCRIPTION, R.string.POT_FFA_DESCRIPTION, R.string.POT_GIVE_DESCRIPTION};
    public final int[] potRecommend = new int[]{R.string.POT_NEC_RECOMMENT, R.string.POT_LTS_RECOMMENT, R.string.POT_EDU_RECOMMENT, R.string.POT_PLAY_RECOMMENT, R.string.POT_FFA_RECOMMENT, R.string.POT_GIVE_RECOMMENT};

    private final int FIRST_POT = 0;
    private final int LAST_POT = 5;
    private final int MAX_POT = 6;
    private final int PROGRESS_MAX = 100;
    private final int PROGRESS_MIN = 0;

    //view
    TextView potName;
    TextView PotDescription;
    MySeekBar progressBar;
    ImageButton btnOk;
    ImageButton btnBack;
    public int currentPot = FIRST_POT;
    public boolean recommend_flag = true;

    public ControllerPotsSetup() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pots_setup);

        getItemView();

        progressBar.setMax(PROGRESS_MAX);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.d("Current bot at click", String.valueOf(currentPot));
                    if (currentPot >= FIRST_POT && currentPot < MAX_POT) {
                        currentPot = PotNext(currentPot);
                        if (currentPot == LAST_POT) {
                            progressBar.setProgress(progressBar.getMax());
                            currentPot = PotNext(currentPot);
                        }
                        return;
                    }
                    if (_model.getTotalPercent() != progressBar.getMax()) {
                        Toast.makeText(ControllerPotsSetup.this, "Please fill all pots", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    _model.saveChange();
                    startActivity(new Intent(ControllerPotsSetup.this, ControllerHome.class));
                } catch (Exception e) {
                    Toast.makeText(ControllerPotsSetup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    currentPot = PotBack(currentPot);
                } catch (Exception e) {
                    Toast.makeText(ControllerPotsSetup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int percent = _model.getTotalPercent();
                if (i < percent) {
                    seekBar.setProgress(percent);
                    return;
                }
                if (i > progressBar.getMax()) {
                    seekBar.setProgress(progressBar.getMax());
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (i < progressBar.getMin()) {
                        seekBar.setProgress(progressBar.getMin());
                    }
                } else {
                    if (i < PROGRESS_MIN) {
                        seekBar.setProgress(PROGRESS_MIN);
                    }
                }

                if (i == progressBar.getMax()) {
                    btnOk.setImageResource(R.drawable.ok);
                } else {
                    btnOk.setImageResource(R.drawable.btnnext);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    private void setRecomment(int currentPot) {
        progressBar.setProgress(Integer.parseInt(getString(potRecommend[currentPot])));
    }

    private int PotBack(int currentPot) {
        if (currentPot == FIRST_POT) {
            Intent intent = new Intent(ControllerPotsSetup.this, ControllerIntroApp.class);
            startActivity(intent);
        } else {
            if (currentPot == MAX_POT) {
                currentPot = _model.RemoveAtLast();
            }
            currentPot = _model.RemoveAtLast();
            progressBar.current = currentPot;
            progressBar.setProgress(_model.getTotalPercent());
            potName.setText(potNames[currentPot]);
            PotDescription.setText(potDes[currentPot]);
        }
        return currentPot;

    }

    private int insertPot(int currentPot) {
        int value = progressBar.getProgress() - _model.getTotalPercent();
        if (value < 1) {
            //show message to user least 1%
            Toast.makeText(ControllerPotsSetup.this, "Please fill at least 1% for this pot", Toast.LENGTH_SHORT).show();
            return currentPot; //0-5
        }
        int next = _model.potSetup(getString(potNames[currentPot]), getString(PotNamesFull[currentPot]), getString(potDes[currentPot]), value);
        progressBar.setProgress(_model.getTotalPercent());
        return next;
    }

    private int PotNext(int currentPot) throws Exception {
        if (currentPot < FIRST_POT || currentPot > LAST_POT) {
            throw new Exception("Can not insert pot");
        }
        int nextPot = this.insertPot(currentPot);
        //next pot setup

        uploadNewPot(nextPot);

        Log.d("Current bot at next", String.valueOf(nextPot));
        return nextPot;
    }

    private void uploadNewPot(int potNumber) {
        if (potNumber >= FIRST_POT && potNumber < MAX_POT) {
            potName.setText(potNames[potNumber]);
            PotDescription.setText(potDes[potNumber]);
            progressBar.current = potNumber;
        }
    }

    public void getItemView() {
        btnOk = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        potName = findViewById(R.id.PotName);
        PotDescription = findViewById(R.id.PotDescription);
        progressBar = (MySeekBar) findViewById(R.id.progressBar);
    }
}