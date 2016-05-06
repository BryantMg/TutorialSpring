package mx.edu.utng.springtutorial.rspgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 02/05/2016.
 */
public class ActivityRsp extends AppCompatActivity {

    Button btnRock, btnPaper, btnScissors;
    ImageView imvCpu,imvMe;
    String myChoise, cpuChoise,result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_rpsgame);
         imvCpu = (ImageView) findViewById(R.id.imv_cpu);
         imvMe = (ImageView) findViewById(R.id.imv_me);

        btnRock = (Button)findViewById(R.id.btn_rock);
        btnPaper = (Button)findViewById(R.id.btn_paper);
        btnScissors = (Button)findViewById(R.id.btn_scissors);
        r = new Random();

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "rock";
                imvMe.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "paper";
                imvMe.setImageResource(R.drawable.palma);
                calculate();
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoise = "scissors";
                imvMe.setImageResource(R.drawable.handsc);
                calculate();
            }
        });
    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu == 0){
            cpuChoise = "rock";
            imvCpu.setImageResource(R.drawable.rock);
        }else if(cpu == 1){
            cpuChoise = "paper";
            imvCpu.setImageResource(R.drawable.palma);
        }else if(cpu == 2){
            cpuChoise = "scissors";
            imvCpu.setImageResource(R.drawable.handsc);
        }

        if(myChoise.equals("rock")&&cpuChoise.equals("paper")){
            result = "Perdiste";
        }else if(myChoise.equals("rock")&&cpuChoise.equals("scissors")){
            result = "Ganaste";
        }else if(myChoise.equals("paper")&&cpuChoise.equals("rock")){
            result = "Ganaste";
        }else if(myChoise.equals("paper")&&cpuChoise.equals("scissors")){
            result = "Perdiste";
        }else if(myChoise.equals("scissors")&&cpuChoise.equals("paper")){
            result = "Ganaste";
        }else if(myChoise.equals("scissors")&&cpuChoise.equals("rock")){
            result = "Perdiste";
        }else if(myChoise.equals("rock")&&cpuChoise.equals("rock")){
            result = "Empate";
        }else if(myChoise.equals("paper")&&cpuChoise.equals("paper")){
            result = "Empate";
        }else if(myChoise.equals("scissors")&&cpuChoise.equals("scissors")){
            result = "Empate";
        }

        Toast.makeText(ActivityRsp.this,result,Toast.LENGTH_SHORT).show();
    }
}
