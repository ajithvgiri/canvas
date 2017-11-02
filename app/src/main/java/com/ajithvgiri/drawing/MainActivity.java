package com.ajithvgiri.drawing;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ajithvgiri.canvaslibrary.CanvasView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private CanvasView canvasView;
    private RelativeLayout parentView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_delete:
                    canvasView.clearCanvas();
                    break;
                case R.id.navigation_save:
                    parentView.setDrawingCacheEnabled(true);
                    if (!new PermissionUtils().storagePermission(MainActivity.this)) {
                        Toast.makeText(MainActivity.this, "Enable Storage Permission", Toast.LENGTH_SHORT).show();
                    } else {
                        saveCanvas();
                    }
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //canvasView = findViewById(R.id.canvasView);
        parentView = findViewById(R.id.parentView);
        canvasView = new CanvasView(MainActivity.this);
        parentView.addView(canvasView);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void saveCanvas() {

        Bitmap bitmap = parentView.getDrawingCache();

        final File Path = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Canvas");
        Path.mkdirs();
        String fileName = "Canvas-" + System.currentTimeMillis() + ".jpg";
        File saveFile = new File(Path, fileName);
        FileOutputStream FOS = null;
        try {
            FOS = new FileOutputStream(saveFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, FOS);
            FOS.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Canvas Saved", Toast.LENGTH_SHORT).show();
    }

}
