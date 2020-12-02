package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edmt.dev.androidgridlayout.Model.Student;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "student01.dat";
    GridLayout mainGrid;
    TextView text01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        text01 = (TextView) findViewById(R.id.text01);
        text01.setText("ok00011");
        save();load();
        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();
                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,ActivityOne.class);
                    intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    }
    public void save() {
        String text = "1/12";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            Log.d("t01", "Done save");
            ObjectOutputStream oStream = new ObjectOutputStream(fos); // dung de ghi theo Object vao file f
            oStream.writeObject(Student.wtiteS());   // ghi student theo kieu Object vao file
            oStream.close();
            Log.d("t01", "Done save");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  void load() {
        List<Student> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = openFileInput("student.dat");
            Log.d("t01", "Done strat try");
            ObjectInputStream inStream = new ObjectInputStream(fis);  // dung de doc theo Object vao file f
            Log.d("t01", "Done strat try02");
            // dung inStream doc theo Object, ep kieu tra ve la Student
            list = (List) inStream.readObject();
            inStream.close();
            Log.d("t01", "Size: " + list.size() + "");
            Log.d("t01", "Done load");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("t01", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("t01", e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.d("t01", e.getMessage());
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
